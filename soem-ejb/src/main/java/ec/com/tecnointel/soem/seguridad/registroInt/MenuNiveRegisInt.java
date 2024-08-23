package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.MenuNive;

@Local
public interface MenuNiveRegisInt {

	public Object insertar(MenuNive menuNive) throws Exception;

	public void modificar(MenuNive menuNive) throws Exception;

	public void eliminar(MenuNive menuNive) throws Exception;

	public MenuNive buscarPorId(Integer id) throws Exception;

}
