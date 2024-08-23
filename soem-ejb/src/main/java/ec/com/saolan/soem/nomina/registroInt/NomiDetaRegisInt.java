package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.NomiDeta;

@Local
public interface NomiDetaRegisInt {

	public Object insertar(NomiDeta nomiMovi) throws Exception;

	public void modificar(NomiDeta nomiMovi) throws Exception;

	public void eliminar(NomiDeta nomiMovi) throws Exception;

	public NomiDeta buscarPorId(Integer id) throws Exception;

}
