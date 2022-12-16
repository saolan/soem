package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Mapa;

@Local
public interface MapaRegisInt {

	public Object insertar(Mapa mapa) throws Exception;

	public void modificar(Mapa mapa) throws Exception;

	public void eliminar(Mapa mapa) throws Exception;

	public Mapa buscarPorId(Integer id) throws Exception;

}
