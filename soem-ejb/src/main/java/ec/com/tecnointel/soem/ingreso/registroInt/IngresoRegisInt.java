package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;

@Local
public interface IngresoRegisInt {

	public Object insertar(Ingreso ingreso) throws Exception;

	public void modificar(Ingreso ingreso) throws Exception;

	public void eliminar(Ingreso ingreso) throws Exception;

	public Ingreso buscarPorId(Integer id) throws Exception;

}
