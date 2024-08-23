package ec.com.tecnointel.soem.atsSri.registroInt;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

@Local
public interface GenerarAtsSriInt {
	public ByteArrayOutputStream generarAtsSriXml(Sucursal sucursal, LocalDate fechaDesd, LocalDate fechaHast) throws Exception;
}
