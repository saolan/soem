package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Departamento;

@Local
public interface DepartamentoRegisInt {

	public Object insertar(Departamento departamento) throws Exception;

	public void modificar(Departamento departamento) throws Exception;

	public void eliminar(Departamento departamento) throws Exception;

	public Departamento buscarPorId(Integer id) throws Exception;

}
