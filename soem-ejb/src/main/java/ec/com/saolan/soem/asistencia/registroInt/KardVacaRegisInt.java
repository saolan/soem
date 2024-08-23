package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.KardVaca;

@Local
public interface KardVacaRegisInt {

	public Object insertar(KardVaca kardVaca) throws Exception;

	public void modificar(KardVaca kardVaca) throws Exception;

	public void eliminar(KardVaca kardVaca) throws Exception;

	public KardVaca buscarPorId(Integer id) throws Exception;

}
