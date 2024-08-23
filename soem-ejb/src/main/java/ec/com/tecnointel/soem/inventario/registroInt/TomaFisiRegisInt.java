package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.TomaFisi;

@Local
public interface TomaFisiRegisInt {

	public Object insertar(TomaFisi tomaFisi) throws Exception;

	public void modificar(TomaFisi tomaFisi) throws Exception;

	public void eliminar(TomaFisi tomaFisi) throws Exception;

	public TomaFisi buscarPorId(Integer id) throws Exception;

}
