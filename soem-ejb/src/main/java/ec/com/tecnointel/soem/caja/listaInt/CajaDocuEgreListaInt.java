package ec.com.tecnointel.soem.caja.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaDocuEgre;

@Local
public interface CajaDocuEgreListaInt {

	public List<CajaDocuEgre> buscarTodo(String columna) throws Exception;

	public List<CajaDocuEgre> buscar(CajaDocuEgre cajaDocuEgre, Integer pagina) throws Exception;

	public long contarRegistros(CajaDocuEgre cajaDocuEgre) throws Exception;

	public void imprimir(CajaDocuEgre cajaDocuEgre) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
