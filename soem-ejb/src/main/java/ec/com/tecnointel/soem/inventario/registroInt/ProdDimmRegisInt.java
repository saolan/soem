package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdDimm;

@Local
public interface ProdDimmRegisInt {

	public Object insertar(ProdDimm prodDimm) throws Exception;

	public void modificar(ProdDimm prodDimm) throws Exception;

	public void eliminar(ProdDimm prodDimm) throws Exception;

	public ProdDimm buscarPorId(Integer id) throws Exception;

}
