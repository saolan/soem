package ec.com.tecnointel.soem.caja.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviTran;

@Local
public interface CajaMoviTranListaInt {

	public List<CajaMoviTran> buscarTodo(String columna) throws Exception;

	public List<CajaMoviTran> buscar(CajaMoviTran cajaMoviTran, Integer pagina) throws Exception;

	public long contarRegistros(CajaMoviTran cajaMoviTran) throws Exception;

	public void filasPagina(int filasPagina);
}
