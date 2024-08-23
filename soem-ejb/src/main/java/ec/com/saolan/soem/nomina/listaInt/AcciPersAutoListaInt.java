package ec.com.saolan.soem.nomina.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersAuto;

@Local
public interface AcciPersAutoListaInt {

	public List<AcciPersAuto> buscar(AcciPersAuto acciAuto, Integer pagina) throws Exception;

	public long contarRegistros(AcciPersAuto acciAuto) throws Exception;

	public void filasPagina(int filasPagina);
	
}
