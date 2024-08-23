package ec.com.tecnointel.soem.tesoreria.registroInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.CajaMovi;
import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviEgre;

@Local
public interface FormPagoMoviEgreRegisInt {

	public Object insertar(FormPagoMoviEgre formPagoMoviEgre) throws Exception;

	public void modificar(FormPagoMoviEgre formPagoMoviEgre) throws Exception;

	public void eliminar(FormPagoMoviEgre formPagoMoviEgre) throws Exception;

	public FormPagoMoviEgre buscarPorId(Integer id) throws Exception;
	
	public Integer actualizarFpme(CajaMovi cajaMovi, Integer transaccionId) throws Exception;

	List<Object[]> buscarFpmeRefere(String refere) throws Exception;
}
