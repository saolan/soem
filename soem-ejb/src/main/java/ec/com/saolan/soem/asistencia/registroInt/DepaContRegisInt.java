package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.DepaCont;

@Local
public interface DepaContRegisInt {

	public Object insertar(DepaCont depaCont) throws Exception;

	public void modificar(DepaCont depaCont) throws Exception;

	public void eliminar(DepaCont depaCont) throws Exception;

	public DepaCont buscarPorId(Integer id) throws Exception;

}
