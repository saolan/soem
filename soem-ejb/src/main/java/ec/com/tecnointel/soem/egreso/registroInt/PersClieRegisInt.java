package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.PersClie;

@Local
public interface PersClieRegisInt {

	public Object insertar(PersClie persClie) throws Exception;

	public void modificar(PersClie persClie) throws Exception;

	public void eliminar(PersClie persClie) throws Exception;

	public PersClie buscarPorId(Integer id) throws Exception;

}
