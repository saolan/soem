package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPers;

@Local
public interface AcciPersRegisInt {

	public Object insertar(AcciPers acciPers) throws Exception;

	public void modificar(AcciPers acciPers) throws Exception;

	public void eliminar(AcciPers acciPers) throws Exception;

	public AcciPers buscarPorId(Integer id) throws Exception;

}
