package ec.com.tecnointel.soem.egreso.listaInt;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.Egreso;

@Local
public interface EgresoListaInt {

	public void filasPagina(int filasPagina);
	
	public void orden(String orden);

	
	public List<Egreso> buscarTodo(String columna) throws Exception;

	public List<Egreso> buscar(Egreso egreso, Integer pagina, Set<Integer> sucursals) throws Exception;

	public long contarRegistros(Egreso egreso, Set<Integer> sucursals) throws Exception;

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
