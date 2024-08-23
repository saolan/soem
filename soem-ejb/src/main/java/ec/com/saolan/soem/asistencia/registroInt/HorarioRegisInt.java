package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Horario;

@Local
public interface HorarioRegisInt {

	public Object insertar(Horario horario) throws Exception;

	public void modificar(Horario horario) throws Exception;

	public void eliminar(Horario horario) throws Exception;

	public Horario buscarPorId(Integer id) throws Exception;

}
