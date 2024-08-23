package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDetaImpu;

@Local
public interface IngrDetaImpuListaInt {

	public List<IngrDetaImpu> buscarTodo(String columna) throws Exception;

	public List<IngrDetaImpu> buscar(IngrDetaImpu ingrDetaImpu, Integer pagina) throws Exception;

	public long contarRegistros(IngrDetaImpu ingrDetaImpu) throws Exception;

	public void imprimir(IngrDetaImpu ingrDetaImpu) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
