package ec.com.tecnointel.soem.general.filtro;

/*
 
Clase de prueba para realizar un filtro por programacion
 
*/

import java.util.EnumSet;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import ec.com.tecnointel.soem.seguridad.listaInt.PersUsuaListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.PersUsua;

//@WebListener
public class IniciarFiltroPrueba implements javax.servlet.ServletContextListener {

	int aux = 1;

	@Inject
	PersUsuaListaInt persUsuaLista;

	@Override
	public void contextDestroyed(ServletContextEvent context) {
	}

	@Override
	public void contextInitialized(ServletContextEvent context) {

		ServletContext ctx = context.getServletContext();

		try {
			List<PersUsua> persUsuarios = persUsuaLista.buscarTodo("personaId");

			System.out.println("============================== persUsuarios.size " + persUsuarios.size());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("========================== Iniciando contexto" + ctx.getContextPath());

		if (aux == 1) {
			// if we are running in production mode
			// register with servletContext
			FilterRegistration fr = ctx.addFilter("InicioSesionFiltro", PpsjFiltro.class);
			fr.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD), true, "/ppsj/*");
		}
	}

	// @Override
	// public void onStartup(Set<Class<?>> arg0, ServletContext servletContext)
	// throws ServletException {
	//
	// System.out.println("==============================================
	// IniciarFiltro");
	//
	//// if (servletContext.getContextPath().contains("Test")) {
	//
	// System.out.println(" ======================================= filtro
	// activado " + servletContext.getContextPath()) ;
	//
	// InicioSesionFiltro filtro =
	// servletContext.createFilter(InicioSesionFiltro.class);
	//// FilterRegistration registro = servletContext.addFilter("filtro",
	// filtro);
	//// registro.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST,
	// DispatcherType.FORWARD), true, "/*");
	//
	// FilterRegistration.Dynamic filtroDinamico =
	// servletContext.addFilter("filtro", filtro);
	// filtroDinamico.addMappingForUrlPatterns(null, false, "/");
	//
	//// } else {
	//// System.out.println("filtro desactivado");
	//// }
	// }
}
