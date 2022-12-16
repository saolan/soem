package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.Periferico;

@Local
public interface PerifericoRegisInt {

	public Object insertar(Periferico periferico) throws Exception;

	public void modificar(Periferico periferico) throws Exception;

	public void eliminar(Periferico periferico) throws Exception;

	public Periferico buscarPorId(Integer id) throws Exception;

}
