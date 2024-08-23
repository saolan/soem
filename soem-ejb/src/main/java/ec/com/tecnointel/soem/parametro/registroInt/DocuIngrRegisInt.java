package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuIngr;

@Local
public interface DocuIngrRegisInt {

	public Object insertar(DocuIngr docuIngr) throws Exception;

	public void modificar(DocuIngr docuIngr) throws Exception;

	public void eliminar(DocuIngr docuIngr) throws Exception;

	public DocuIngr buscarPorId(Integer id) throws Exception;

}
