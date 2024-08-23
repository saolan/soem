package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.TranPlanDeta;

@Local
public interface TranPlanDetaRegisInt {

	public Object insertar(TranPlanDeta tranPlanDeta) throws Exception;

	public void modificar(TranPlanDeta tranPlanDeta) throws Exception;

	public void eliminar(TranPlanDeta tranPlanDeta) throws Exception;

	public TranPlanDeta buscarPorId(Integer id) throws Exception;

}
