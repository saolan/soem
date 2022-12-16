package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.CentCost;

@Local
public interface CentCostListaInt {

	public List<CentCost> buscar(CentCost centCost, Integer pagina) throws Exception;

	public long contarRegistros(CentCost centCost) throws Exception;

	public void filasPagina(int filasPagina);
	
}
