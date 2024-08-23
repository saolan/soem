package ec.com.tecnointel.soem.soem.test;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;

import ec.com.tecnointel.soem.serWebClientSri.autorizacion.Autorizacion;
import ec.com.tecnointel.soem.serWebClientSri.autorizacion.Mensaje;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class Test2 {

    public static void main(String[] args) {
        // Crear un objeto de tipo Autorizacion
        Autorizacion autorizacion = new Autorizacion();
        autorizacion.setEstado("Aprobado");
        autorizacion.setNumeroAutorizacion("123456");
        autorizacion.setAmbiente("Producción");
        autorizacion.setComprobante("<comprobante>contenido</comprobante>");

        // Establecer la fecha de autorización
        try {
            GregorianCalendar gcal = new GregorianCalendar();
            XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
            autorizacion.setFechaAutorizacion(xgcal);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        // Crear un objeto de tipo Mensajes y añadir un mensaje
        Autorizacion.Mensajes mensajes = new Autorizacion.Mensajes();
        Mensaje mensaje = new Mensaje();
        mensajes.getMensaje().add(mensaje);
        autorizacion.setMensajes(mensajes);

        // Generar el archivo XML
        generarXML(autorizacion, "autorizacion.xml");
    }

    public static void generarXML(Autorizacion autorizacion, String nombreArchivo) {
        try {
            // Crear un contexto JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(Autorizacion.class);

            // Crear un objeto Marshaller
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Formatear el XML
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//            marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));

            // Establecer el orden de los elementos manualmente
//            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true);

            // Escribir el objeto a un archivo XML
            marshaller.marshal(new JAXBElement<>(new QName("autorizacion"), Autorizacion.class, autorizacion), System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
