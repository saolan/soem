package ec.com.tecnointel.soem.firmaElec.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.firmaElec.modelo.CertEmis;

@Local
public interface CertEmisListaInt {

	public List<CertEmis> buscar(CertEmis certEmis, Integer pagina) throws Exception;

	public long contarRegistros(CertEmis certEmis) throws Exception;
	
	public void filasPagina(int filasPagina);

}
