package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersTipo;

@Local
public interface AcciPersTipoRegisInt {

	public Object insertar(AcciPersTipo acciPersTipo) throws Exception;

	public void modificar(AcciPersTipo acciPersTipo) throws Exception;

	public void eliminar(AcciPersTipo acciPersTipo) throws Exception;

	public AcciPersTipo buscarPorId(Integer id) throws Exception;

}
