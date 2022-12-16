package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDetaImpu;

@Local
public interface IngrDetaImpuRegisInt {

	public Object insertar(IngrDetaImpu ingrDetaImpu) throws Exception;

	public void modificar(IngrDetaImpu ingrDetaImpu) throws Exception;

	public void eliminar(IngrDetaImpu ingrDetaImpu) throws Exception;

	public IngrDetaImpu buscarPorId(Integer id) throws Exception;

}
