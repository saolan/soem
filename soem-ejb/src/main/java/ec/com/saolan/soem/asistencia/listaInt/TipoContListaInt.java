package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.TipoCont;

@Local
public interface TipoContListaInt {

	public List<TipoCont> buscar(TipoCont tipoCont, Integer pagina) throws Exception;

	public long contarRegistros(TipoCont tipoCont) throws Exception;

	public void filasPagina(int filasPagina);
	
}
