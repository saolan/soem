package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Bodega;

@Local
public interface BodegaRegisInt {

	public Object insertar(Bodega bodega) throws Exception;

	public void modificar(Bodega bodega) throws Exception;

	public void eliminar(Bodega bodega) throws Exception;

	public Bodega buscarPorId(Integer id) throws Exception;

}
