package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.MapaNive;

@Local
public interface MapaNiveRegisInt {

	public Object insertar(MapaNive mapaNive) throws Exception;

	public void modificar(MapaNive mapaNive) throws Exception;

	public void eliminar(MapaNive mapaNive) throws Exception;

	public MapaNive buscarPorId(Integer id) throws Exception;

}
