package ec.com.saolan.soem.nomina.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.nomina.modelo.AcciPersAuto;

@Local
public interface AcciPersAutoRegisInt {

	public Object insertar(AcciPersAuto acciPersAuto) throws Exception;

	public void modificar(AcciPersAuto acciPersAuto) throws Exception;

	public void eliminar(AcciPersAuto acciPersAuto) throws Exception;

	public AcciPersAuto buscarPorId(Integer id) throws Exception;

}
