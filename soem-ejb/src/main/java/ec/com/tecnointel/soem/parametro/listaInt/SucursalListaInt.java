package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

@Local
public interface SucursalListaInt {

	public List<Sucursal> buscarTodo(String columna) throws Exception;

	public List<Sucursal> buscar(Sucursal sucursal, Integer pagina) throws Exception;

	public long contarRegistros(Sucursal sucursal) throws Exception;

	public void imprimir(Sucursal sucursal) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
