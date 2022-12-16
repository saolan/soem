package ec.com.tecnointel.soem.contabilidad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.contabilidad.modelo.Transaccion;

@Local
public interface TransaccionRegisInt {

	public Object insertar(Transaccion transaccion) throws Exception;

	public void modificar(Transaccion transaccion) throws Exception;

	public void eliminar(Transaccion transaccion) throws Exception;

	public Transaccion buscarPorId(Integer id) throws Exception;

}
