package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.IngrDimm;

@Local
public interface IngrDimmRegisInt {

	public Object insertar(IngrDimm ingrDimm) throws Exception;

	public void modificar(IngrDimm ingrDimm) throws Exception;

	public void eliminar(IngrDimm ingrDimm) throws Exception;

	public IngrDimm buscarPorId(Integer id) throws Exception;

}
