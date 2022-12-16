package ec.com.tecnointel.soem.documeElec.registroInt;

import java.io.File;

import javax.ejb.Local;

@Local
public interface X509UtilsInt {

//	public String firmaValidaArchivo(File archivo, String dirPathSalida, String rucEmisor, TokensValidos tokenID,
//			String password) throws Exception;

//	public String firmaValidaArchivo(File archivo, String dirPathSalida, String rucEmisor, String tokenID,
//			String password) throws Exception;

	public String firmaValidaArchivo(File archivo, String dirPathSalida, String rucEmisor, String tokenID,
			String password, String variosCertificados) throws Exception;

}
