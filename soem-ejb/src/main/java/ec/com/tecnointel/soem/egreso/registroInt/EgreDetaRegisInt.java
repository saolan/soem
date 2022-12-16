package ec.com.tecnointel.soem.egreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.egreso.modelo.EgreDeta;

@Local
public interface EgreDetaRegisInt {

	public Object insertar(EgreDeta egreDeta) throws Exception;

	public void modificar(EgreDeta egreDeta) throws Exception;

	public void eliminar(EgreDeta egreDeta) throws Exception;

	public EgreDeta buscarPorId(Integer id) throws Exception;

}
