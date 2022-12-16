package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Dispositivo;

@Local
public interface DispositivoRegisInt {

	public Object insertar(Dispositivo dispositivo) throws Exception;

	public void modificar(Dispositivo dispositivo) throws Exception;

	public void eliminar(Dispositivo dispositivo) throws Exception;

	public Dispositivo buscarPorId(Integer id) throws Exception;

}
