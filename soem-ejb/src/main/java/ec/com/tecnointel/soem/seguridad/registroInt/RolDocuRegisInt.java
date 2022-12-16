package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Local
public interface RolDocuRegisInt {

	public Object insertar(RolDocu rolDocu) throws Exception;

	public void modificar(RolDocu rolDocu) throws Exception;

	public void eliminar(RolDocu rolDocu) throws Exception;

	public RolDocu buscarPorId(Integer id) throws Exception;

}
