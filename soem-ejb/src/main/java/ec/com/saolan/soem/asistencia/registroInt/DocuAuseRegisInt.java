package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.DocuAuse;

@Local
public interface DocuAuseRegisInt {

	public Object insertar(DocuAuse docuAuse) throws Exception;

	public void modificar(DocuAuse docuAuse) throws Exception;

	public void eliminar(DocuAuse docuAuse) throws Exception;

	public DocuAuse buscarPorId(Integer id) throws Exception;

}
