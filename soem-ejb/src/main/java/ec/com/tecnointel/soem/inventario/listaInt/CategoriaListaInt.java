package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.Categoria;

@Local
public interface CategoriaListaInt {

	public List<Categoria> buscarTodo(String columna) throws Exception;

	public List<Categoria> buscar(Categoria categoria, Integer pagina) throws Exception;

	public long contarRegistros(Categoria categoria) throws Exception;

	public void imprimir(Categoria categoria) throws Exception;

}
