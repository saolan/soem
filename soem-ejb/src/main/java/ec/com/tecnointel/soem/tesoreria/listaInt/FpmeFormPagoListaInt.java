package ec.com.tecnointel.soem.tesoreria.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.tecnointel.soem.tesoreria.modelo.FpmeFormPago;

@Local
public interface FpmeFormPagoListaInt {

	public List<FpmeFormPago> buscar(FpmeFormPago fpmeFormPago, Integer pagina) throws Exception;

	public long contarRegistros(FpmeFormPago fpmeFormPago) throws Exception;

	public void filasPagina(int filasPagina);

}
