package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.Nomina;

@Local
public interface NominaRegisInt {

	public Object insertar(Nomina nomina) throws Exception;

	public void modificar(Nomina nomina) throws Exception;

	public void eliminar(Nomina nomina) throws Exception;

	public Nomina buscarPorId(Integer id) throws Exception;

}
