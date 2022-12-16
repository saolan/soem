package ec.com.tecnointel.soem.serWebClientSri.autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autorizacionComprobanteLoteResponse", namespace="http://ec.gob.sri.ws.autorizacion", propOrder = { "respuestaAutorizacionLote" })
public class AutorizacionComprobanteLoteResponse {
	
	@XmlElement(name = "RespuestaAutorizacionLote")
	protected RespuestaLote respuestaAutorizacionLote;

	public RespuestaLote getRespuestaAutorizacionLote() {
		return this.respuestaAutorizacionLote;
	}

	public void setRespuestaAutorizacionLote(RespuestaLote value) {
		this.respuestaAutorizacionLote = value;
	}
}
