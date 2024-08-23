package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuTran;

@Local
public interface DocuTranRegisInt {

	public Object insertar(DocuTran docuTran) throws Exception;

	public void modificar(DocuTran docuTran) throws Exception;

	public void eliminar(DocuTran docuTran) throws Exception;

	public DocuTran buscarPorId(Integer id) throws Exception;

}
