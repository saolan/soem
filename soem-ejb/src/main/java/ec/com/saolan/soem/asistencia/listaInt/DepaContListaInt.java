package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.DepaCont;

@Local
public interface DepaContListaInt {

	public List<DepaCont> buscar(DepaCont depaCont, Integer pagina) throws Exception;

	public long contarRegistros(DepaCont depaCont) throws Exception;

	public void filasPagina(int filasPagina);
	
}
