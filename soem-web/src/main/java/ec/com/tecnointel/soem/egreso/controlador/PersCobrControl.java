package ec.com.tecnointel.soem.egreso.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.tecnointel.soem.egreso.listaInt.PersCobrListaInt;
import ec.com.tecnointel.soem.egreso.modelo.PersCobr;
import ec.com.tecnointel.soem.egreso.registroInt.PersCobrRegisInt;
import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.parametro.modelo.Persona;
import ec.com.tecnointel.soem.parametro.registroInt.PersonaRegisInt;

@Named
@ViewScoped
public class PersCobrControl extends PaginaControl implements Serializable {

	private Integer personaId;
	private String paginaRuta;
	
	private PersCobr persCobr;
	List<PersCobr> persCobrs;

	@Inject
	PersCobrRegisInt persCobrRegis;

	@Inject
	PersCobrListaInt persCobrLista;
	
	@Inject
	PersonaRegisInt personaRegis;


	private static final long serialVersionUID = -1017072291711645225L;

	@PostConstruct
	public void cargar() {

		persCobr = new PersCobr();
		persCobr.setPersona(new Persona());
		persCobr.setEstado(true);

		this.rolPermiso = variablesSesion.getRolPermiso();
	}

	public void buscar() {

		try {
			
			persCobrLista.filasPagina(variablesSesion.getFilasPagina());
			
			this.persCobrs = persCobrLista.buscar(persCobr, this.pagina);
			this.numeroReg = persCobrs.size();
			this.contadorReg = persCobrLista.contarRegistros(persCobr);
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
			this.persCobr = new PersCobr();
			this.persCobr.setPersona(new Persona());
			this.persCobr.setEstado(true);
			
			if (this.personaId != null) {
				
				Persona persona = new Persona();
				try {
					persona =  personaRegis.buscarPorId(this.getPersonaId());
					this.persCobr.setPersona(persona);
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al persona"));
					e.printStackTrace();
				}
			}

		} else {

			try {
				this.persCobr = persCobrRegis.buscarPorId(this.getId());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar Id"));
				e.printStackTrace();
			}
		}
	}

	public String grabar() {

		String campoTexto;
		
		campoTexto = this.persCobr.getPersona().getCedulaRuc().trim();
		this.persCobr.getPersona().setCedulaRuc(campoTexto);

		campoTexto = this.persCobr.getPersona().getApelli().trim();
		this.persCobr.getPersona().setApelli(campoTexto);

		if (this.persCobr.getPersona().getNombre() != null) {
			campoTexto = this.persCobr.getPersona().getNombre().trim();
			this.persCobr.getPersona().setNombre(campoTexto);
		}

		try {
			if (this.id == null) {
				this.persCobr.getPersona().setEstado(true);
				Object id = persCobrRegis.insertar(persCobr);
				this.id = (Integer) id;
			} else {
				persCobrRegis.modificar(persCobr);
			}
		} catch (RuntimeException e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error cédula o Ruc ya existe"));
			e.printStackTrace();
			return null;			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al grabar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro grabado"));

		if (this.getPersonaId() != null){
			return paginaRuta + "?faces-redirect=true&personaId=" + this.getPersonaId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}
	
	public String nuevo() {
		
		if (this.getPersonaId() != null){
			return "/ppsj/egreso/persCobr/registra?faces-redirect=true&personaId=" + this.getPersonaId() + "&paginaRuta=" + this.getPaginaRuta();			
		} else {
			return "/ppsj/egreso/persCobr/registra?faces-redirect=true&paginaRuta=" + this.getPaginaRuta(); 
		}

	}
	
	public String modificar() {
		if (this.getPersonaId() != null){
			return "/ppsj/egreso/persCobr/registra?faces-redirect=true&persCobrId=" + this.getId() + "&personaId=" + this.getPersonaId() + "&paginaRuta=" + this.getPaginaRuta();	
		} else {
			return "/ppsj/egreso/persCobr/registra?faces-redirect=true&persCobrId=" + this.getId() + "&paginaRuta=" + this.getPaginaRuta();	
		}
	}


//	Se llama solo desde personaExplora para traer parametro personaId
//	public String nuevo() {
//		return "/ppsj/egreso/persCobr/registra?faces-redirect=true&personaId=" + this.getPersonaId();
//	}

//	public String modificar() {
//		return "/ppsj/egreso/persCobr/registra?faces-redirect=true&persCobrId=" + this.getId();
//	}

	public String explorar() {
		return "explora?faces-redirect=true&persCobrId=" + this.getId();
	}

	public String eliminar() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		try {
			PersCobr persCobr = persCobrRegis.buscarPorId(this.getId());
			persCobrRegis.eliminar(persCobr);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al eliminar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null, "Registro eliminado"));

		if (this.getPersonaId() != null){
			return paginaRuta + "?faces-redirect=true&personaId=" + this.getPersonaId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}
	
	public String cancelar(){
		
		if (this.getPersonaId() != null){
			return paginaRuta + "?faces-redirect=true&personaId=" + this.getPersonaId();			
		} else {
			return paginaRuta + "?faces-redirect=true";			
		}

	}
	
	public List<PersCobr> buscarTodo() {

		List<PersCobr> persCobrs = new ArrayList<>();

		try {
			persCobrs = persCobrLista.buscarTodo("persCobrId");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar todo"));
			e.printStackTrace();
		}
		return persCobrs;
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


	public PersCobr getPersCobr() {
		return persCobr;
	}

	public void setPersCobr(PersCobr persCobr) {
		this.persCobr = persCobr;
	}

	public List<PersCobr> getPersCobrs() {
		return persCobrs;
	}

	public void setPersCobrs(List<PersCobr> persCobrs) {
		this.persCobrs = persCobrs;
	}

	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
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

}