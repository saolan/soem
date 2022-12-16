package ec.com.tecnointel.soem.seguridad.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.seguridad.listaInt.SecuencialListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.Secuencial;
import ec.com.tecnointel.soem.seguridad.registroInt.SecuencialRegisInt;

@Named
@ViewScoped
public class SecuencialControl extends PaginaControl implements Serializable {

	private Secuencial secuencial;

	List<Secuencial> secuencials;

	@Inject
	SecuencialRegisInt secuencialRegis;

	@Inject
	SecuencialListaInt secuencialLista;

	private static final long serialVersionUID = -4149106200972544336L;

	@PostConstruct
	public void cargar() {

		secuencial = new Secuencial();

	}

	public void buscar() {

		try {
			
			secuencialLista.filasPagina(variablesSesion.getFilasPagina());
			
			this.secuencials = secuencialLista.buscar(secuencial, this.pagina);
			this.numeroReg = secuencials.size();
			this.contadorReg = secuencialLista.contarRegistros(secuencial);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar datos"));
			e.printStackTrace();
		}
	}

	public void recuperar() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext.isPostback() && facesContext.isValidationFailed()) {
			return;
		}

		if (this.id == null) {
			this.secuencial = new Secuencial();
		} else {

			try {
				this.secuencial = secuencialRegis.buscarPorId(this.getId());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar Id"));
				e.printStackTrace();
			}
		}
	}

	public String grabar() {

		// Los mensajes tienen RequestScope y se borran al navegar a otro pagina
		// Con este comando se guarda los mensages de confirmaci�n en navegacion
		// entre paginas
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		try {
			if (this.id == null) {
				Object id = secuencialRegis.insertar(secuencial);
				this.id = (Integer) id;
			} else {
				secuencialRegis.modificar(secuencial);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al grabar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro grabado"));

		return "lista?faces-redirect=true";
	}

	public String modificar() {
		return "registra?faces-redirect=true&secuencialId=" + this.getId();
	}

	public String explorar() {
		return "explora?faces-redirect=true&secuencialId=" + this.getId();
	}

	public String eliminar() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		try {
			Secuencial secuencial = secuencialRegis.buscarPorId(this.getId());
			secuencialRegis.eliminar(secuencial);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al eliminar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro eliminado"));

		return "lista?faces-redirect=true";
	}

	public List<Secuencial> buscarTodo() {

		List<Secuencial> secuencials = new ArrayList<>();

		try {
			secuencials = secuencialLista.buscarTodo("tabla");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar todo"));
			e.printStackTrace();
		}
		return secuencials;
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public Secuencial getSecuencial() {
		return secuencial;
	}

	public void setSecuencial(Secuencial secuencial) {
		this.secuencial = secuencial;
	}

	public List<Secuencial> getSecuencials() {
		return secuencials;
	}

	public void setSecuencials(List<Secuencial> secuencials) {
		this.secuencials = secuencials;
	}


	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// Estas 3 Lineas llaman al metodo cuando se abra la pagina es similar a
	// @PostConstructor
	// <f:metadata>
	// <f:event type="preRenderView"
	// listener='#{categoriaControlador.buscarTodo}' />
	// </f:metadata>

	// public void buscarTodo() {
	// try {
	// this.categorias =
	// categoriaConsultaInterface.categoriaConsultar(this.getCategoria());
	// } catch (Exception e) {
	// // TODOs Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}