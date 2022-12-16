package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHoraDeta;

@Local
public interface EmplHoraDetaRegisInt {

	public Object insertar(EmplHoraDeta emplHoraDeta) throws Exception;

	public void modificar(EmplHoraDeta emplHoraDeta) throws Exception;

	public void eliminar(EmplHoraDeta emplHoraDeta) throws Exception;

	public EmplHoraDeta buscarPorId(Integer id) throws Exception;

}
