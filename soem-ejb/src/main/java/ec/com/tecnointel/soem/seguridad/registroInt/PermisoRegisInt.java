package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Permiso;

@Local
public interface PermisoRegisInt {

	public Object insertar(Permiso permiso) throws Exception;

	public void modificar(Permiso permiso) throws Exception;

	public void eliminar(Permiso permiso) throws Exception;

	public Permiso buscarPorId(Integer id) throws Exception;

}
