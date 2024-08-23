package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.Egreso;

@Local
public interface EgresoRegisInt {

	public Object insertar(Egreso egreso) throws Exception;

	public void modificar(Egreso egreso) throws Exception;

	public void eliminar(Egreso egreso) throws Exception;

	public Egreso buscarPorId(Integer id) throws Exception;

}
