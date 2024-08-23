package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.DocuCaja;

@Local
public interface DocuCajaRegisInt {

	public Object insertar(DocuCaja docuCaja) throws Exception;

	public void modificar(DocuCaja docuCaja) throws Exception;

	public void eliminar(DocuCaja docuCaja) throws Exception;

	public DocuCaja buscarPorId(Integer id) throws Exception;

}
