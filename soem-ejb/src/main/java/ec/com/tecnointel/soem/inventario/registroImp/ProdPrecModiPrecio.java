package ec.com.tecnointel.soem.inventario.registroImp;

import java.math.BigDecimal;

import javax.ejb.Local;

import ec.com.tecnointel.soem.inventario.modelo.ProdPrec;

@Local	
public interface ProdPrecModiPrecio {

	ProdPrec calcularPrecio(ProdPrec prodPrec, BigDecimal porcentaje, int redondeo) throws Exception;

}
