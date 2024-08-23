package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.FeriMapa;

@Local
public interface FeriMapaRegisInt {

	public Object insertar(FeriMapa feriMapa) throws Exception;

	public void modificar(FeriMapa feriMapa) throws Exception;

	public void eliminar(FeriMapa feriMapa) throws Exception;

	public FeriMapa buscarPorId(Integer id) throws Exception;

}
