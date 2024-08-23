package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuCertEmis;

@Local
public interface SucuCertEmisListaInt {
	
	public List<SucuCertEmis> buscar(SucuCertEmis sucuCertEmis, Integer pagina) throws Exception;

	public long contarRegistros(SucuCertEmis sucuCertEmis) throws Exception;
	
	public void filasPagina(int filasPagina);

}
