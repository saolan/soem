package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdSubp;

@Local
public interface ProdSubpListaInt {
	
	public List<ProdSubp> buscar(ProdSubp prodSubp, Integer pagina) throws Exception;

	public long contarRegistros(ProdSubp prodSubp) throws Exception;

	public void filasPagina(int filasPagina);

}
