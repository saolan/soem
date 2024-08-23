package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.TipoCont;

@Local
public interface TipoContRegisInt {

	public Object insertar(TipoCont tipoCont) throws Exception;

	public void modificar(TipoCont tipoCont) throws Exception;

	public void eliminar(TipoCont tipoCont) throws Exception;

	public TipoCont buscarPorId(Integer id) throws Exception;

}
