package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.PersProv;

@Local
public interface PersProvRegisInt {

	public Object insertar(PersProv persProv) throws Exception;

	public void modificar(PersProv persProv) throws Exception;

	public void eliminar(PersProv persProv) throws Exception;

	public PersProv buscarPorId(Integer id) throws Exception;

}
