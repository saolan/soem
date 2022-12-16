package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.PersVend;

@Local
public interface PersVendRegisInt {

	public Object insertar(PersVend persVend) throws Exception;

	public void modificar(PersVend persVend) throws Exception;

	public void eliminar(PersVend persVend) throws Exception;

	public PersVend buscarPorId(Integer id) throws Exception;

}
