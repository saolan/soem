package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraPlan;

@Local
public interface HoraPlanRegisInt {

	public Object insertar(HoraPlan horaPlan) throws Exception;

	public void modificar(HoraPlan horaPlan) throws Exception;

	public void eliminar(HoraPlan horaPlan) throws Exception;

	public HoraPlan buscarPorId(Integer id) throws Exception;

}
