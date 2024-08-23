package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

@Local
public interface SucursalListaInt {

	public List<Sucursal> buscarTodo(String columna) throws Exception;

	public List<Sucursal> buscar(Sucursal sucursal, Integer pagina) throws Exception;
	
	public Sucursal buscarMatriz(Sucursal sucursal, Integer pagina) throws Exception;

	public long contarRegistros(Sucursal sucursal) throws Exception;

	public void filasPagina(int filasPagina);
	
	public Integer numeroEstablecimientos(Sucursal sucursal) throws Exception;
}
