package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AuseRecu;

@Local
public interface AuseRecuRegisInt {

	public Object insertar(AuseRecu auseRecu) throws Exception;

	public void modificar(AuseRecu auseRecu) throws Exception;

	public void eliminar(AuseRecu auseRecu) throws Exception;

	public AuseRecu buscarPorId(Integer id) throws Exception;

}
