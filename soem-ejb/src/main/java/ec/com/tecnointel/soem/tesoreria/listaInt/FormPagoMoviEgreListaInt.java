package ec.com.tecnointel.soem.tesoreria.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviEgre;

@Local
public interface FormPagoMoviEgreListaInt {

	public void filasPagina(int filasPagina);
	
	
	public List<FormPagoMoviEgre> buscarTodo(String columna) throws Exception;

	public List<FormPagoMoviEgre> buscar(FormPagoMoviEgre formPagoMoviEgre, Integer pagina) throws Exception;
	
	public long contarRegistros(FormPagoMoviEgre formPagoMoviEgre) throws Exception;

	List<FormPagoMoviEgre> buscarTransaccion(FormPagoMoviEgre formPagoMoviEgre) throws Exception;

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
