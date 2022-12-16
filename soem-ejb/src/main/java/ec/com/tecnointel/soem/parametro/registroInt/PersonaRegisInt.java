package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Persona;

@Local
public interface PersonaRegisInt {

	public Object insertar(Persona persona) throws Exception;

	public void modificar(Persona persona) throws Exception;

	public void eliminar(Persona persona) throws Exception;

	public Persona buscarPorId(Integer id) throws Exception;

}
