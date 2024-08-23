package ec.com.tecnointel.soem.parametro.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.SucuPara;

@Local
public interface SucuParaRegisInt {

	public Object insertar(SucuPara sucuPara) throws Exception;

	public void modificar(SucuPara sucuPara) throws Exception;

	public void eliminar(SucuPara sucuPara) throws Exception;

	public SucuPara buscarPorId(Integer id) throws Exception;

}
