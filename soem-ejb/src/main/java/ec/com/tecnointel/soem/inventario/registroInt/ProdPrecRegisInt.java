package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdPrec;

@Local
public interface ProdPrecRegisInt {

	public Object insertar(ProdPrec prodPrec) throws Exception;

	public void modificar(ProdPrec prodPrec) throws Exception;

	public void eliminar(ProdPrec prodPrec) throws Exception;

	public ProdPrec buscarPorId(Integer id) throws Exception;

}
