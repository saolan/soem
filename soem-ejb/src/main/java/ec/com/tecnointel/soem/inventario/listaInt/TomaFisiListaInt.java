package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.TomaFisi;

@Local
public interface TomaFisiListaInt {
	
	public List<TomaFisi> buscar(TomaFisi tomaFisi, Integer pagina) throws Exception;

	public long contarRegistros(TomaFisi tomaFisi) throws Exception;

	public void filasPagina(int filasPagina);

}
