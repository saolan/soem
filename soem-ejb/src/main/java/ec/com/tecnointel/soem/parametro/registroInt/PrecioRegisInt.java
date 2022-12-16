package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Precio;

@Local
public interface PrecioRegisInt {

	public Object insertar(Precio precio) throws Exception;

	public void modificar(Precio precio) throws Exception;

	public void eliminar(Precio precio) throws Exception;

	public Precio buscarPorId(Integer id) throws Exception;

}
