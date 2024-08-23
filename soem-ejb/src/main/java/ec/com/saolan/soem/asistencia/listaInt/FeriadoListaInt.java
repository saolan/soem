package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Feriado;

@Local
public interface FeriadoListaInt {

	public List<Feriado> buscar(Feriado feriado, Integer pagina) throws Exception;

	public long contarRegistros(Feriado feriado) throws Exception;

	public void filasPagina(int filasPagina);
	
}
