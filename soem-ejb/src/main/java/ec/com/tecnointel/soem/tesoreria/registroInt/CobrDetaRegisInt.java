package ec.com.tecnointel.soem.tesoreria.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.CobrDeta;

@Local
public interface CobrDetaRegisInt {

	public Object insertar(CobrDeta cobrDeta) throws Exception;

	public void modificar(CobrDeta cobrDeta) throws Exception;

	public void eliminar(CobrDeta cobrDeta) throws Exception;

	public CobrDeta buscarPorId(Integer id) throws Exception;

}
