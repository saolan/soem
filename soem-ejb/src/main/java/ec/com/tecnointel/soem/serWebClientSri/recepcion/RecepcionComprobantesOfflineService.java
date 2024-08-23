package ec.com.tecnointel.soem.serWebClientSri.recepcion;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name="RecepcionComprobantesOfflineService", targetNamespace="http://ec.gob.sri.ws.recepcion", wsdlLocation="/META-INF/wsdl/RecepcionComprobantes.wsdl")
public class RecepcionComprobantesOfflineService extends Service {

	private static final URL RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	private static final WebServiceException RECEPCIONCOMPROBANTESSERVICE_EXCEPTION;
	private static final QName RECEPCIONCOMPROBANTESSERVICE_QNAME = new QName("http://ec.gob.sri.ws.recepcion",
			"RecepcionComprobantesOfflineService");

	static {

		RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION = RecepcionComprobantesOfflineService.class
				.getResource("/META-INF/wsdl/RecepcionComprobantes.wsdl");
		WebServiceException e = null;
		if (RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION == null) {
			e = new WebServiceException(
					"Cannot find '/META-INF/wsdl/RecepcionComprobantes.wsdl' wsdl. Place the resource correctly in the classpath.");
		}
		RECEPCIONCOMPROBANTESSERVICE_EXCEPTION = e;
	}

	public RecepcionComprobantesOfflineService() {
		super(__getWsdlLocation(), RECEPCIONCOMPROBANTESSERVICE_QNAME);
	}

	public RecepcionComprobantesOfflineService(URL wsdlLocation) {
		super(wsdlLocation, RECEPCIONCOMPROBANTESSERVICE_QNAME);
	}

	public RecepcionComprobantesOfflineService(URL wsdlLocation, QName serviceName) {
		super(wsdlLocation, serviceName);
	}

	@WebEndpoint(name = "RecepcionComprobantesOfflinePort")
	public RecepcionComprobantesOffline getRecepcionComprobantesOfflinePort() {
		return (RecepcionComprobantesOffline) super.getPort(
				new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflinePort"),
				RecepcionComprobantesOffline.class);
	}

	@WebEndpoint(name = "RecepcionComprobantesOfflinePort")
	public RecepcionComprobantesOffline getRecepcionComprobantesOfflinePort(WebServiceFeature... features) {
		return (RecepcionComprobantesOffline) super.getPort(
				new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesOfflinePort"),
				RecepcionComprobantesOffline.class, features);
	}

	private static URL __getWsdlLocation() {
		if (RECEPCIONCOMPROBANTESSERVICE_EXCEPTION != null) {
			throw RECEPCIONCOMPROBANTESSERVICE_EXCEPTION;
		}
		return RECEPCIONCOMPROBANTESSERVICE_WSDL_LOCATION;
	}

}
