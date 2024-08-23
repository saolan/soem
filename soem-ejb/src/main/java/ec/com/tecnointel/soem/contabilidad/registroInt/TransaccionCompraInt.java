package ec.com.tecnointel.soem.contabilidad.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;
import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviIngr;

@Local
public interface TransaccionCompraInt {

	Integer contabilizarCompra(Ingreso ingreso) throws Exception;

	Integer contabilizarIngreso(Ingreso ingreso) throws Exception;

	Integer contabilizarNotaCredito(Ingreso ingreso, FormPagoMoviIngr fpmi, String tipoTran) throws Exception;

}
