package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraDeta;

@Local
public interface HoraDetaRegisInt {

	public Object insertar(HoraDeta horaDeta) throws Exception;

	public void modificar(HoraDeta horaDeta) throws Exception;

	public void eliminar(HoraDeta horaDeta) throws Exception;

	public HoraDeta buscarPorId(Integer id) throws Exception;

}
