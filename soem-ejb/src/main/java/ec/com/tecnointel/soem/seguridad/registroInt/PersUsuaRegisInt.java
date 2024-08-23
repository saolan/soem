package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;

@Local
public interface PersUsuaRegisInt {

	public Object insertar(PersUsua persUsua) throws Exception;

	public void modificar(PersUsua persUsua) throws Exception;

	public void eliminar(PersUsua persUsua) throws Exception;

	public PersUsua buscarPorId(Integer id) throws Exception;

}
