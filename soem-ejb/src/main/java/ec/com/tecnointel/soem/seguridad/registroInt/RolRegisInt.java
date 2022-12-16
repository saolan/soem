package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Rol;

@Local
public interface RolRegisInt {

	public Object insertar(Rol rol) throws Exception;

	public void modificar(Rol rol) throws Exception;

	public void eliminar(Rol rol) throws Exception;

	public Rol buscarPorId(Integer id) throws Exception;

}
