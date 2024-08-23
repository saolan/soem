package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.PersEmpl;

@Local
public interface PersEmplListaInt {

	public List<PersEmpl> buscar(PersEmpl persEmpl, Integer pagina) throws Exception;

	public long contarRegistros(PersEmpl persEmpl) throws Exception;

	public void filasPagina(int filasPagina);
	
}
