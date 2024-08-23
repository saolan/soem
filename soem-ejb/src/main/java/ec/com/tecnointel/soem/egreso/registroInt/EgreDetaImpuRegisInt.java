package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.EgreDetaImpu;

@Local
public interface EgreDetaImpuRegisInt {

	public Object insertar(EgreDetaImpu egreDetaImpu) throws Exception;

	public void modificar(EgreDetaImpu egreDetaImpu) throws Exception;

	public void eliminar(EgreDetaImpu egreDetaImpu) throws Exception;

	public EgreDetaImpu buscarPorId(Integer id) throws Exception;

}
