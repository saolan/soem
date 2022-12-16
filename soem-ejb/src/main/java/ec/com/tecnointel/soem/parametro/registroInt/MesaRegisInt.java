package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Mesa;

@Local
public interface MesaRegisInt {

	public Object insertar(Mesa mesa) throws Exception;

	public void modificar(Mesa mesa) throws Exception;

	public void eliminar(Mesa mesa) throws Exception;

	public Mesa buscarPorId(Integer id) throws Exception;

}
