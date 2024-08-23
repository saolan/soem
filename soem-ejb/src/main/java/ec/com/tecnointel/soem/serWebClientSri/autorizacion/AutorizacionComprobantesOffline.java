package ec.com.tecnointel.soem.serWebClientSri.autorizacion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(name = "AutorizacionComprobantesOffline", targetNamespace = "http://ec.gob.sri.ws.autorizacion")
@XmlSeeAlso({ ObjectFactory.class })
public abstract interface AutorizacionComprobantesOffline {
	
	@WebMethod
	@WebResult(name = "RespuestaAutorizacionComprobante", targetNamespace = "")
	@RequestWrapper(localName = "autorizacionComprobante", targetNamespace = "http://ec.gob.sri.ws.autorizacion", className = "ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobante")
	@ResponseWrapper(localName = "autorizacionComprobanteResponse", targetNamespace = "http://ec.gob.sri.ws.autorizacion", className = "ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteResponse")
	public abstract RespuestaComprobante autorizacionComprobante(@WebParam(name = "claveAccesoComprobante", targetNamespace = "") String paramString);

	@WebMethod
	@WebResult(name = "RespuestaAutorizacionLote", targetNamespace = "")
	@RequestWrapper(localName = "autorizacionComprobanteLote", targetNamespace = "http://ec.gob.sri.ws.autorizacion", className = "ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteLote")
	@ResponseWrapper(localName = "autorizacionComprobanteLoteResponse", targetNamespace = "http://ec.gob.sri.ws.autorizacion", className = "ec.gob.sri.comprobantes.ws.aut.AutorizacionComprobanteLoteResponse")
	public abstract RespuestaLote autorizacionComprobanteLote(
			@WebParam(name = "claveAccesoLote", targetNamespace = "") String paramString);
}
