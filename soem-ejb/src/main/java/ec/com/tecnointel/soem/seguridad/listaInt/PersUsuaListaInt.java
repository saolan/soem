package ec.com.tecnointel.soem.seguridad.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;

@Local
public interface PersUsuaListaInt {

	public List<PersUsua> buscarTodo(String columna) throws Exception;

	public List<PersUsua> buscar(PersUsua persUsua, Integer pagina) throws Exception;

	public long contarRegistros(PersUsua persUsua) throws Exception;

	public void imprimir(PersUsua persUsua) throws Exception;

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public PersUsua buscar(PersUsua persUsua) throws Exception;

	public void filasPagina(int filasPagina);

	// public PersUsua buscarUsuario(PersUsua persUsua) throws Exception;
}
