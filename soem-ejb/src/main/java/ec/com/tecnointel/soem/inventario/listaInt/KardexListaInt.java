package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.Kardex;

@Local
public interface KardexListaInt {

	public List<Kardex> buscar(Kardex kardex, Integer pagina) throws Exception;

	public long contarRegistros(Kardex kardex) throws Exception;

	public Integer saldoProducto(Kardex kardex) throws Exception;

	public void filasPagina(int filasPagina);


	public List<Kardex> buscar(Kardex kardex) throws Exception;
}
