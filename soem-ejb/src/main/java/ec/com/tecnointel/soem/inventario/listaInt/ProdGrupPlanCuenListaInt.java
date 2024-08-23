package ec.com.tecnointel.soem.inventario.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrupPlanCuen;

@Local
public interface ProdGrupPlanCuenListaInt {

	public List<ProdGrupPlanCuen> buscarTodo(String columna) throws Exception;

	public List<ProdGrupPlanCuen> buscar(ProdGrupPlanCuen prodGrupPlancuen, Integer pagina) throws Exception;

	public long contarRegistros(ProdGrupPlanCuen prodGrupPlancuen) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
