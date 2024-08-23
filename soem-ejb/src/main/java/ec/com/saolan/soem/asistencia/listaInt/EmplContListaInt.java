package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplCont;

@Local
public interface EmplContListaInt {

	public List<EmplCont> buscar(EmplCont emplCont, Integer pagina) throws Exception;

	public long contarRegistros(EmplCont emplCont) throws Exception;

	public void filasPagina(int filasPagina);
	
}
