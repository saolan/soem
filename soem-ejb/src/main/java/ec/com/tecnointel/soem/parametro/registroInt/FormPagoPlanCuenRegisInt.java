package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.FormPagoPlanCuen;

@Local
public interface FormPagoPlanCuenRegisInt {

	public Object insertar(FormPagoPlanCuen formPagoPlanCuen) throws Exception;

	public void modificar(FormPagoPlanCuen formPagoPlanCuen) throws Exception;

	public void eliminar(FormPagoPlanCuen formPagoPlanCuen) throws Exception;

	public FormPagoPlanCuen buscarPorId(Integer id) throws Exception;

}
