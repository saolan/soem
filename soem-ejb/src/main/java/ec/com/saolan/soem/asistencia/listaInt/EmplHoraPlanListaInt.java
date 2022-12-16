package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHoraPlan;

@Local
public interface EmplHoraPlanListaInt {

	public List<EmplHoraPlan> buscar(EmplHoraPlan emplHoraPlan, Integer pagina) throws Exception;

	public long contarRegistros(EmplHoraPlan emplHoraPlan) throws Exception;

	public void filasPagina(int filasPagina);
	
}
