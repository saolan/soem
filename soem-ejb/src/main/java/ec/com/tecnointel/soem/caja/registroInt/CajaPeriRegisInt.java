package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaPeri;

@Local
public interface CajaPeriRegisInt {

	public Object insertar(CajaPeri cajaPeri) throws Exception;

	public void modificar(CajaPeri cajaPeri) throws Exception;

	public void eliminar(CajaPeri cajaPeri) throws Exception;

	public CajaPeri buscarPorId(Integer id) throws Exception;

}
