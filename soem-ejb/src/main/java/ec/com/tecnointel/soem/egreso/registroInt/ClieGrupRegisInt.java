package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrup;

@Local
public interface ClieGrupRegisInt {

	public Object insertar(ClieGrup clieGrup) throws Exception;

	public void modificar(ClieGrup clieGrup) throws Exception;

	public void eliminar(ClieGrup clieGrup) throws Exception;

	public ClieGrup buscarPorId(Integer id) throws Exception;

}
