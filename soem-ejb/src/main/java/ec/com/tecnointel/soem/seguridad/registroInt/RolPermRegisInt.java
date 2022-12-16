package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolPerm;

@Local
public interface RolPermRegisInt {

	public Object insertar(RolPerm rolPerm) throws Exception;

	public void modificar(RolPerm rolPerm) throws Exception;

	public void eliminar(RolPerm rolPerm) throws Exception;

	public RolPerm buscarPorId(Integer id) throws Exception;

}
