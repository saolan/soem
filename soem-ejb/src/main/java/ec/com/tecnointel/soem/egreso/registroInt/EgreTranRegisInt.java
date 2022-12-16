package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.EgreTran;

@Local
public interface EgreTranRegisInt {

	public Object insertar(EgreTran egreTran) throws Exception;

	public void modificar(EgreTran egreTran) throws Exception;

	public void eliminar(EgreTran egreTran) throws Exception;

	public EgreTran buscarPorId(Integer id) throws Exception;

}
