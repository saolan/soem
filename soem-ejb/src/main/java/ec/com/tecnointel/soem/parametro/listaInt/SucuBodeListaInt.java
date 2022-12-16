package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuBode;

@Local
public interface SucuBodeListaInt {

	public List<SucuBode> buscarTodo(String columna) throws Exception;

	public List<SucuBode> buscar(SucuBode sucuBode, Integer pagina) throws Exception;

	public long contarRegistros(SucuBode sucuBode) throws Exception;

	public void imprimir(SucuBode sucuBode) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
