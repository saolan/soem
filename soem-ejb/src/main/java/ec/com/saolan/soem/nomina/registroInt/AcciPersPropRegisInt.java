package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersProp;

@Local
public interface AcciPersPropRegisInt {

	public Object insertar(AcciPersProp acciPersProp) throws Exception;

	public void modificar(AcciPersProp acciPersProp) throws Exception;

	public void eliminar(AcciPersProp acciPersProp) throws Exception;

	public AcciPersProp buscarPorId(Integer id) throws Exception;

}
