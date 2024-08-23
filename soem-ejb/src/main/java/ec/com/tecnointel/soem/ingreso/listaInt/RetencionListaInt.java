package ec.com.tecnointel.soem.ingreso.listaInt;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Retencion;

@Local
public interface RetencionListaInt {

	public List<Retencion> buscarTodo(String columna) throws Exception;

	public List<Retencion> buscar(Retencion retencion, Integer pagina) throws Exception;

	public long contarRegistros(Retencion retencion) throws Exception;

	public void filasPagina(int filasPagina);

	List<Retencion> buscar2(Retencion retencion, LocalDateTime fechaHoraEmisDesde, LocalDateTime fechaHoraEmisHasta,
			Integer pagina) throws Exception;

	long contarRegistros2(Retencion retencion, LocalDateTime fechaHoraEmisDesde, LocalDateTime fechaHoraEmisHasta) throws Exception;
	
}
