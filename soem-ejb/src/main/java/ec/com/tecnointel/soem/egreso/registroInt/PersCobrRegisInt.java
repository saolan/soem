package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.PersCobr;

@Local
public interface PersCobrRegisInt {

	public Object insertar(PersCobr persCobr) throws Exception;

	public void modificar(PersCobr persCobr) throws Exception;

	public void eliminar(PersCobr persCobr) throws Exception;

	public PersCobr buscarPorId(Integer id) throws Exception;

}
