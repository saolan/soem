package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.ReteDeta;

@Local
public interface ReteDetaRegisInt {

	public Object insertar(ReteDeta reteDeta) throws Exception;

	public void modificar(ReteDeta reteDeta) throws Exception;

	public void eliminar(ReteDeta reteDeta) throws Exception;

	public ReteDeta buscarPorId(Integer id) throws Exception;

}
