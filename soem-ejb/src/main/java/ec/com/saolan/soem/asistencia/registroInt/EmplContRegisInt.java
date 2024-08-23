package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplCont;

@Local
public interface EmplContRegisInt {

	public Object insertar(EmplCont emplCont) throws Exception;

	public void modificar(EmplCont emplCont) throws Exception;

	public void eliminar(EmplCont emplCont) throws Exception;

	public EmplCont buscarPorId(Integer id) throws Exception;

}
