package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.Caja;

@Local
public interface CajaRegisInt {

	public Object insertar(Caja caja) throws Exception;

	public void modificar(Caja caja) throws Exception;

	public void eliminar(Caja caja) throws Exception;

	public Caja buscarPorId(Integer id) throws Exception;

}
