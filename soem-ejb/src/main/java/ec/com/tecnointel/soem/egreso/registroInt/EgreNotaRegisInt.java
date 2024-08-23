package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.EgreNota;

@Local
public interface EgreNotaRegisInt {

	public Object insertar(EgreNota egreNota) throws Exception;

	public void modificar(EgreNota egreNota) throws Exception;

	public void eliminar(EgreNota egreNota) throws Exception;

	public EgreNota buscarPorId(Integer id) throws Exception;

}
