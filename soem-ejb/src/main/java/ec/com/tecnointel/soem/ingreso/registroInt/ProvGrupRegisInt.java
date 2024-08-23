package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.ProvGrup;

@Local
public interface ProvGrupRegisInt {

	public Object insertar(ProvGrup provGrup) throws Exception;

	public void modificar(ProvGrup provGrup) throws Exception;

	public void eliminar(ProvGrup provGrup) throws Exception;

	public ProvGrup buscarPorId(Integer id) throws Exception;

}
