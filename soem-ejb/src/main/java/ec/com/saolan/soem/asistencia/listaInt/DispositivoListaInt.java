package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Dispositivo;

@Local
public interface DispositivoListaInt {

	public List<Dispositivo> buscar(Dispositivo dispositivo, Integer pagina) throws Exception;

	public long contarRegistros(Dispositivo dispositivo) throws Exception;

	public void filasPagina(int filasPagina);
	
}
