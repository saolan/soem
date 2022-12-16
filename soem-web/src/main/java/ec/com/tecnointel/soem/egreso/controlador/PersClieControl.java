package ec.com.tecnointel.soem.egreso.controlador;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.tecnointel.soem.egreso.listaInt.ClieGrupListaInt;
import ec.com.tecnointel.soem.egreso.listaInt.PersClieListaInt;
import ec.com.tecnointel.soem.egreso.modelo.ClieGrup;
import ec.com.tecnointel.soem.egreso.modelo.PersClie;
import ec.com.tecnointel.soem.egreso.registroInt.PersClieRegisInt;
import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.parametro.listaInt.DimmListaInt;
import ec.com.tecnointel.soem.parametro.modelo.Dimm;
import ec.com.tecnointel.soem.parametro.modelo.Persona;
import ec.com.tecnointel.soem.parametro.registroInt.PersonaRegisInt;

@Named
@ViewScoped
public class PersClieControl extends PaginaControl implements Serializable {

	private Integer personaId;
	private String paginaRuta;
	
	private PersClie persClie;
	
	List<PersClie> persClies;
	List<ClieGrup> clieGrups;
	List<Dimm> dimms;
	List<Dimm> dimmTipoIdenClies;

	@Inject
	PersClieRegisInt persClieRegis;

	@Inject
	PersClieListaInt persClieLista;
	
	@Inject
	ClieGrupListaInt clieGrupLista;
	
	@Inject
	DimmListaInt dimmLista;
	
	@Inject
	PersonaRegisInt personaRegis;


	private static final long serialVersionUID = 9086272167030401072L;

	@PostConstruct
	public void cargar() {

		persClie = new PersClie();
		persClie.setPersona(new Persona());
		persClie.setEstado(true);
		
		this.rolPermiso = variablesSesion.getRolPermiso();

	}

	public void buscar() {

		try {
			
			persClieLista.filasPagina(variablesSesion.getFilasPagina());
			
			this.persClies = persClieLista.buscar(persClie, this.pagina, variablesSesion.getFilasPagina());
			this.numeroReg = persClies.size();
			this.contadorReg = persClieLista.contarRegistros(persClie);
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
		
		this.buscarDimm();
		this.buscarDimmTipoIdenClies();
		this.buscarClieGrups();

		if (this.id == null) {
			
			persClie.setExonerIva(false);
			persClie.setRetienRent(true);
			persClie.setRetienIva(true);
			persClie.setCorteCred((short) 0);
			persClie.setDescueMaxi(new BigDecimal(0));
			persClie.setCupo(new BigDecimal(0));
			persClie.setEstado(true);
			
			if (this.personaId != null) {
				
				Persona persona = new Persona();
				try {
					persona =  personaRegis.buscarPorId(this.getPersonaId());
					this.persClie.setPersona(persona);
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al persona"));
					e.printStackTrace();
				}
			}

		} else {

			try {
				this.persClie = persClieRegis.buscarPorId(this.getId());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar Id"));
				e.printStackTrace();
			}
		}
	}

	public String grabar() {

		String campoTexto;
		
		campoTexto = this.persClie.getPersona().getCedulaRuc().trim();
		this.persClie.getPersona().setCedulaRuc(campoTexto);

		campoTexto = this.persClie.getPersona().getApelli().trim();
		this.persClie.getPersona().setApelli(campoTexto);

		if (this.persClie.getPersona().getNombre() != null) {
			campoTexto = this.persClie.getPersona().getNombre().trim();
			this.persClie.getPersona().setNombre(campoTexto);
		}

		try {
			if (this.id == null) {
				this.persClie.getPersona().setEstado(true);
				Object id = persClieRegis.insertar(persClie);
				this.id = (Integer) id;
			} else {
				persClieRegis.modificar(persClie);
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
			return "/ppsj/egreso/persClie/registra?faces-redirect=true&personaId=" + this.getPersonaId() + "&paginaRuta=" + this.getPaginaRuta();			
		} else {
			return "/ppsj/egreso/persClie/registra?faces-redirect=true&paginaRuta=" + this.getPaginaRuta(); 
		}

	}

	public String modificar() {
		if (this.getPersonaId() != null){
			return "/ppsj/egreso/persClie/registra?faces-redirect=true&persClieId=" + this.getId() + "&personaId=" + this.getPersonaId() + "&paginaRuta=" + this.getPaginaRuta();	
		} else {
			return "/ppsj/egreso/persClie/registra?faces-redirect=true&persClieId=" + this.getId() + "&paginaRuta=" + this.getPaginaRuta();	
		}
	}

	public String explorar() {
		return "explora?faces-redirect=true&persClieId=" + this.getId();
	}

	public String eliminar() {

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

		try {
			PersClie persClie = persClieRegis.buscarPorId(this.getId());
			persClieRegis.eliminar(persClie);

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

	public List<PersClie> buscarTodo() {

		List<PersClie> persClies = new ArrayList<>();

		try {
			persClies = persClieLista.buscarTodo("PersClieId");
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion - Error al buscar todo"));
			e.printStackTrace();
		}
		return persClies;
	}

	public void buscarDimm() {
		Dimm dimmDesde = new Dimm();
		Dimm dimmHasta = new Dimm();
		
		dimmDesde.setTablaRefe("Tabla2c");
		dimmDesde.setEstado(true);
		try {
			dimms = dimmLista.buscar(dimmDesde, dimmHasta, null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al buscar tipo de identificación"));
			e.printStackTrace();
		}
	}
	
	public void buscarDimmTipoIdenClies() {
		Dimm dimmDesde = new Dimm();
		Dimm dimmHasta = new Dimm();
		
		dimmDesde.setTablaRefe("Tabla14");
		dimmDesde.setEstado(true);
		try {
			dimmTipoIdenClies = dimmLista.buscar(dimmDesde, dimmHasta, null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al buscar tipo identificación cliente"));
			e.printStackTrace();
		}
	}
	
	public void buscarClieGrups() {
		
		ClieGrup clieGrup = new ClieGrup();
		clieGrup.setEstado(true);
		
		try {
			clieGrups = clieGrupLista.buscar(clieGrup, null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Excepcion - Error al buscar grupo clientes"));
			e.printStackTrace();
		}
	}

	public void seleccionarDimm() {
		
//		Dimm dimmCedula = new Dimm();
//		Dimm dimmRuc = new Dimm();
		
		for (Dimm dimm : this.dimms) {
			
			if (dimm.getDimmId().equals(2030) && this.getPersClie().getPersona().getCedulaRuc().length() == 13) {
//				dimmRuc = dimm;
				this.getPersClie().setDimm(dimm);
			} else if (dimm.getDimmId().equals(2040) && this.getPersClie().getPersona().getCedulaRuc().length() == 10) {
//				dimmCedula = dimm;
				this.getPersClie().setDimm(dimm);
			}
		}
		
//		if (this.getPersClie().getPersona().getCedulaRuc().length() == 10) {
//			this.getPersClie().setDimm(dimmCedula);
//		} else if (this.getPersClie().getPersona().getCedulaRuc().length() == 13) {
//			this.getPersClie().setDimm(dimmRuc);
//		} 

	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	public PersClie getPersClie() {
		return persClie;
	}

	public void setPersClie(PersClie persClie) {
		this.persClie = persClie;
	}

	public List<PersClie> getPersClies() {
		return persClies;
	}

	public void setPersClies(List<PersClie> persClies) {
		this.persClies = persClies;
	}

	public List<Dimm> getDimms() {
		return dimms;
	}

	public void setDimms(List<Dimm> dimms) {
		this.dimms = dimms;
	}

	public List<ClieGrup> getClieGrups() {
		return clieGrups;
	}

	public void setClieGrups(List<ClieGrup> clieGrups) {
		this.clieGrups = clieGrups;
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

	public List<Dimm> getDimmTipoIdenClies() {
		return dimmTipoIdenClies;
	}

	public void setDimmTipoIdenClies(List<Dimm> dimmTipoIdenClies) {
		this.dimmTipoIdenClies = dimmTipoIdenClies;
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}