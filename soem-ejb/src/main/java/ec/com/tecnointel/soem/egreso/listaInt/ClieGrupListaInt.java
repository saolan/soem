package ec.com.tecnointel.soem.egreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrup;

@Local
public interface ClieGrupListaInt {

	public List<ClieGrup> buscarTodo(String columna) throws Exception;

	public List<ClieGrup> buscar(ClieGrup clieGrup, Integer pagina) throws Exception;

	public long contarRegistros(ClieGrup clieGrup) throws Exception;

	public void imprimir(ClieGrup clieGrup) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
