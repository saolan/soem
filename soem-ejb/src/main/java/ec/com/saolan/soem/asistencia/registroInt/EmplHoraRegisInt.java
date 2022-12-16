package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.EmplHora;

@Local
public interface EmplHoraRegisInt {

	public Object insertar(EmplHora emplHora) throws Exception;

	public void modificar(EmplHora emplHora) throws Exception;

	public void eliminar(EmplHora emplHora) throws Exception;

	public EmplHora buscarPorId(Integer id) throws Exception;

}
