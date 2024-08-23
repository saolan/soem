package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Departamento;

@Local
public interface DepartamentoListaInt {

	public List<Departamento> buscar(Departamento departamento, Integer pagina) throws Exception;

	public long contarRegistros(Departamento departamento) throws Exception;

	public void filasPagina(int filasPagina);
	
}
