package ec.com.tecnointel.soem.tesoreria.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviIngr;

@Local
public interface FormPagoMoviIngrRegisInt {

	public Object insertar(FormPagoMoviIngr formPagoMoviIngr) throws Exception;

	public void modificar(FormPagoMoviIngr formPagoMoviIngr) throws Exception;

	public void eliminar(FormPagoMoviIngr formPagoMoviIngr) throws Exception;

	public FormPagoMoviIngr buscarPorId(Integer id) throws Exception;

}
