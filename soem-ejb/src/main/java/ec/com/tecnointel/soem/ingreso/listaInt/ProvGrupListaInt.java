package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.ProvGrup;

@Local
public interface ProvGrupListaInt {

	public List<ProvGrup> buscarTodo(String columna) throws Exception;

	public List<ProvGrup> buscar(ProvGrup provGrup, Integer pagina) throws Exception;

	public long contarRegistros(ProvGrup provGrup) throws Exception;

	public void imprimir(ProvGrup provGrup) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
