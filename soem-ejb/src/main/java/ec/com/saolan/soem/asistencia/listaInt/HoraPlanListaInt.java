package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraPlan;

@Local
public interface HoraPlanListaInt {

	public List<HoraPlan> buscar(HoraPlan horaPlan, Integer pagina) throws Exception;

	public long contarRegistros(HoraPlan horaPlan) throws Exception;

	public void filasPagina(int filasPagina);
	
}
