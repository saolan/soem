package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

@Local
public interface SucursalRegisInt {

	public Object insertar(Sucursal sucursal) throws Exception;

	public void modificar(Sucursal sucursal) throws Exception;

	public void eliminar(Sucursal sucursal) throws Exception;

	public Sucursal buscarPorId(Integer id) throws Exception;

}
