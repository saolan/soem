package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.KardVaca;

@Local
public interface KardVacaListaInt {

	public List<KardVaca> buscar(KardVaca kardVaca, Integer pagina) throws Exception;

	public long contarRegistros(KardVaca kardVaca) throws Exception;

	public void filasPagina(int filasPagina);
	
}
