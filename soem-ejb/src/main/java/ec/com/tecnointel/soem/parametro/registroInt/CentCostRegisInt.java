package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.CentCost;

@Local
public interface CentCostRegisInt {

	public Object insertar(CentCost centCost) throws Exception;

	public void modificar(CentCost centCost) throws Exception;

	public void eliminar(CentCost centCost) throws Exception;

	public CentCost buscarPorId(Integer id) throws Exception;

}
