package ec.com.tecnointel.soem.firmaElec.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuCertEmis;

@Local
public interface FirmarArchivoInt {
	
	void signBes(SucuCertEmis sucuCertEmis, String nombreArchivo, String rutaGenerados, String rutaFirmado) throws Exception;
	
}
