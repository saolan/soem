package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Documento;

@Local
public interface DocumentoRegisInt {

	public Object insertar(Documento documento) throws Exception;

	public void modificar(Documento documento) throws Exception;

	public void eliminar(Documento documento) throws Exception;

	public Documento buscarPorId(Integer id) throws Exception;

}
