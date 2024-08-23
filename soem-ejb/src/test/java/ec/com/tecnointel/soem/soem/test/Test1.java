package ec.com.tecnointel.soem.soem.test;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ec.com.tecnointel.soem.serWebClientSri.autorizacion.Autorizacion;
import ec.com.tecnointel.soem.serWebClientSri.general.ConvertidorXMLException;

public class Test1 {

	public static void main(String[] args) throws Exception {

		
		Autorizacion autorizacion = new Autorizacion();
				
		JAXBContext jaxbContext = JAXBContext.newInstance(Autorizacion.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

		autorizacion.setEstado("AUTORIZADO");
		autorizacion.setAmbiente("PRUEBAS");
		autorizacion.setComprobante(
				"<?xml version=1.0\" encoding=\"UTF-8\"?>" + "<factura id=\"comprobante\" version=\"1.1.0\">");

		GregorianCalendar ahora = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
		XMLGregorianCalendar fecha = DatatypeFactory.newInstance().newXMLGregorianCalendar(ahora);
		autorizacion.setFechaAutorizacion(fecha);

		autorizacion.setNumeroAutorizacion("1234567890123456789012345678901234567890123456789");

		setXMLCDATA(autorizacion);
//		jaxbMarshaller.marshal(autorizacion, new File("c:\\saolan\\output.xml"));
//		jaxbMarshaller.marshal(autorizacion, System.out);

//		JAXBElement<Autorizacion> jaxbElement 
//        = new JAXBElement<Autorizacion>( new QName("", "autorizacion"), Autorizacion.class, autorizacion);
//		jaxbMarshaller.marshal(jaxbElement, writer);

//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
		
		// Marshalling to string
		StringWriter writer = new StringWriter();
		jaxbMarshaller.marshal(autorizacion, writer);
		
//		byte[] outByte = outputStream.toByteArray();

//		FileOutputStream fileOutputStream = new FileOutputStream("c:\\saolan\\output4.xml");
//		fileOutputStream.write(outByte);
//		fileOutputStream.close();
		
		String xmlString = writer.toString();
//		xmlString.getBytes(Charset.forName("UTF-8"));
		// Replace escaped CDATA with actual CDATA
		xmlString = xmlString.replace("&lt;", "<").replace("&gt;", ">");
		System.out.println(xmlString);
        // Escribir XML a un archivo
//        File archivo = new File("c:\\saolan\\output5.xml");
//        FileWriter fileWriter = new FileWriter(archivo);
//        fileWriter.write(xmlString);
//        fileWriter.close();

//		marshalAutorizacion(autorizacion);
//		marshalAutorizacion2(autorizacion);
//		marshalAutorizacion3(autorizacion);
//		marshalAutorizacion4(autorizacion);
		marshalAutorizacion4();
	}

	private static void setXMLCDATA(Autorizacion autorizacion) {
//		autorizacion.setComprobante("<![CDATA[" + autorizacion.getComprobante() + "]]>");
		autorizacion.setComprobante(autorizacion.getComprobante());
	}

	private static byte[] obtenerRepuestaAutorizacionXML() throws ConvertidorXMLException {
		try {
//			XStream xstream = XStreamUtil.getRespuestaXStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
//			setXMLCDATA(autorizacion);
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//			xstream.toXML(autorizacion, writer);
			return outputStream.toByteArray();
		} catch (IOException e) {
			throw new ConvertidorXMLException("Se produjo un error al convetir el archivo al formato XML", e);
		}
	}

	public static String marshalAutorizacion(Autorizacion autorizacion) throws Exception {

		String estado = null;

		JAXBContext context = JAXBContext.newInstance(new Class[] { Autorizacion.class });

		Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		OutputStreamWriter out = new OutputStreamWriter(byteArrayOutputStream, "UTF-8");
		marshaller.marshal(autorizacion, out);

		StringWriter writer = new StringWriter();
		String xmlString = writer.toString();

		OutputStream outputStream = new FileOutputStream("c:\\saolan\\output.xml");
		byteArrayOutputStream.writeTo(outputStream);
		byteArrayOutputStream.close();
		outputStream.close();

		return estado;
	}

	public static String marshalAutorizacion2(Autorizacion autorizacion) throws Exception {

		System.out.println("marshalAutorizacion2");
		
		JAXBContext context = JAXBContext.newInstance(Autorizacion.class);
		Marshaller marshaller = context.createMarshaller();

		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); // Desactivar la inclusión de la declaración XML

		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		marshaller.marshal(autorizacion, byteArrayOutputStream);

		// Convertir ByteArrayOutputStream a String sin escape de caracteres
		String xmlString = byteArrayOutputStream.toString("UTF-8");
		xmlString = xmlString.replace("&lt;", "<").replace("&gt;", ">");

		// Imprimir el XML generado
		System.out.println(xmlString);

		// Escribir el XML a un archivo
		try (OutputStream outputStream = new FileOutputStream("c:\\saolan\\output2.xml")) {
			byteArrayOutputStream.writeTo(outputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xmlString;
	}

	public static String marshalAutorizacion3(Autorizacion autorizacion) throws Exception {

		System.out.println("marshalAutorizacion3");
		
        JAXBContext context = JAXBContext.newInstance(Autorizacion.class);
        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE); // Desactivar la inclusión de la declaración XML

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        marshaller.marshal(autorizacion, byteArrayOutputStream);

        // Convertir ByteArrayOutputStream a String sin escape de caracteres
        String xmlString = new String(byteArrayOutputStream.toByteArray());

        xmlString = xmlString.replace("&lt;", "<").replace("&gt;", ">");
        // Imprimir el XML generado
        System.out.println(xmlString);

        // Escribir el XML a un archivo
        try (OutputStream outputStream = new FileOutputStream("c:\\saolan\\output3.xml")) {
            byteArrayOutputStream.writeTo(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return xmlString;
	}
	
	public static String marshalAutorizacion4() throws Exception {

		Autorizacion autorizacion = new Autorizacion();
		
		autorizacion.setEstado("AUTORIZADO");
		autorizacion.setNumeroAutorizacion("1234567890123456789012345678901234567890123456789");
//		autorizacion.setFechaAutorizacion(null);
		autorizacion.setAmbiente("PRUEBAS");
//		setXMLCDATA(autorizacion);
		autorizacion.setComprobante(autorizacion.getComprobante());
		autorizacion.setComprobante(
				"<?xml version=1.0\" encoding=\"UTF-8\"?>" + "<factura id=\"comprobante\" version=\"1.1.0\">");
				
		String respuesta = null;

		JAXBContext context = JAXBContext.newInstance(new Class[] { Autorizacion.class });
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.encoding", "UTF-8");
		marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
		OutputStreamWriter out = new OutputStreamWriter(
				new FileOutputStream("c:\\saolan\\output6.xml"),
				"UTF-8");
		marshaller.marshal(autorizacion, out);
		out.close();

		return respuesta;
	}
}