package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AuseAuto;

@Local
public interface AuseAutoListaInt {

	public List<AuseAuto> buscar(AuseAuto auseAuto, Integer pagina) throws Exception;

	public long contarRegistros(AuseAuto auseAuto) throws Exception;

	public void filasPagina(int filasPagina);
	
}
