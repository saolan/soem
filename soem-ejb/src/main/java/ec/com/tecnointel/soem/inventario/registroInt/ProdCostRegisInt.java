package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdCost;

@Local
public interface ProdCostRegisInt {

	public Object insertar(ProdCost prodCost) throws Exception;

	public void modificar(ProdCost prodCost) throws Exception;

	public void eliminar(ProdCost prodCost) throws Exception;

	public ProdCost buscarPorId(Integer id) throws Exception;

}
