package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AsisRegi;

@Local
public interface AsisRegiListaInt {

	public List<AsisRegi> buscar(AsisRegi asisRegi, Integer pagina) throws Exception;

	public long contarRegistros(AsisRegi asisRegi) throws Exception;

	public void filasPagina(int filasPagina);
	
}
