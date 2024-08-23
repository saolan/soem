package ec.com.tecnointel.soem.parametro.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuTran;
import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Local
public interface DocuTranListaInt {

	public List<DocuTran> buscarTodo(String columna) throws Exception;

	public List<DocuTran> buscar(DocuTran docuTran, Integer pagina) throws Exception;
	
	public List<DocuTran> filtrarDocuTrans(List<DocuTran> docuTrans, PersUsua persUsuaSesion, List<RolDocu> rolDocus) throws Exception;

	public long contarRegistros(DocuTran docuTran) throws Exception;

	public void imprimir(DocuTran docuran) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
