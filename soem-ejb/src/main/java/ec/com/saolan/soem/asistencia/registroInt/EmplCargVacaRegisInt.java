package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplCargVaca;

@Local
public interface EmplCargVacaRegisInt {

	public Object insertar(EmplCargVaca emplCargVaca) throws Exception;

	public void modificar(EmplCargVaca emplCargVaca) throws Exception;

	public void eliminar(EmplCargVaca emplCargVaca) throws Exception;

	public EmplCargVaca buscarPorId(Integer id) throws Exception;

}
