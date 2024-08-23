package ec.com.tecnointel.soem.caja.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.caja.modelo.SaliArch;

@Local
public interface SaliArchRegisInt {

	public Object insertar(SaliArch saliArch) throws Exception;

	public void modificar(SaliArch saliArch) throws Exception;

	public void eliminar(SaliArch saliArch) throws Exception;

	public SaliArch buscarPorId(Integer id) throws Exception;
	
}
