package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Menu;

@Local
public interface MenuRegisInt {

	public Object insertar(Menu menu) throws Exception;

	public void modificar(Menu menu) throws Exception;

	public void eliminar(Menu menu) throws Exception;

	public Menu buscarPorId(Integer id) throws Exception;

}
