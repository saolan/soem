package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.TranPlan;

@Local
public interface TranPlanRegisInt {

	public Object insertar(TranPlan tranPlan) throws Exception;

	public void modificar(TranPlan tranPlan) throws Exception;

	public void eliminar(TranPlan tranPlan) throws Exception;

	public TranPlan buscarPorId(Integer id) throws Exception;

}
