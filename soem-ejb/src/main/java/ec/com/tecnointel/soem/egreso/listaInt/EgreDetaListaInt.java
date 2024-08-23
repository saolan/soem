package ec.com.tecnointel.soem.egreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.EgreDeta;

@Local
public interface EgreDetaListaInt {

	public List<EgreDeta> buscarTodo(String columna) throws Exception;

	public List<EgreDeta> buscar(EgreDeta egreDeta, Integer pagina) throws Exception;

	public long contarRegistros(EgreDeta egreDeta) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
