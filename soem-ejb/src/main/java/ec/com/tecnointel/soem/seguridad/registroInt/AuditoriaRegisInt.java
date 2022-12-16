package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Auditoria;

@Local
public interface AuditoriaRegisInt {

	public Object insertar(Auditoria auditoria) throws Exception;

	public void modificar(Auditoria auditoria) throws Exception;

	public void eliminar(Auditoria auditoria) throws Exception;

	public Auditoria buscarPorId(Integer id) throws Exception;

}
