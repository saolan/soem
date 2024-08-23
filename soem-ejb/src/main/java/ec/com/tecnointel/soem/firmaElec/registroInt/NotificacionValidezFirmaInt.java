package ec.com.tecnointel.soem.firmaElec.registroInt;

import javax.ejb.Local;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

@Local
public interface NotificacionValidezFirmaInt {
	
	/**
	Retorna FECHA_VALIDA si la firma todavia esta vigente
	Parametro Sucursal a la que pertenece la firma electrónica 
	*/
	String notificacion(Sucursal sucursal) throws Exception;
}
