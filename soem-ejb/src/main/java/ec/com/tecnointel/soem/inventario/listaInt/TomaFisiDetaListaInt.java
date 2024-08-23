package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.TomaFisiDeta;

@Local
public interface TomaFisiDetaListaInt {
	
	public List<TomaFisiDeta> buscar(TomaFisiDeta tomaFisiDeta, Integer pagina) throws Exception;

	public long contarRegistros(TomaFisiDeta tomaFisiDeta) throws Exception;

	public void filasPagina(int filasPagina);

}
