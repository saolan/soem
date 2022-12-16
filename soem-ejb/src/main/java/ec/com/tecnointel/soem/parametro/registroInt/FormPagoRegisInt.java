package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.FormPago;

@Local
public interface FormPagoRegisInt {

	public Object insertar(FormPago formPago) throws Exception;

	public void modificar(FormPago formPago) throws Exception;

	public void eliminar(FormPago formPago) throws Exception;

	public FormPago buscarPorId(Integer id) throws Exception;

}
