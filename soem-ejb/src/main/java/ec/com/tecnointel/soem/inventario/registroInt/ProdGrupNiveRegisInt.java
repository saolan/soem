package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrupNive;

@Local
public interface ProdGrupNiveRegisInt {

	public Object insertar(ProdGrupNive prodGrupNive) throws Exception;

	public void modificar(ProdGrupNive prodGrupNive) throws Exception;

	public void eliminar(ProdGrupNive prodGrupNive) throws Exception;

	public ProdGrupNive buscarPorId(Integer id) throws Exception;

}
