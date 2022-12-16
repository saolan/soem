package ec.com.tecnointel.soem.documeElec.registroImp;

//import ec.gob.sri.firmaxades.test.FirmasGenericasXAdES;
//import ec.gob.sri.firmaxades.test.ValidacionBasica;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.x509.extension.X509ExtensionUtil;
import org.xml.sax.SAXException;

import ec.com.tecnointel.soem.documeElec.firma.FirmasGenericasXAdES;
import ec.com.tecnointel.soem.documeElec.firma.ValidacionBasica;
import ec.com.tecnointel.soem.documeElec.general.X500NameGeneral;
import ec.com.tecnointel.soem.documeElec.key.KeyStoreProviderFactory;
import ec.com.tecnointel.soem.documeElec.modelo.AutoridadesCertificantes;
import ec.com.tecnointel.soem.documeElec.registroInt.X509UtilsInt;

public class X509UtilsImp implements X509UtilsInt, Serializable {

	public static final int digitalSignature = 0;
	public static final int nonRepudiation = 1;
	public static final int keyEncipherment = 2;
	public static final int dataEncipherment = 3;
	public static final int keyAgreement = 4;
	public static final int keyCertSign = 5;
	public static final int cRLSign = 6;

	private static final long serialVersionUID = 4014858088917866229L;

	public static boolean puedeFirmar(X509Certificate cert) {
		boolean resp = false;
		if (cert.getKeyUsage() == null) {
			resp = true;
		}

		// Esta asi en el sistema original
		// if ((cert.getKeyUsage()[0] != 0) || (cert.getKeyUsage()[1] != 0)) {
		// resp = true;
		// }

		if ((cert.getKeyUsage()[0]) || (cert.getKeyUsage()[1])) {
			resp = true;
		}

		return resp;
	}

	public static String getUsage(X509Certificate cert) {

		StringBuilder sb = new StringBuilder();

		if (cert.getKeyUsage() == null) {

			sb.append("no key usage defined for certificate");

		} else {
			if (cert.getKeyUsage()[0]) {
				sb.append(" digitalSignature ");
			}
			if (cert.getKeyUsage()[6]) {
				sb.append(" cRLSign ");
			}
			if (cert.getKeyUsage()[3]) {
				sb.append(" dataEncipherment ");
			}
			if (cert.getKeyUsage()[4]) {
				sb.append(" keyAgreement ");
			}
			if (cert.getKeyUsage()[5]) {
				sb.append(" keyCertSign ");
			}
			if (cert.getKeyUsage()[2]) {
				sb.append(" keyEncipherment ");
			}
			if (cert.getKeyUsage()[1]) {
				sb.append(" nonRepudiation ");
			}
		}
		return sb.toString();
	}

	public static String getExtensionIdentifier(X509Certificate cert, String oid) throws IOException {
		String id = null;
		DERObject derObject = null;
		byte[] extensionValue = cert.getExtensionValue(oid);

		if ((cert.getIssuerDN().toString().contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getCn()))
				|| (cert.getIssuerDN().toString().contains(AutoridadesCertificantes.UANATACA.getCn()))
				|| (cert.getIssuerDN().toString().contains(AutoridadesCertificantes.ECLIPSOFT.getCn()))) {

			try {
				derObject = buscarRucConsejoJudicatura(cert, oid);
			} catch (CertificateParsingException ex) {

				// Logger.getLogger(X509Utils.class.getName()).log(Level.SEVERE,
				// null, ex);
			}
		}
		if (extensionValue != null) {
			derObject = toDERObject(extensionValue);
			if ((derObject instanceof DEROctetString)) {
				DEROctetString derOctetString = (DEROctetString) derObject;
				derObject = toDERObject(derOctetString.getOctets());
			}
		}
		if (derObject != null) {
			id = derObject.toString();
		} else {
			id = null;
		}
		return id;
	}

	private static DERObject buscarRucConsejoJudicatura(X509Certificate cert, String oid)
			throws CertificateParsingException {
		DERObject derObject = null;
		Collection<List> coleccionDatosAlternativos = X509ExtensionUtil.getSubjectAlternativeNames(cert);
		Iterator iteradorColeccion = coleccionDatosAlternativos.iterator();
		while (iteradorColeccion.hasNext()) {
			List<Object> listaDatosAlternativo = (List) iteradorColeccion.next();
			for (Object datoAlternativo : listaDatosAlternativo) {
				if ((datoAlternativo instanceof DERSequence)) {
					DERSequence datoDERSequence = (DERSequence) datoAlternativo;
					DERObjectIdentifier derObjectIdentifier = (DERObjectIdentifier) datoDERSequence.getObjectAt(0);
					if (derObjectIdentifier.toString().equals(oid)) {
						DERTaggedObject derTaggedObject = (DERTaggedObject) datoDERSequence.getObjectAt(1);
						return (DERUTF8String) derTaggedObject.getObject().toASN1Object();
					}
				}
			}
		}
		return derObject;
	}

	public static DERObject toDERObject(byte[] data) throws IOException {
		ByteArrayInputStream inStream = new ByteArrayInputStream(data);
		ASN1InputStream derInputStream = new ASN1InputStream(inStream);
		return derInputStream.readObject();
	}

	public static String seleccionarCertificado(KeyStore keyStore, String tokenSeleccionado)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateExpiredException,
			CertificateNotYetValidException, CertificateException {

		String aliasSeleccion = null;
		X509Certificate certificado = null;
		Enumeration nombres = keyStore.aliases();

		while (nombres.hasMoreElements()) {
			String aliasKey = (String) nombres.nextElement();
			certificado = (X509Certificate) keyStore.getCertificate(aliasKey);

			X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
			X500NameGeneral x500sujeto = new X500NameGeneral(certificado.getSubjectDN().getName());
			if (((tokenSeleccionado.equals("SD_BIOPASS")) || (tokenSeleccionado.equals("SD_EPASS3000")))
					&& ((x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA.getCn()))
							|| (x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA_SUB_1.getCn()))
							|| (x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA_SUB_2.getCn())))) {
				if ((AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
				if ((AutoridadesCertificantes.SECURITY_DATA_SUB_1.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
				if ((AutoridadesCertificantes.SECURITY_DATA_SUB_2.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("BCE_ALADDIN")) || ((tokenSeleccionado.equals("BCE_IKEY2032"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.BANCO_CENTRAL.getCn())))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO()))
						&& (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500emisor.getC()))
						&& (x500sujeto.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO()))
						&& (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("ANF1"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ANF.getCn()))) {
				if ((AutoridadesCertificantes.ANF.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.ANF.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.ANF.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("ANF1"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ANF_ECUADOR_CA1.getCn()))) {
				if ((AutoridadesCertificantes.ANF_ECUADOR_CA1.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.ANF_ECUADOR_CA1.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.ANF_ECUADOR_CA1.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("KEY4_CONSEJO_JUDICATURA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getO()))
						&& (AutoridadesCertificantes.CONSEJO_JUDICATURA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.CONSEJO_JUDICATURA.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("TOKENME_UANATACA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.UANATACA.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.UANATACA.getO()))
						&& (AutoridadesCertificantes.UANATACA.getC().equals(x500emisor.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("Eclipsoft"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ECLIPSOFT.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.ECLIPSOFT.getO()))
						&& (AutoridadesCertificantes.ECLIPSOFT.getC().equals(x500emisor.getC()))) {
					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			} else if ((tokenSeleccionado.equals("DATILMEDIA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.DATILMEDIA.getCn()))) {
				if ((AutoridadesCertificantes.DATILMEDIA.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.DATILMEDIA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.DATILMEDIA.getC().equals(x500sujeto.getC()))) {
					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {
						aliasSeleccion = aliasKey;
						break;
					}
				}
			}
		}
		return aliasSeleccion;

	}

	public static String seleccionarCertificado(KeyStore keyStore, String tokenSeleccionado, String rucEmisor)
			throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateExpiredException,
			CertificateNotYetValidException, CertificateException {

		String aliasSeleccion = null;
		X509Certificate certificado = null;
		Enumeration nombres = keyStore.aliases();

		while (nombres.hasMoreElements()) {
			String aliasKey = (String) nombres.nextElement();
			certificado = (X509Certificate) keyStore.getCertificate(aliasKey);

			X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
			X500NameGeneral x500sujeto = new X500NameGeneral(certificado.getSubjectDN().getName());
			if (((tokenSeleccionado.equals("SD_BIOPASS")) || (tokenSeleccionado.equals("SD_EPASS3000")))
					&& ((x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA.getCn()))
							|| (x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA_SUB_1.getCn()))
							|| (x500emisor.getCN().contains(AutoridadesCertificantes.SECURITY_DATA_SUB_2.getCn())))) {
				if ((AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
				if ((AutoridadesCertificantes.SECURITY_DATA_SUB_1.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_1.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
				if ((AutoridadesCertificantes.SECURITY_DATA_SUB_2.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getO().equals(x500sujeto.getO()))
						&& (AutoridadesCertificantes.SECURITY_DATA_SUB_2.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("BCE_ALADDIN")) || ((tokenSeleccionado.equals("BCE_IKEY2032"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.BANCO_CENTRAL.getCn())))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO()))
						&& (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500emisor.getC()))
						&& (x500sujeto.getO().contains(AutoridadesCertificantes.BANCO_CENTRAL.getO()))
						&& (AutoridadesCertificantes.BANCO_CENTRAL.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("ANF1"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ANF.getCn()))) {
				if ((AutoridadesCertificantes.ANF.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.ANF.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.ANF.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("ANF1"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ANF_ECUADOR_CA1.getCn()))) {
				if ((AutoridadesCertificantes.ANF_ECUADOR_CA1.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.ANF_ECUADOR_CA1.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.ANF_ECUADOR_CA1.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("KEY4_CONSEJO_JUDICATURA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getO()))
						&& (AutoridadesCertificantes.CONSEJO_JUDICATURA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.CONSEJO_JUDICATURA.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("TOKENME_UANATACA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.UANATACA.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.UANATACA.getO()))
						&& (AutoridadesCertificantes.UANATACA.getC().equals(x500emisor.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("Eclipsoft"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.ECLIPSOFT.getCn()))) {
				if ((x500emisor.getO().contains(AutoridadesCertificantes.ECLIPSOFT.getO()))
						&& (AutoridadesCertificantes.ECLIPSOFT.getC().equals(x500emisor.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			} else if ((tokenSeleccionado.equals("DATILMEDIA"))
					&& (x500emisor.getCN().contains(AutoridadesCertificantes.DATILMEDIA.getCn()))) {
				if ((AutoridadesCertificantes.DATILMEDIA.getO().equals(x500emisor.getO()))
						&& (AutoridadesCertificantes.DATILMEDIA.getC().equals(x500emisor.getC()))
						&& (AutoridadesCertificantes.DATILMEDIA.getC().equals(x500sujeto.getC()))) {

					if ((certificado.getKeyUsage()[0]) || (certificado.getKeyUsage()[1])) {

						String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
						if (rucEmisor.equals(rucCertificado)) {
							aliasSeleccion = aliasKey;
							break;
						}
					}
				}
			}
		}

		return aliasSeleccion;
	}

	@Override
	public String firmaValidaArchivo(File archivo, String rutaFirmados, String rucEmisor, String tokenId,
			String password, String variosCertificados) {
//	public String firmaValidaArchivo(File archivo, String dirPathSalida, String rucEmisor, TokensValidos tokenID, String password)  {

		String aliasKey = null;
		String respuesta = "GENERADO";

		PrivateKey clavePrivada = null;
		KeyStore keyStore = null;

		try {

			if (System.getProperty("os.name").startsWith("Windows")) {

				keyStore = KeyStore.getInstance("Windows-MY");
				keyStore.load(null, null);
				// codigo comentado no se decifra cual es la funcion ya que no retorna ningun
				// valor ni afecta a ninguna variable global
//				fixAliases(ks);
			} else if (keyStore == null) {

				keyStore = KeyStoreProviderFactory.createKeyStoreProvider().getKeystore(password.toCharArray());

			} else {
				respuesta = "Sistema operativo o JRE no compatible los los tokens de firma";
			}

//			aliaskey = seleccionarCertificado(ks, tokenID);

//			Control para determinar si esta instalado mas de una forma digital
//			se utiliza cuando se instala dos sistemas con diferente ruc en el mismo servidor
			if (variosCertificados.equals("varios")) {
				aliasKey = seleccionarCertificado(keyStore, tokenId, rucEmisor);
			} else {
				aliasKey = seleccionarCertificado(keyStore, tokenId);
			}

			if (password == null) {
				clavePrivada = (PrivateKey) keyStore.getKey(aliasKey, null);
			} else {
				KeyStore tmpKs = keyStore;

				PrivateKey key = (PrivateKey) tmpKs.getKey(aliasKey, password.toCharArray());
				clavePrivada = key;
			}

			if (aliasKey != null) {

				String archivoFirmado = rutaFirmados + File.separator + archivo.getName();

				Provider provider = null;
				if ((System.getProperty("os.name").toUpperCase().indexOf("MAC") == 0)
						&& (!KeyStoreProviderFactory.existeLibreriaMac())) {
					provider = Security.getProvider("SunRsaSign");
				} else {
					provider = keyStore.getProvider();
				}

				FirmasGenericasXAdES firmador = new FirmasGenericasXAdES();
				X509Certificate certificado = (X509Certificate) keyStore.getCertificate(aliasKey);

				certificado.checkValidity(new GregorianCalendar().getTime());

				String rucCertificado = getExtensionIdentifier(certificado, obtenerOidAutoridad(certificado));
				if ((rucEmisor.equals(rucCertificado)) && (clavePrivada != null)) {

					firmador.ejecutarFirmaXades(archivo.getAbsolutePath(), null, archivoFirmado, provider, certificado,
							clavePrivada);

//					Aqui se crea y valida el archivo firmado
					if (!new ValidacionBasica().validarArchivo(new File(archivoFirmado))) {
						respuesta = "Se ha producido un error al momento de crear la firma. firma digital no es válida";
					} else {
						respuesta = "FIRMADO";
					}

					if (System.getProperty("os.name").startsWith("Windows") == true) {
						keyStore.load(null, null);
					}

				} else if (rucCertificado == null) {
					respuesta = "El certificado digital proporcionado no posee los datos de RUC OID: 1.3.6.1.4.1.37XXX.3.11. Favor actualize su certificado digital con la Autoridad Certificadora";
				} else if (clavePrivada == null) {
					respuesta = "No se pudo acceder a la clave privada del certificado";
				} else {
					respuesta = "El Ruc presente en el certificado digital no coincide con el Ruc registrado en el aplicativo";
				}
			} else {
				respuesta = "No se pudo encontrar un certificado válido para firmar el archivo";
			}
		} catch (CertificateExpiredException e) {
			e.printStackTrace();
			return "El certificado con el que intenta firmar el comprobante esta expirado favor actualize su certificado digital con la Autoridad Certificadora";
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return "Archivo XML a firmar mal definido o estructurado";
		} catch (SAXException e) {
			e.printStackTrace();
			return "Archivo XML a firmar mal definido o estructurado";
		} catch (Exception e) {
			e.printStackTrace();
			if (e.getMessage() == null) {
				respuesta = "Error al firmar archivo: No se pudo acceder a la clave privada del certificado";
			}

			return "Error al firmar archivo. " + e.getMessage();
		}

		return respuesta;
	}

//	public static String obtenerOidAutoridad(X509Certificate certificado) {
//		String oidRaiz = null;
//
//		X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
//		String nombreAutoridad = x500emisor.getCN();
//		
//		if (nombreAutoridad.contains(AutoridadesCertificantes.BANCO_CENTRAL.getCn())) {
//			oidRaiz = AutoridadesCertificantes.BANCO_CENTRAL.getOid();
//		} else if (nombreAutoridad.contains(AutoridadesCertificantes.ANF.getCn())) {
//			oidRaiz = AutoridadesCertificantes.ANF.getOid();
//		} else if (nombreAutoridad.contains(AutoridadesCertificantes.SECURITY_DATA.getCn())) {
//			oidRaiz = AutoridadesCertificantes.SECURITY_DATA.getOid();
//		} else if (nombreAutoridad.contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getCn())) {
//			oidRaiz = AutoridadesCertificantes.CONSEJO_JUDICATURA.getOid().concat(".1");
//		} else if (nombreAutoridad.contains(AutoridadesCertificantes.ANF_ECUADOR_CA1.getCn())) {
//			oidRaiz = AutoridadesCertificantes.ANF_ECUADOR_CA1.getOid();
//		}
//		
//		oidRaiz = oidRaiz.concat(".3.11");
//		return oidRaiz;
//	}

	public static String obtenerOidAutoridad(X509Certificate certificado) {
		String oidRaiz = null;

		X500NameGeneral x500emisor = new X500NameGeneral(certificado.getIssuerDN().getName());
		String nombreAutoridad = x500emisor.getCN();
		if (nombreAutoridad.contains(AutoridadesCertificantes.BANCO_CENTRAL.getCn())) {
			oidRaiz = AutoridadesCertificantes.BANCO_CENTRAL.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.ANF.getCn())) {
			oidRaiz = AutoridadesCertificantes.ANF.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.SECURITY_DATA.getCn())) {
			oidRaiz = AutoridadesCertificantes.SECURITY_DATA.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.SECURITY_DATA_SUB_1.getCn())) {
			oidRaiz = AutoridadesCertificantes.SECURITY_DATA_SUB_1.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.SECURITY_DATA_SUB_2.getCn())) {
			oidRaiz = AutoridadesCertificantes.SECURITY_DATA_SUB_2.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.CONSEJO_JUDICATURA.getCn())) {
			oidRaiz = AutoridadesCertificantes.CONSEJO_JUDICATURA.getOid().concat(".1");
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.ANF_ECUADOR_CA1.getCn())) {
			oidRaiz = AutoridadesCertificantes.ANF_ECUADOR_CA1.getOid();
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.UANATACA.getCn())) {
			oidRaiz = AutoridadesCertificantes.UANATACA.getOid().concat(".102");
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.ECLIPSOFT.getCn())) {
			oidRaiz = AutoridadesCertificantes.ECLIPSOFT.getOid().concat(".102");
		} else if (nombreAutoridad.contains(AutoridadesCertificantes.DATILMEDIA.getCn())) {
			oidRaiz = AutoridadesCertificantes.DATILMEDIA.getOid();
		}
		oidRaiz = oidRaiz.concat(".3.11");
		return oidRaiz;
	}

	private static void fixAliases(KeyStore keyStore) {
		try {
			// Codigo aumentado no esta en el fuente del SRI
			Field field;

			field = keyStore.getClass().getDeclaredField("keyStoreSpi");
			field.setAccessible(true);
			KeyStoreSpi keyStoreVeritable = (KeyStoreSpi) field.get(keyStore);

			if ("sun.security.mscapi.KeyStore$MY".equals(keyStoreVeritable.getClass().getName())) {

				field = keyStoreVeritable.getClass().getEnclosingClass().getDeclaredField("entries");
				field.setAccessible(true);

				Collection entries = (Collection) field.get(keyStoreVeritable);

				for (Object entry : entries) {
					field = entry.getClass().getDeclaredField("certChain");
					field.setAccessible(true);
					X509Certificate[] certificates = (X509Certificate[]) field.get(entry);

					String hashCode = Integer.toString(certificates[0].hashCode());

					field = entry.getClass().getDeclaredField("alias");
					field.setAccessible(true);
					String alias = (String) field.get(entry);
					if (!alias.equals(hashCode)) {
						field.set(entry, alias.concat(" - ").concat(hashCode));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
//			Field field;
		}
	}

}
