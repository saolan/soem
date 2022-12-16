package ec.com.tecnointel.soem.seguridad.controlador;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.tecnointel.soem.parametro.modelo.Parametro;
import ec.com.tecnointel.soem.parametro.registroInt.ParametroRegisInt;
import ec.com.tecnointel.soem.seguridad.registroInt.RespaldoBaseInt;

@Named
@ViewScoped
public class RespaldoControl implements Serializable {

	String host;
	String puerto;
	String usuario;
	String clave;
	String formato;
	String base;
	String rutaRespaldo;
	String rutaPgDump;
	
	String resumenRespaldo;
		
	@Inject
	RespaldoBaseInt respaldoBase;
	
	@Inject
	ParametroRegisInt parametroRegis;
	
	private static final long serialVersionUID = 9210912602890323047L;
	
	@PostConstruct
	public void cargar() {

		this.cargarParametros();
	}


	public void respaldar() {
		
		boolean respaldo;
		
		try {
			respaldo = respaldoBase.respaldar(host, puerto, usuario, clave, formato, base, rutaRespaldo, rutaPgDump);
			
			if (respaldo) {
				resumenRespaldo = "Respaldo realizado exitosamente";
			} else {
				resumenRespaldo = "Respaldo no realizado. Intente nuevamente";
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al respaldar base de datos, Intente nuevamente"));
			e.printStackTrace();
		}
	}
	
	public void cargarParametros() {
		
		Parametro parametro = new Parametro();;
		
		try {
			
			parametro = parametroRegis.buscarPorId(7001);
			this.host = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar host (7001)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7002);
			this.puerto = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar puerto (7002)"));
			e.printStackTrace();
		}
		
		try {
			
			parametro = parametroRegis.buscarPorId(7003);
			this.usuario = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar usuario (7003)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7004);
			this.clave = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar clave (7004)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7005);
			this.formato = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar formato (7005)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7006);
			this.base = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar base (7006)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7007);
			this.rutaRespaldo = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar rutaRespaldo (7007)"));
			e.printStackTrace();
		}

		try {
			
			parametro = parametroRegis.buscarPorId(7008);
			this.rutaPgDump = parametro.getDescri();
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar rutaPgDump (7008)"));
			e.printStackTrace();
		}
	}

	public String getResumenRespaldo() {
		return resumenRespaldo;
	}

	public void setResumenRespaldo(String resumenRespaldo) {
		this.resumenRespaldo = resumenRespaldo;
	}
}
