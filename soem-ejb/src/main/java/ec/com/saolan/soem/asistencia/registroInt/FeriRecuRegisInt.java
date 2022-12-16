package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.FeriRecu;

@Local
public interface FeriRecuRegisInt {

	public Object insertar(FeriRecu feriRecu) throws Exception;

	public void modificar(FeriRecu feriRecu) throws Exception;

	public void eliminar(FeriRecu feriRecu) throws Exception;

	public FeriRecu buscarPorId(Integer id) throws Exception;

}
