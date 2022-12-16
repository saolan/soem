package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.PersEmpl;

@Local
public interface PersEmplRegisInt {

	public Object insertar(PersEmpl persEmpl) throws Exception;

	public void modificar(PersEmpl persEmpl) throws Exception;

	public void eliminar(PersEmpl persEmpl) throws Exception;

	public PersEmpl buscarPorId(Integer id) throws Exception;

}
