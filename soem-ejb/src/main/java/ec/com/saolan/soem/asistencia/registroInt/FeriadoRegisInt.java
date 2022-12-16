package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Feriado;

@Local
public interface FeriadoRegisInt {

	public Object insertar(Feriado feriado) throws Exception;

	public void modificar(Feriado feriado) throws Exception;

	public void eliminar(Feriado feriado) throws Exception;

	public Feriado buscarPorId(Integer id) throws Exception;

}
