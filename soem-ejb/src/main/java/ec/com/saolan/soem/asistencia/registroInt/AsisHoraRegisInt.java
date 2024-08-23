package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AsisHora;

@Local
public interface AsisHoraRegisInt {

	public Object insertar(AsisHora asisHora) throws Exception;

	public void modificar(AsisHora asisHora) throws Exception;

	public void eliminar(AsisHora asisHora) throws Exception;

	public AsisHora buscarPorId(Integer id) throws Exception;

}
