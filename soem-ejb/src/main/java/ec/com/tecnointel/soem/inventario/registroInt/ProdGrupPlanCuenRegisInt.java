package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrupPlanCuen;

@Local
public interface ProdGrupPlanCuenRegisInt {

	public Object insertar(ProdGrupPlanCuen prodGrupPlanCuen) throws Exception;

	public void modificar(ProdGrupPlanCuen prodGrupPlanCuen) throws Exception;

	public void eliminar(ProdGrupPlanCuen prodGrupPlanCuen) throws Exception;

	public ProdGrupPlanCuen buscarPorId(Integer id) throws Exception;

}
