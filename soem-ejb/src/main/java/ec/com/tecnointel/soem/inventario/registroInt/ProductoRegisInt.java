package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.Producto;

@Local
public interface ProductoRegisInt {

	public Object insertar(Producto producto) throws Exception;

	public void modificar(Producto producto) throws Exception;

	public void eliminar(Producto producto) throws Exception;

	public Producto buscarPorId(Integer id) throws Exception;

}
