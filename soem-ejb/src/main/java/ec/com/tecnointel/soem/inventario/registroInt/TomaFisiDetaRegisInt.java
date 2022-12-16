package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.TomaFisiDeta;

@Local
public interface TomaFisiDetaRegisInt {

	public Object insertar(TomaFisiDeta tomaFisiDeta) throws Exception;

	public void modificar(TomaFisiDeta tomaFisiDeta) throws Exception;

	public void eliminar(TomaFisiDeta tomaFisiDeta) throws Exception;

	public TomaFisiDeta buscarPorId(Integer id) throws Exception;

}
