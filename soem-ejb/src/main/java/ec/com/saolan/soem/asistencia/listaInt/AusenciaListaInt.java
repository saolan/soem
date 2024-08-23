package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Ausencia;

@Local
public interface AusenciaListaInt {

	public List<Ausencia> buscar(Ausencia ausencia, Integer pagina) throws Exception;

	public long contarRegistros(Ausencia ausencia) throws Exception;

	public void filasPagina(int filasPagina);
	
}
