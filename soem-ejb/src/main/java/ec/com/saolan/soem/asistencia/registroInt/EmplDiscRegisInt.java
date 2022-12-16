package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplDisc;

@Local
public interface EmplDiscRegisInt {

	public Object insertar(EmplDisc emplDisc) throws Exception;

	public void modificar(EmplDisc emplDisc) throws Exception;

	public void eliminar(EmplDisc emplDisc) throws Exception;

	public EmplDisc buscarPorId(Integer id) throws Exception;

}
