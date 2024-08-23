package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHora;

@Local
public interface EmplHoraListaInt {

	public List<EmplHora> buscar(EmplHora emplHora, Integer pagina) throws Exception;

	public long contarRegistros(EmplHora emplHora) throws Exception;

	public void filasPagina(int filasPagina);
	
}
