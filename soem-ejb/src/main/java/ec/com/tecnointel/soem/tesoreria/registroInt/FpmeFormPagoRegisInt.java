package ec.com.tecnointel.soem.tesoreria.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.FpmeFormPago;

@Local
public interface FpmeFormPagoRegisInt {

	public Object insertar(FpmeFormPago fpmeFormPago) throws Exception;

	public void modificar(FpmeFormPago fpmeFormPago) throws Exception;

	public void eliminar(FpmeFormPago fpmeFormPago) throws Exception;

	public FpmeFormPago buscarPorId(Integer id) throws Exception;

}
