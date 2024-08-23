package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.DocuAuse;

@Local
public interface DocuAuseListaInt {

	public List<DocuAuse> buscar(DocuAuse docuAuse, Integer pagina) throws Exception;

	public long contarRegistros(DocuAuse docuAuse) throws Exception;

	public void filasPagina(int filasPagina);
	
}
