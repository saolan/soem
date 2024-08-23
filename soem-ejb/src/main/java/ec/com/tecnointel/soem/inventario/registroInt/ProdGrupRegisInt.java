package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdGrup;

@Local
public interface ProdGrupRegisInt {

	public Object insertar(ProdGrup prodGrup) throws Exception;

	public void modificar(ProdGrup prodGrup) throws Exception;

	public void eliminar(ProdGrup prodGrup) throws Exception;

	public ProdGrup buscarPorId(Integer id) throws Exception;

}
