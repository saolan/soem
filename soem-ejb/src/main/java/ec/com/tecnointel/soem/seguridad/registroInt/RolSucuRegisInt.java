package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolSucu;

@Local
public interface RolSucuRegisInt {

	public Object insertar(RolSucu rolSucu) throws Exception;

	public void modificar(RolSucu rolsucu) throws Exception;

	public void eliminar(RolSucu rolSucu) throws Exception;

	public RolSucu buscarPorId(Integer id) throws Exception;

}
