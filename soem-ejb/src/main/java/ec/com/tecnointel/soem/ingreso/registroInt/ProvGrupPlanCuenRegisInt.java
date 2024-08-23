package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.ProvGrupPlanCuen;

@Local
public interface ProvGrupPlanCuenRegisInt {

	public Object insertar(ProvGrupPlanCuen provGrupPlanCuen) throws Exception;

	public void modificar(ProvGrupPlanCuen provGrupPlanCuen) throws Exception;

	public void eliminar(ProvGrupPlanCuen provGrupPlanCuen) throws Exception;

	public ProvGrupPlanCuen buscarPorId(Integer id) throws Exception;

}
