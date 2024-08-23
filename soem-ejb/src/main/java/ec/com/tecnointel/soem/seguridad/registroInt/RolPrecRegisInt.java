package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.RolPrec;

@Local
public interface RolPrecRegisInt {

	public Object insertar(RolPrec rolPrec) throws Exception;

	public void modificar(RolPrec rolPrec) throws Exception;

	public void eliminar(RolPrec rolPrec) throws Exception;

	public RolPrec buscarPorId(Integer id) throws Exception;

}
