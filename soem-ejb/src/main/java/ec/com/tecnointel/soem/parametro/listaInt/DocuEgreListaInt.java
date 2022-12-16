package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuEgre;
import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Local
public interface DocuEgreListaInt {

	public List<DocuEgre> buscarTodo(String columna) throws Exception;

	public List<DocuEgre> buscar(DocuEgre docuEgre, Integer pagina) throws Exception;

	public long contarRegistros(DocuEgre docuEgre) throws Exception;

	public List<DocuEgre> filtrarDocuEgres(List<DocuEgre> docuEgres, PersUsua persUsuaSesion, List<RolDocu> rolDocus) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
