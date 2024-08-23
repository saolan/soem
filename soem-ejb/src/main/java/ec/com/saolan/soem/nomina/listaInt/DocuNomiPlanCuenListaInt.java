package ec.com.saolan.soem.nomina.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.DocuNomiPlanCuen;

@Local
public interface DocuNomiPlanCuenListaInt {

	public List<DocuNomiPlanCuen> buscar(DocuNomiPlanCuen docuNomiPlanCuen, Integer pagina) throws Exception;

	public long contarRegistros(DocuNomiPlanCuen docuNomiPlanCuen) throws Exception;

	public void filasPagina(int filasPagina);
	
}
