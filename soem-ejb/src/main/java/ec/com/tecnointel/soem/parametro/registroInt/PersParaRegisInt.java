package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.PersPara;

@Local
public interface PersParaRegisInt {

	public Object insertar(PersPara persPara) throws Exception;

	public void modificar(PersPara persPara) throws Exception;

	public void eliminar(PersPara persPara) throws Exception;

	public PersPara buscarPorId(Integer id) throws Exception;

}
