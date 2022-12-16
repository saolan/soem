package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuPrec;

@Local
public interface SucuPrecRegisInt {

	public Object insertar(SucuPrec sucuPrec) throws Exception;

	public void modificar(SucuPrec sucuPrec) throws Exception;

	public void eliminar(SucuPrec sucuPrec) throws Exception;

	public SucuPrec buscarPorId(Integer id) throws Exception;

}
