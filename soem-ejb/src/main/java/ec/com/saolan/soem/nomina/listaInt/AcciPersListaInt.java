package ec.com.saolan.soem.nomina.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPers;

@Local
public interface AcciPersListaInt {

	public List<AcciPers> buscar(AcciPers acciPers, Integer pagina) throws Exception;

	public long contarRegistros(AcciPers acciPers) throws Exception;

	public void filasPagina(int filasPagina);
	
}
