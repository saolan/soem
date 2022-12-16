package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AsisHora;

@Local
public interface AsisHoraListaInt {

	public List<AsisHora> buscar(AsisHora asisHora, Integer pagina) throws Exception;

	public long contarRegistros(AsisHora asisHora) throws Exception;

	public void filasPagina(int filasPagina);
	
}
