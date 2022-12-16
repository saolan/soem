package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Retencion;

@Local
public interface RetencionListaInt {

	public List<Retencion> buscarTodo(String columna) throws Exception;

	public List<Retencion> buscar(Retencion retencion, Integer pagina) throws Exception;

	public long contarRegistros(Retencion retencion) throws Exception;

	public void filasPagina(int filasPagina);
	
}
