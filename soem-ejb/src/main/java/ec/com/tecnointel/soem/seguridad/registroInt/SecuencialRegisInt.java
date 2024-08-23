package ec.com.tecnointel.soem.seguridad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.seguridad.modelo.Secuencial;

@Local
public interface SecuencialRegisInt {

	public Object insertar(Secuencial secuencial) throws Exception;

	public void modificar(Secuencial secuencial) throws Exception;

	public void eliminar(Secuencial secuencial) throws Exception;

	public Secuencial buscarPorId(Integer id) throws Exception;

}
