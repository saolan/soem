package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplTitu;

@Local
public interface EmplTituRegisInt {

	public Object insertar(EmplTitu emplTitu) throws Exception;

	public void modificar(EmplTitu emplTitu) throws Exception;

	public void eliminar(EmplTitu emplTitu) throws Exception;

	public EmplTitu buscarPorId(Integer id) throws Exception;

}
