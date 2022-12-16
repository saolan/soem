package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDimm;

@Local
public interface IngrDimmListaInt {

	public List<IngrDimm> buscar(IngrDimm ingrDimm, Integer pagina) throws Exception;

	public long contarRegistros(IngrDimm ingrDimm) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
