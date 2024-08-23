package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuCertEmis;

@Local
public interface SucuCertEmisRegisInt {
	
	public Object insertar(SucuCertEmis sucuCertEmis) throws Exception;

	public void modificar(SucuCertEmis sucuCertEmis) throws Exception;

	public void eliminar(SucuCertEmis sucuCertEmis) throws Exception;

	public SucuCertEmis buscarPorId(Integer id) throws Exception;

}
