package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDeta;

@Local
public interface IngrDetaRegisInt {

	public Object insertar(IngrDeta ingrDeta) throws Exception;

	public void modificar(IngrDeta ingrDeta) throws Exception;

	public void eliminar(IngrDeta ingrDeta) throws Exception;

	public IngrDeta buscarPorId(Integer id) throws Exception;

}
