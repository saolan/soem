package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHoraDeta;

@Local
public interface EmplHoraDetaListaInt {

	public List<EmplHoraDeta> buscar(EmplHoraDeta emplHoraDeta, Integer pagina) throws Exception;

	public long contarRegistros(EmplHoraDeta emplHoraDeta) throws Exception;

	public void filasPagina(int filasPagina);
	
}
