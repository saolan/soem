package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DimmPlanCuen;

@Local
public interface DimmPlanCuenRegisInt {

	public Object insertar(DimmPlanCuen dimmPlanCuen) throws Exception;

	public void modificar(DimmPlanCuen dimmPlanCuen) throws Exception;

	public void eliminar(DimmPlanCuen dimmPlanCuen) throws Exception;

	public DimmPlanCuen buscarPorId(Integer id) throws Exception;

}
