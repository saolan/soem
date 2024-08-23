package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDetaPrec;
import ec.com.tecnointel.soem.parametro.modelo.Sucursal;
import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;
import ec.com.tecnointel.soem.seguridad.modelo.RolPrec;

@Local
public interface IngrDetaPrecListaInt {

	public List<IngrDetaPrec> buscarTodo(String columna) throws Exception;

	public List<IngrDetaPrec> buscar(IngrDetaPrec ingrDetaPrec, Integer pagina) throws Exception;

	public long contarRegistros(IngrDetaPrec ingrDetaPrec) throws Exception;

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public List<IngrDetaPrec> filtrarIngrDetaPrec(List<IngrDetaPrec> ingrDetaPrecs, PersUsua persUsuaSesion, List<RolPrec> rolPrecs, Sucursal sucursal) throws Exception;
	
}
