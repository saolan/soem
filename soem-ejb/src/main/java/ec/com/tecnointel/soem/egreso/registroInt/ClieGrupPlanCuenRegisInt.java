package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrupPlanCuen;

@Local
public interface ClieGrupPlanCuenRegisInt {

	public Object insertar(ClieGrupPlanCuen clieGrupPlanCuen) throws Exception;

	public void modificar(ClieGrupPlanCuen clieGrupPlanCuen) throws Exception;

	public void eliminar(ClieGrupPlanCuen clieGrupPlanCuen) throws Exception;

	public ClieGrupPlanCuen buscarPorId(Integer id) throws Exception;

}
