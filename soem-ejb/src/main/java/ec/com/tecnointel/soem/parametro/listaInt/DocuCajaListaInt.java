package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuCaja;
import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Local
public interface DocuCajaListaInt {

	public List<DocuCaja> buscarTodo(String columna) throws Exception;

	public List<DocuCaja> buscar(DocuCaja docuCaja, Integer pagina) throws Exception;

	public long contarRegistros(DocuCaja docuCaja) throws Exception;

	public void imprimir(DocuCaja docuCaja) throws Exception;

	public List<DocuCaja> filtrarDocuCajas(List<DocuCaja> docuCajas, PersUsua persUsuaSesion, List<RolDocu> rolDocus) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
