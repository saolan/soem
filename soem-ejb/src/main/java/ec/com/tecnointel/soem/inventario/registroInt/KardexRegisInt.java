package ec.com.tecnointel.soem.inventario.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.Kardex;

@Local
public interface KardexRegisInt {

	public Object insertar(Kardex kardex) throws Exception;

	public void modificar(Kardex kardex) throws Exception;

	public void eliminar(Kardex kardex) throws Exception;

	public Kardex buscarPorId(Integer id) throws Exception;

}
