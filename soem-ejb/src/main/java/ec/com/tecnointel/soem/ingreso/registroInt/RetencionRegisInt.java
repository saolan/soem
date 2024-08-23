package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Retencion;

@Local
public interface RetencionRegisInt {

	public Object insertar(Retencion retencion) throws Exception;

	public void modificar(Retencion retencion) throws Exception;

	public void eliminar(Retencion retencion) throws Exception;

	public Retencion buscarPorId(Integer id) throws Exception;

}
