package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviTran;

@Local
public interface CajaMoviTranRegisInt {

	public Object insertar(CajaMoviTran cajaMoviTran) throws Exception;

	public void modificar(CajaMoviTran cajaMoviTran) throws Exception;

	public void eliminar(CajaMoviTran cajaMoviTran) throws Exception;

	public CajaMoviTran buscarPorId(Integer id) throws Exception;

}
