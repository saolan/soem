package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Dimm;

@Local
public interface DimmRegisInt {

	public Object insertar(Dimm dimm) throws Exception;

	public void modificar(Dimm dimm) throws Exception;

	public void eliminar(Dimm dimm) throws Exception;

	public Dimm buscarPorId(Integer id) throws Exception;

}
