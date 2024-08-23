package ec.com.tecnointel.soem.contabilidad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuen;

@Local
public interface PlanCuenRegisInt {

	public Object insertar(PlanCuen planCuen) throws Exception;

	public void modificar(PlanCuen planCuen) throws Exception;

	public void eliminar(PlanCuen planCuen) throws Exception;

	public PlanCuen buscarPorId(Integer id) throws Exception;

}
