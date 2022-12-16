package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuBode;

@Local
public interface SucuBodeRegisInt {

	public Object insertar(SucuBode sucuBode) throws Exception;

	public void modificar(SucuBode sucuBode) throws Exception;

	public void eliminar(SucuBode sucuBode) throws Exception;

	public SucuBode buscarPorId(Integer id) throws Exception;

}
