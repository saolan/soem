package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.DocuNomiPlanCuen;

@Local
public interface DocuNomiPlanCuenRegisInt {

	public Object insertar(DocuNomiPlanCuen docuNomiPlanCuen) throws Exception;

	public void modificar(DocuNomiPlanCuen docuNomiPlanCuen) throws Exception;

	public void eliminar(DocuNomiPlanCuen docuNomiPlanCuen) throws Exception;

	public DocuNomiPlanCuen buscarPorId(Integer id) throws Exception;

}
