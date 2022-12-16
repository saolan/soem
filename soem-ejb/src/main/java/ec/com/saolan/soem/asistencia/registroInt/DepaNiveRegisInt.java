package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.DepaNive;

@Local
public interface DepaNiveRegisInt {

	public Object insertar(DepaNive depaNive) throws Exception;

	public void modificar(DepaNive depaNive) throws Exception;

	public void eliminar(DepaNive depaNive) throws Exception;

	public DepaNive buscarPorId(Integer id) throws Exception;

}
