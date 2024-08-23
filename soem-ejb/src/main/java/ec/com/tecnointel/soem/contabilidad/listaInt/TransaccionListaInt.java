package ec.com.tecnointel.soem.contabilidad.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.contabilidad.modelo.Transaccion;

@Local
public interface TransaccionListaInt {

	public List<Transaccion> buscarTodo(String columna) throws Exception;

	public List<Transaccion> buscar(Transaccion transaccion, Integer pagina) throws Exception;

	public long contarRegistros(Transaccion transaccion) throws Exception;

	public void filasPagina(int filasPagina);

}
