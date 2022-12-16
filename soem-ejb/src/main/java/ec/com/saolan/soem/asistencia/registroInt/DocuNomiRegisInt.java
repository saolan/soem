package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.DocuNomi;

@Local
public interface DocuNomiRegisInt {

	public Object insertar(DocuNomi docuNomi) throws Exception;

	public void modificar(DocuNomi docuNomi) throws Exception;

	public void eliminar(DocuNomi docuNomi) throws Exception;

	public DocuNomi buscarPorId(Integer id) throws Exception;

}
