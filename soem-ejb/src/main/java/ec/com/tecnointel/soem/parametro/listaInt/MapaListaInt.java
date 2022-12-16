package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Mapa;

@Local
public interface MapaListaInt {

	public List<Mapa> buscarTodo(String columna) throws Exception;

	public List<Mapa> buscar(Mapa mapa, Integer pagina) throws Exception;

	public long contarRegistros(Mapa mapa) throws Exception;

	public void imprimir(Mapa mapa) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
