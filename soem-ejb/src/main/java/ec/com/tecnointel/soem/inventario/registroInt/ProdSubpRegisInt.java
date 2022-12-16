package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdSubp;

@Local
public interface ProdSubpRegisInt {

	public Object insertar(ProdSubp prodSubp) throws Exception;

	public void modificar(ProdSubp prodSubp) throws Exception;

	public void eliminar(ProdSubp prodSubp) throws Exception;

	public ProdSubp buscarPorId(Integer id) throws Exception;

}
