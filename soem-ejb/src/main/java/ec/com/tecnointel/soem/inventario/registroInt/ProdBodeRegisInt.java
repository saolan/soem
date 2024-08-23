package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdBode;

@Local
public interface ProdBodeRegisInt {

	public Object insertar(ProdBode prodBode) throws Exception;

	public void modificar(ProdBode prodBode) throws Exception;

	public void eliminar(ProdBode prodBode) throws Exception;

	public ProdBode buscarPorId(Integer id) throws Exception;

}
