package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraExtr;

@Local
public interface HoraExtrListaInt {

	public List<HoraExtr> buscar(HoraExtr horaExtr, Integer pagina) throws Exception;

	public long contarRegistros(HoraExtr horaExtr) throws Exception;

	public void filasPagina(int filasPagina);
	
}
