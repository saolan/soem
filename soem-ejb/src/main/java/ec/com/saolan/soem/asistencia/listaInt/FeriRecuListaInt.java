package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.FeriRecu;

@Local
public interface FeriRecuListaInt {

	public List<FeriRecu> buscar(FeriRecu feriRecu, Integer pagina) throws Exception;

	public long contarRegistros(FeriRecu feriRecu) throws Exception;

	public void filasPagina(int filasPagina);
	
}
