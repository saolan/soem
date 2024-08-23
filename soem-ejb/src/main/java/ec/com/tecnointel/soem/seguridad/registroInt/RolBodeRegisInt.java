package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolBode;

@Local
public interface RolBodeRegisInt {

	public Object insertar(RolBode rolBode) throws Exception;

	public void modificar(RolBode rolBode) throws Exception;

	public void eliminar(RolBode rolBode) throws Exception;

	public RolBode buscarPorId(Integer id) throws Exception;

}
