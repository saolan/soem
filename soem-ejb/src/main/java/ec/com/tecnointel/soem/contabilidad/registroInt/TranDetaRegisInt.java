package ec.com.tecnointel.soem.contabilidad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.contabilidad.modelo.TranDeta;

@Local
public interface TranDetaRegisInt {

	public Object insertar(TranDeta tranDeta) throws Exception;

	public void modificar(TranDeta tranDeta) throws Exception;

	public void eliminar(TranDeta tranDeta) throws Exception;

	public TranDeta buscarPorId(Integer id) throws Exception;

}
