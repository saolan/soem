package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdTipo;

@Local
public interface ProdTipoRegisInt {

	public Object insertar(ProdTipo prodTipo) throws Exception;

	public void modificar(ProdTipo prodTipo) throws Exception;

	public void eliminar(ProdTipo prodTipo) throws Exception;

	public ProdTipo buscarPorId(Integer id) throws Exception;

}
