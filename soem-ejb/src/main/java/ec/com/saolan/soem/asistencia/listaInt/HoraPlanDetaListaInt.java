package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraPlanDeta;

@Local
public interface HoraPlanDetaListaInt {

	public List<HoraPlanDeta> buscar(HoraPlanDeta horaPlanDeta, Integer pagina) throws Exception;

	public long contarRegistros(HoraPlanDeta horaPlanDeta) throws Exception;

	public void filasPagina(int filasPagina);
	
}
