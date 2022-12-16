package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AuseAuto;

@Local
public interface AuseAutoRegisInt {

	public Object insertar(AuseAuto auseAuto) throws Exception;

	public void modificar(AuseAuto auseAuto) throws Exception;

	public void eliminar(AuseAuto auseAuto) throws Exception;

	public AuseAuto buscarPorId(Integer id) throws Exception;

}
