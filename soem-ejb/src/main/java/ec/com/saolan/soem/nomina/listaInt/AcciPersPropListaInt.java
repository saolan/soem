package ec.com.saolan.soem.nomina.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersProp;

@Local
public interface AcciPersPropListaInt {

	public List<AcciPersProp> buscar(AcciPersProp acciPersProp, Integer pagina) throws Exception;

	public long contarRegistros(AcciPersProp acciPersProp) throws Exception;

	public void filasPagina(int filasPagina);
	
}
