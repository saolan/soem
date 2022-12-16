package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuMoviEgre;

@Local
public interface DocuMoviEgreRegisInt {

	public Object insertar(DocuMoviEgre docuFormPago) throws Exception;

	public void modificar(DocuMoviEgre docuFormPago) throws Exception;

	public void eliminar(DocuMoviEgre docuFormPago) throws Exception;

	public DocuMoviEgre buscarPorId(Integer id) throws Exception;

}
