package ec.com.tecnointel.soem.ingreso.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;

@Local
public interface IngresoListaInt {

	public void filasPagina(int filasPagina);
	
	public void orden(String orden);

	
	public List<Ingreso> buscarTodo(String columna) throws Exception;

	public List<Ingreso> buscar(Ingreso ingreso, Integer pagina) throws Exception;

	public long contarRegistros(Ingreso ingreso) throws Exception;
		
	public List<Ingreso> buscarTransaccion(Ingreso ingreso) throws Exception;

	
}
