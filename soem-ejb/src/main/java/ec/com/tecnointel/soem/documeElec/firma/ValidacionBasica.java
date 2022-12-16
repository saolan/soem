package ec.com.tecnointel.soem.documeElec.firma;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import es.mityc.firmaJava.libreria.xades.ResultadoValidacion;
import es.mityc.firmaJava.libreria.xades.ValidarFirmaXML;

public class ValidacionBasica {

//	private static final Logger LOG = Logger.getLogger(ValidacionBasica.class);
//	private static final String ARCHIVO_XADES_VALIDO = "/repositorio/factura-XAdES-BES.xml";

//	public static void main(String[] args) {
		// BasicConfigurator.configure();
		// Logger.getRootLogger().setLevel(Level.ERROR);
		// ValidacionBasica validador = new ValidacionBasica();
		// if
		// (validador.validarFichero(ValidacionBasica.class.getResourceAsStream("/repositorio/factura-XAdES-BES.xml")))
		// {
		// LOG.info("archivo valido");
		// }
//	}

	public boolean validarArchivo(File archivo) {
		ValidacionBasica validador = new ValidacionBasica();
		boolean esValido = false;
		try {
			InputStream is = new FileInputStream(archivo);
			esValido = validador.validarFichero(is);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return esValido;
	}

	public boolean validarFichero(InputStream archivo) {
		boolean esValido = true;

		ArrayList<ResultadoValidacion> results = null;

		Document doc = parseaDoc(archivo);
		if (doc != null) {
			try {
				ValidarFirmaXML vXml = new ValidarFirmaXML();
				results = vXml.validar(doc, "./", null);
			} catch (Exception e) {
				e.printStackTrace();
			}
			ResultadoValidacion result = null;
			Iterator<ResultadoValidacion> it = results.iterator();
			while (it.hasNext()) {
				result = (ResultadoValidacion) it.next();
				esValido = result.isValidate();
//				if (esValido) {
					// LOG.info("La firma es valida = " + result.getNivelValido() + "\nFirmado el: "
					// + result.getDatosFirma().getFechaFirma());
//				} else {
					// LOG.info("La firma NO es valida\n" + result.getLog());
//				}
			}
		}
		
		return esValido;
	}

	private Document parseaDoc(InputStream fichero) {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);

		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return null;
		}
		Document doc = null;
		try {
			doc = db.parse(fichero);
			return doc;
		} catch (SAXException e) {
			doc = null;
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			dbf = null;
			db = null;
		}
		return null;
	}
}
