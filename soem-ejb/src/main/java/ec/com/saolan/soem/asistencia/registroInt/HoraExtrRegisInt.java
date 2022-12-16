package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraExtr;

@Local
public interface HoraExtrRegisInt {

	public Object insertar(HoraExtr horaExtr) throws Exception;

	public void modificar(HoraExtr horaExtr) throws Exception;

	public void eliminar(HoraExtr horaExtr) throws Exception;

	public HoraExtr buscarPorId(Integer id) throws Exception;

}
