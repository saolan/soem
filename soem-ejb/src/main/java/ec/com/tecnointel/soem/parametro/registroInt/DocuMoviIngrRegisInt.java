package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuMoviIngr;

@Local
public interface DocuMoviIngrRegisInt {

	public Object insertar(DocuMoviIngr docuFormPago) throws Exception;

	public void modificar(DocuMoviIngr docuFormPago) throws Exception;

	public void eliminar(DocuMoviIngr docuFormPago) throws Exception;

	public DocuMoviIngr buscarPorId(Integer id) throws Exception;

}
