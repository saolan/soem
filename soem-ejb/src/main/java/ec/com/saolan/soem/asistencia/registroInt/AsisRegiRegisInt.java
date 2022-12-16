package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AsisRegi;

@Local
public interface AsisRegiRegisInt {

	public Object insertar(AsisRegi asisRegi) throws Exception;

	public void modificar(AsisRegi asisRegi) throws Exception;

	public void eliminar(AsisRegi asisRegi) throws Exception;

	public AsisRegi buscarPorId(Integer id) throws Exception;

}
