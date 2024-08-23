package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.Categoria;

@Local
public interface CategoriaRegisInt {

	public Object insertar(Categoria categoria) throws Exception;

	public void modificar(Categoria categoria) throws Exception;

	public void eliminar(Categoria categoria) throws Exception;

	public Categoria buscarPorId(Integer id) throws Exception;

}
