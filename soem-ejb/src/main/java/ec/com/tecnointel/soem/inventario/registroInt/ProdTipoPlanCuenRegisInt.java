package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdTipoPlanCuen;

@Local
public interface ProdTipoPlanCuenRegisInt {

	public Object insertar(ProdTipoPlanCuen prodTipoPlanCuen) throws Exception;

	public void modificar(ProdTipoPlanCuen prodTipoPlanCuen) throws Exception;

	public void eliminar(ProdTipoPlanCuen prodTipoPlanCuen) throws Exception;

	public ProdTipoPlanCuen buscarPorId(Integer id) throws Exception;

}
