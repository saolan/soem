package ec.com.tecnointel.soem.contabilidad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuenNive;

@Local
public interface PlanCuenNiveRegisInt {

	public Object insertar(PlanCuenNive planCuenNive) throws Exception;

	public void modificar(PlanCuenNive planCuenNive) throws Exception;

	public void eliminar(PlanCuenNive planCuenNive) throws Exception;

	public PlanCuenNive buscarPorId(Integer id) throws Exception;

}
