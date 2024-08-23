package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolPersUsua;

@Local
public interface RolPersUsuaRegisInt {

	public Object insertar(RolPersUsua rolPersUsua) throws Exception;

	public void modificar(RolPersUsua rolPersUsua) throws Exception;

	public void eliminar(RolPersUsua rolPersUsua) throws Exception;

	public RolPersUsua buscarPorId(Integer id) throws Exception;

}
