package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMovi;

@Local
public interface CajaMoviRegisInt {

	public Object insertar(CajaMovi cajaMovi) throws Exception;

	public void modificar(CajaMovi cajaMovi) throws Exception;

	public void eliminar(CajaMovi cajaMovi) throws Exception;

	public CajaMovi buscarPorId(Integer id) throws Exception;

}
