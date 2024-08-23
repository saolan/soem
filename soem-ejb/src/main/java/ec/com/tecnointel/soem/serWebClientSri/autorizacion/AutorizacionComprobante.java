package ec.com.tecnointel.soem.serWebClientSri.autorizacion;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autorizacionComprobante", propOrder = { "claveAccesoComprobante" })
public class AutorizacionComprobante {
	
	protected String claveAccesoComprobante;

	public String getClaveAccesoComprobante() {
		return this.claveAccesoComprobante;
	}

	public void setClaveAccesoComprobante(String value) {
		this.claveAccesoComprobante = value;
	}
}
