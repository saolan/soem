package ec.com.tecnointel.soem.seguridad.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Permiso;

@Local
public interface PermisoListaInt {

	public List<Permiso> buscarTodo(String columna) throws Exception;

	public List<Permiso> buscar(Permiso permiso, Integer pagina) throws Exception;

	public long contarRegistros(Permiso permiso) throws Exception;

	public void imprimir(Permiso permiso) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
