package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplCargVaca;

@Local
public interface EmplCargVacaListaInt {

	public List<EmplCargVaca> buscar(EmplCargVaca emplCargVaca, Integer pagina) throws Exception;

	public long contarRegistros(EmplCargVaca emplCargVaca) throws Exception;

	public void filasPagina(int filasPagina);
	
}
