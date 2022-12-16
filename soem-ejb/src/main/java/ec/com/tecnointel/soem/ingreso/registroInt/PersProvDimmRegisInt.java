package ec.com.tecnointel.soem.ingreso.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.PersProvDimm;

@Local
public interface PersProvDimmRegisInt {

	public Object insertar(PersProvDimm persProvDimm) throws Exception;

	public void modificar(PersProvDimm persProvDimm) throws Exception;

	public void eliminar(PersProvDimm persProvDimm) throws Exception;

	public PersProvDimm buscarPorId(Integer id) throws Exception;

}
