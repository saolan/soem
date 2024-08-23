package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Cargo;

@Local
public interface CargoRegisInt {

	public Object insertar(Cargo cargo) throws Exception;

	public void modificar(Cargo cargo) throws Exception;

	public void eliminar(Cargo cargo) throws Exception;

	public Cargo buscarPorId(Integer id) throws Exception;

}
