package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrup;

@Local
public interface ProdGrupListaInt {

	public List<ProdGrup> buscarTodo(String columna) throws Exception;

	public List<ProdGrup> buscar(ProdGrup prodGup, Integer pagina) throws Exception;

	public long contarRegistros(ProdGrup prodGrup) throws Exception;

	public void imprimir(ProdGrup prodGrup) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
