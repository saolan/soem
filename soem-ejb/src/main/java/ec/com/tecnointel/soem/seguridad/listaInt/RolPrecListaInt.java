package ec.com.tecnointel.soem.seguridad.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;
import ec.com.tecnointel.soem.seguridad.modelo.RolPrec;

@Local
public interface RolPrecListaInt {

	public List<RolPrec> buscarTodo(String columna) throws Exception;

	public List<RolPrec> buscar(RolPrec rolPrec, Integer pagina) throws Exception;

	public List<RolPrec> buscar(Sucursal sucursal, List<Integer> rols, RolPrec rolPrec) throws Exception;
	
	public long contarRegistros(RolPrec rolPrec) throws Exception;

	public void imprimir(RolPrec rolPrec) throws Exception;

	public void filasPagina(int filasPagina);

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
