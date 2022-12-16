package ec.com.tecnointel.soem.general.filtro;

/*

Clase de prueba para realizar un Listener por programacion
 
*/

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

//@WebListener
public class InicioSesionListenerPrueba implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		System.out.println("===================================== requestDestroyed ");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("===================================== requestInitialized ");
	}

}
