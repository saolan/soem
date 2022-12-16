package ec.com.tecnointel.soem.serWebClientSri.general;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.thoughtworks.xstream.XStream;

import ec.com.tecnointel.soem.general.util.Util;
import ec.com.tecnointel.soem.serWebClientSri.autorizacion.Autorizacion;
import ec.com.tecnointel.soem.serWebClientSri.autorizacion.Mensaje;
import ec.com.tecnointel.soem.serWebClientSri.autorizacion.RespuestaComprobante;

public class AutorizacionComprobantesUtil {

	private RespuestaComprobante respuestaComprobante;
	private String nombreArchivo;

	public AutorizacionComprobantesUtil(RespuestaComprobante respuestaComprobante, String nombreArchivo) {
		this.respuestaComprobante = respuestaComprobante;
		this.nombreArchivo = nombreArchivo;
	}

	public AutorizacionComprobantesUtil(RespuestaComprobante respuestaComprobante) {
		this.respuestaComprobante = respuestaComprobante;
	}

	public AutorizacionComprobantesUtil(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	// public void validarRespuestaAutorizacion(AutorizacionDTO autorizacionDTO)
	// throws DirectorioException, MergeRespuestaException,
	// RespuestaAutorizacionException, ConvertidorXMLException
	// {

	public void validarRespuestaAutorizacion(AutorizacionDTO autorizacionDTO, String rutaAutorizados)
			throws RespuestaAutorizacionException, ConvertidorXMLException {

		byte[] archivoRespuestaAutorizacionXML = obtenerRepuestaAutorizacionXML(autorizacionDTO.getAutorizacion());

		if (EstadoAutorizacion.AUT.equals(autorizacionDTO.getEstadoAutorizacion())) {
			// ArchivoUtils.crearArchivo(archivoRespuestaAutorizacionXML,
			// this.nombreArchivo, DirectorioEnum.AUTORIZADOS);
			Util.crearArchivo(archivoRespuestaAutorizacionXML, this.nombreArchivo, rutaAutorizados);

		} else {

			if (EstadoAutorizacion.NAU.equals(autorizacionDTO.getEstadoAutorizacion())) {
				// ArchivoUtils.crearArchivo(archivoRespuestaAutorizacionXML,
				// this.nombreArchivo, DirectorioEnum.NO_AUTORIZADOS);
//				Util.crearArchivo(archivoRespuestaAutorizacionXML, this.nombreArchivo, "TempNoAutorizados");
				throw new RespuestaAutorizacionException(
						String.format("Error al validar el comprobante estado :",
								new Object[] { autorizacionDTO.getEstadoAutorizacion().getDescripcion(),
										autorizacionDTO.getMensaje() }));
			}

			if (EstadoAutorizacion.PRO.equals(autorizacionDTO.getEstadoAutorizacion())) {
				throw new RespuestaAutorizacionException(String.format("Error al validar el comprobante estado : ",
						new Object[] { autorizacionDTO.getEstadoAutorizacion().getDescripcion() }));
			}
		}
	}

	public AutorizacionDTO obtenerEstadoAutorizacion() {

		for (Autorizacion autorizacion : this.respuestaComprobante.getAutorizaciones().getAutorizacion()) {
			EstadoAutorizacion estadoAutorizacion = EstadoAutorizacion.getEstadoAutorizacion(autorizacion.getEstado());
			if (EstadoAutorizacion.AUT.equals(estadoAutorizacion)) {
				return new AutorizacionDTO(autorizacion, EstadoAutorizacion.AUT);
			}
			if (EstadoAutorizacion.PRO.equals(estadoAutorizacion)) {
				return new AutorizacionDTO(autorizacion, EstadoAutorizacion.AUT);
			}
		}
		Autorizacion autorizacion = (Autorizacion) this.respuestaComprobante.getAutorizaciones().getAutorizacion()
				.get(0);

		return new AutorizacionDTO(autorizacion, EstadoAutorizacion.NAU, obtieneMensajesAutorizacion(autorizacion));
	}

	private void setXMLCDATA(Autorizacion autorizacion) {
		autorizacion.setComprobante("<![CDATA[" + autorizacion.getComprobante() + "]]>");
	}

	private byte[] obtenerRepuestaAutorizacionXML(Autorizacion autorizacion) throws ConvertidorXMLException {
		try {
			XStream xstream = XStreamUtil.getRespuestaXStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
			setXMLCDATA(autorizacion);
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			xstream.toXML(autorizacion, writer);
			return outputStream.toByteArray();
		} catch (IOException e) {
			throw new ConvertidorXMLException("Se produjo un error al convetir el archivo al formato XML", e);
		}
	}

	public static String obtieneMensajesAutorizacion(Autorizacion autorizacion) {
		StringBuilder mensaje = new StringBuilder();
		for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
			if (m.getInformacionAdicional() != null) {
				mensaje.append(String.format("\n%s:%s", new Object[] { m.getMensaje(), m.getInformacionAdicional() }));
			} else {
				mensaje.append(String.format("\n%s", new Object[] { m.getMensaje() }));
			}
		}
		return mensaje.toString();
	}

}
