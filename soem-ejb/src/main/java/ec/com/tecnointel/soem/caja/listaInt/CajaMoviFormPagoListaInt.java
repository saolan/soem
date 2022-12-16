package ec.com.tecnointel.soem.caja.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviFormPago;

@Local
public interface CajaMoviFormPagoListaInt {

	public List<CajaMoviFormPago> buscarTodo(String columna) throws Exception;

	public List<CajaMoviFormPago> buscar(CajaMoviFormPago cajaMoviFormPago, Integer pagina) throws Exception;

	public long contarRegistros(CajaMoviFormPago cajaMoviFormPago) throws Exception;

	public void imprimir(CajaMoviFormPago cajaMoviFormPago) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
