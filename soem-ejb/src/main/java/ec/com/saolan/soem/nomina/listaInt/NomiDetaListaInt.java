package ec.com.saolan.soem.nomina.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.NomiDeta;

@Local
public interface NomiDetaListaInt {

	public List<NomiDeta> buscar(NomiDeta nomiDeta, Integer pagina) throws Exception;

	public long contarRegistros(NomiDeta nomiDeta) throws Exception;

	public void filasPagina(int filasPagina);
	
}
