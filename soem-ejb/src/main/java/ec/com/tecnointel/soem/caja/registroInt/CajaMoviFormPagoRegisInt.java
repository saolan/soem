package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviFormPago;

@Local
public interface CajaMoviFormPagoRegisInt {

	public Object insertar(CajaMoviFormPago cajaMoviFormPago) throws Exception;

	public void modificar(CajaMoviFormPago cajaMoviFormPago) throws Exception;

	public void eliminar(CajaMoviFormPago cajaMoviFormPago) throws Exception;

	public CajaMoviFormPago buscarPorId(Integer id) throws Exception;

}
