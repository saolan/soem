package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersActu;

@Local
public interface AcciPersActuRegisInt {

	public Object insertar(AcciPersActu acciPersActu) throws Exception;

	public void modificar(AcciPersActu acciPersActu) throws Exception;

	public void eliminar(AcciPersActu acciPersActu) throws Exception;

	public AcciPersActu buscarPorId(Integer id) throws Exception;

}
