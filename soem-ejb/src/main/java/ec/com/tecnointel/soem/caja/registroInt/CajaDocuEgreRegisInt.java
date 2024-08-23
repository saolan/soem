package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaDocuEgre;

@Local
public interface CajaDocuEgreRegisInt {

	public Object insertar(CajaDocuEgre cajaDocuEgre) throws Exception;

	public void modificar(CajaDocuEgre cajaDocuEgre) throws Exception;

	public void eliminar(CajaDocuEgre cajaDocuEgre) throws Exception;

	public CajaDocuEgre buscarPorId(Integer id) throws Exception;

}
