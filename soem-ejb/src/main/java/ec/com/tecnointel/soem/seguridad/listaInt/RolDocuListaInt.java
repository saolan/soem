package ec.com.tecnointel.soem.seguridad.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Local
public interface RolDocuListaInt {

	public List<RolDocu> buscarTodo(String columna) throws Exception;

	public List<RolDocu> buscar(RolDocu rolDocu, Integer pagina) throws Exception;

	public long contarRegistros(RolDocu rolDocu) throws Exception;

	public void imprimir(RolDocu rolDocu) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
