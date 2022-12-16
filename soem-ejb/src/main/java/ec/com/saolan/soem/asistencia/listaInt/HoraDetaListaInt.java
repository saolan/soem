package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraDeta;

@Local
public interface HoraDetaListaInt {

	public List<HoraDeta> buscar(HoraDeta horaDeta, Integer pagina) throws Exception;

	public long contarRegistros(HoraDeta horaDeta) throws Exception;

	public void filasPagina(int filasPagina);
	
}
