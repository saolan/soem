package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuEgre;

@Local
public interface DocuEgreRegisInt {

	public Object insertar(DocuEgre docuEgre) throws Exception;

	public void modificar(DocuEgre docuEgre) throws Exception;

	public void eliminar(DocuEgre docuEgre) throws Exception;

	public DocuEgre buscarPorId(Integer id) throws Exception;

}
