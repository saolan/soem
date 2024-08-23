package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdTipo;

@Local
public interface ProdTipoListaInt {

	public List<ProdTipo> buscarTodo(String columna) throws Exception;

	public List<ProdTipo> buscar(ProdTipo prodTipo, Integer pagina) throws Exception;

	public long contarRegistros(ProdTipo prodTipo) throws Exception;

	public void imprimir(ProdTipo prodTipo) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
