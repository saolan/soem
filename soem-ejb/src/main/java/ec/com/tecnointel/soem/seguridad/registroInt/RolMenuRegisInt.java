package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolMenu;

@Local
public interface RolMenuRegisInt {

	public Object insertar(RolMenu rolMenu) throws Exception;

	public void modificar(RolMenu rolMenu) throws Exception;

	public void eliminar(RolMenu rolMenu) throws Exception;

	public RolMenu buscarPorId(Integer id) throws Exception;

}
