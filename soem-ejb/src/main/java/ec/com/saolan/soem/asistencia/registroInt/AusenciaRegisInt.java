package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Ausencia;

@Local
public interface AusenciaRegisInt {

	public Object insertar(Ausencia ausencia) throws Exception;

	public void modificar(Ausencia ausencia) throws Exception;

	public void eliminar(Ausencia ausencia) throws Exception;

	public Ausencia buscarPorId(Integer id) throws Exception;

}
