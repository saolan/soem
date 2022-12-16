package ec.com.saolan.soem.asistencia.registroInt;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.HoraPlanDeta;

@Local
public interface HoraPlanDetaRegisInt {

	public Object insertar(HoraPlanDeta horaPlanDeta) throws Exception;

	public void modificar(HoraPlanDeta horaPlanDeta) throws Exception;

	public void eliminar(HoraPlanDeta horaPlanDeta) throws Exception;

	public HoraPlanDeta buscarPorId(Integer id) throws Exception;

}
