package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolFormPago;

@Local
public interface RolFormPagoRegisInt {

	public Object insertar(RolFormPago rolFormPago) throws Exception;

	public void modificar(RolFormPago rolFormPago) throws Exception;

	public void eliminar(RolFormPago rolFormPago) throws Exception;

	public RolFormPago buscarPorId(Integer id) throws Exception;

}
