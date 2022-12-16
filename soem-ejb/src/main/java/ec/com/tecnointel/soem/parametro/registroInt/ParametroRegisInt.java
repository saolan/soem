package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Parametro;

@Local
public interface ParametroRegisInt {

	public Object insertar(Parametro parametro) throws Exception;

	public void modificar(Parametro parametro) throws Exception;

	public void eliminar(Parametro parametro) throws Exception;

	public Parametro buscarPorId(Integer id) throws Exception;

}
