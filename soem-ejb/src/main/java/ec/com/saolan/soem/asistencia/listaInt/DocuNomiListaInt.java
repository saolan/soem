package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.DocuNomi;

@Local
public interface DocuNomiListaInt {

	public List<DocuNomi> buscar(DocuNomi docuNomi, Integer pagina) throws Exception;

	public long contarRegistros(DocuNomi docuNomi) throws Exception;

	public void filasPagina(int filasPagina);
	
}
