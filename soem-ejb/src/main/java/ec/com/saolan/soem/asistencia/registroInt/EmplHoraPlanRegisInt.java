package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHoraPlan;

@Local
public interface EmplHoraPlanRegisInt {

	public Object insertar(EmplHoraPlan emplHoraPlan) throws Exception;

	public void modificar(EmplHoraPlan emplHoraPlan) throws Exception;

	public void eliminar(EmplHoraPlan emplHoraPlan) throws Exception;

	public EmplHoraPlan buscarPorId(Integer id) throws Exception;

}
