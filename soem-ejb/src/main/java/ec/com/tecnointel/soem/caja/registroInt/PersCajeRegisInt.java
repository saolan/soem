package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.PersCaje;

@Local
public interface PersCajeRegisInt {

	public Object insertar(PersCaje persCaje) throws Exception;

	public void modificar(PersCaje persCaje) throws Exception;

	public void eliminar(PersCaje persCaje) throws Exception;

	public PersCaje buscarPorId(Integer id) throws Exception;

}
