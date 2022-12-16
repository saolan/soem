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
import ec.com.tecnointel.soem.parametro.listaInt.FormPagoListaInt;
import ec.com.tecnointel.soem.parametro.modelo.FormPago;
import ec.com.tecnointel.soem.seguridad.listaInt.RolFormPagoListaInt;
import ec.com.tecnointel.soem.seguridad.listaInt.RolListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.Rol;
import ec.com.tecnointel.soem.seguridad.modelo.RolFormPago;
import ec.com.tecnointel.soem.seguridad.registroInt.RolFormPagoRegisInt;

@Named
@ViewScoped
public class RolFormPagoControl extends PaginaControl implements Serializable {

	private Integer rolId;
	private String paginaRuta;
	
	private RolFormPago rolFormPago;

	private List<RolFormPago> rolFormPagos;
	private List<Rol> rols;
	private List<FormPago> formPagos;

	@Inject
	RolFormPagoRegisInt rolFormPagoRegis;

	@Inject
	RolFormPagoListaInt rolFormPagoLista;
	
	@Inject
	RolListaInt rolLista;
	
	@Inject
	FormPagoListaInt formPagoLista;


	private static final long serialVersionUID = -51204619252503221L;

	@PostConstruct
	public void cargar() {
		rolFormPago = new RolFormPago();
		rolFormPago.setRol(new Rol());
		rolFormPago.setFormPago(new FormPago());

	}

	public void buscar() {

		try {
			
			rolFormPagoLista.filasPagina(variablesSesion.getFilasPagina());
			
			this.rolFormPagos = rolFormPagoLista.buscar(rolFormPago, this.pagina);
			this.numeroReg = rolFormPagos.size();
			this.contadorReg = rolFormPagoLista.contarRegistros(rolFormPago);
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

		this.getRolFormPago().getRol().setRolId(rolId);
		this.buscarRols();
		this.buscarFormPagos();

		if (this.id == null) {
			this.rolFormPago = new RolFormPago();
			this.rolFormPago.setAcceso(true);
		} else {

			try {
				this.rolFormPago = rolFormPagoRegis.buscarPorId(this.getId());
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
				Object id = rolFormPagoRegis.insertar(rolFormPago);
				this.id = (Integer) id;
			} else {
				rolFormPagoRegis.modificar(rolFormPago);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al grabar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro grabado"));

		if (this.getRolId() != null){
			return paginaRuta + "?faces-redirect=true&rolId=" + this.getRolId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}
	
	public String nuevo() {
		
		if (this.getRolId() != null){
			return "/ppsj/seguridad/rolFormPago/registra?faces-redirect=true&rolId=" + this.getRolId() + "&paginaRuta=" + this.getPaginaRuta();			
		} else {
			return "/ppsj/seguridad/rolFormPago/registra?faces-redirect=true&paginaRuta=" + this.getPaginaRuta(); 
		}

	}
	public String modificar() {
		if (this.getRolId() != null){
			return "/ppsj/seguridad/rolFormPago/registra?faces-redirect=true&rolFormPagoId=" + this.getId() + "&rolId=" + this.getRolId() + "&paginaRuta=" + this.getPaginaRuta();
		} else {
			return "/ppsj/seguridad/rolFormPago/registra?faces-redirect=true&rolFormPagoId=" + this.getId() + "&paginaRuta=" + this.getPaginaRuta();
		}
	}
	
	public String explorar() {
		return "explora?faces-redirect=true&rolFormPagoId=" + this.getId();
	}

	public String eliminar() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		try {
			RolFormPago rolFormPago = rolFormPagoRegis.buscarPorId(this.getId());
			rolFormPagoRegis.eliminar(rolFormPago);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al eliminar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro eliminado"));

		if (this.getRolId() != null){
			return paginaRuta + "?faces-redirect=true&rolId=" + this.getRolId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}
	
	public String cancelar(){
		
		if (this.getRolId() != null){
			return paginaRuta + "?faces-redirect=true&rolId=" + this.getRolId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}

	public List<RolFormPago> buscarTodo() {

		List<RolFormPago> rolFormPagos = new ArrayList<>();

		try {
			rolFormPagos = rolFormPagoLista.buscarTodo("rolFormPagoId");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar todo"));
			e.printStackTrace();
		}
		return rolFormPagos;
	}
	
	public void buscarRols() {

		this.getRolFormPago().getRol().setEstado(true);
		
		try {
			this.rols = rolLista.buscar(this.getRolFormPago().getRol(), null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion Buscar Rol - Error al buscar roles"));
			e.printStackTrace();
		}
	}
	
	public void buscarFormPagos() {

		this.getRolFormPago().getFormPago().setEstado(true);
		
		try {
			this.formPagos = formPagoLista.buscar(this.getRolFormPago().getFormPago(), null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion Buscar Bodega - Error al buscar formas de pago"));
			e.printStackTrace();
		}
	}
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public RolFormPago getRolFormPago() {
		return rolFormPago;
	}

	public void setRolFormPago(RolFormPago rolFormPago) {
		this.rolFormPago = rolFormPago;
	}

	public List<RolFormPago> getRolFormPagos() {
		return rolFormPagos;
	}

	public void setRolFormPagos(List<RolFormPago> rolFormPagos) {
		this.rolFormPagos = rolFormPagos;
	}

	public Integer getRolId() {
		return rolId;
	}

	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}

	public List<Rol> getRols() {
		return rols;
	}

	public void setRols(List<Rol> rols) {
		this.rols = rols;
	}

	public List<FormPago> getFormPagos() {
		return formPagos;
	}

	public void setFormPagos(List<FormPago> formPagos) {
		this.formPagos = formPagos;
	}

	public String getPaginaRuta() {
		return paginaRuta;
	}

	public void setPaginaRuta(String paginaRuta) {
		this.paginaRuta = paginaRuta;
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