package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDetaPrec;

@Local
public interface IngrDetaPrecRegisInt {

	public Object insertar(IngrDetaPrec IngrDetaPrec) throws Exception;

	public void modificar(IngrDetaPrec IngrDetaPrec) throws Exception;

	public void eliminar(IngrDetaPrec IngrDetaPrec) throws Exception;

	public IngrDetaPrec buscarPorId(Integer id) throws Exception;

}
