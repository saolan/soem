package ec.com.tecnointel.soem.tesoreria.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.PagoDeta;

@Local
public interface PagoDetaRegisInt {

	public Object insertar(PagoDeta pagoDeta) throws Exception;

	public void modificar(PagoDeta pagoDeta) throws Exception;

	public void eliminar(PagoDeta pagoDeta) throws Exception;

	public PagoDeta buscarPorId(Integer id) throws Exception;

}
