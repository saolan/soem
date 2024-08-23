package ec.com.tecnointel.soem.firmaElec.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.firmaElec.modelo.CertEmis;

@Local
public interface CertEmisRegisInt {
	
	public Object insertar(CertEmis certEmis) throws Exception;

	public void modificar(CertEmis certEmis) throws Exception;

	public void eliminar(CertEmis certEmis) throws Exception;

	public CertEmis buscarPorId(Integer id) throws Exception;

}
