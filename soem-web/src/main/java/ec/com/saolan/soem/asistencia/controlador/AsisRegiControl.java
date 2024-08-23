package ec.com.saolan.soem.asistencia.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.saolan.soem.asistencia.listaInt.AsisRegiListaInt;
import ec.com.saolan.soem.asistencia.modelo.AsisRegi;
import ec.com.saolan.soem.asistencia.registroInt.AsisRegiRegisInt;
import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.parametro.modelo.Parametro;

@Named
@ViewScoped
public class AsisRegiControl extends PaginaControl implements Serializable {

	private AsisRegi asisRegi;

	private List<AsisRegi> asisRegis;
	private List<Parametro> parameEstados;

	@Inject
	AsisRegiRegisInt asisRegiRegis;

	@Inject
	AsisRegiListaInt asisRegiLista;

	private static final long serialVersionUID = 529894598975611592L;

	@PostConstruct
	public void cargar() {

		this.asisRegi = new AsisRegi();
		this.asisRegi.setEstado("Activo");
	}

	public List<Parametro> agregarEstado(List<Parametro> parameEstados) {

		Parametro parametro = new Parametro();
		parametro.setDescri("Todo");
		parametro.setEstado(true);

		parameEstados.add(parametro);

		return parameEstados;
	}

	public List<Parametro> buscarAgregarParameEstados() {

		List<Parametro> parameEstados = this.buscarParameEstados();

		Parametro parametro = new Parametro();
		parametro.setDescri("Todo");
		parametro.setEstado(true);

		parameEstados.add(parametro);

		return parameEstados;
	}

	public List<Parametro> buscarParameEstados() {

		Parametro parametro = new Parametro();
		parametro.setCodigo("Parametro-EstadoRegistro");
		parametro.setEstado(true);

		List<Parametro> parametros = new ArrayList<>();

		try {
			parametros = parametroLista.buscar(parametro, null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
							"Ex - Error al buscar Parametro-EstadoRegistro"));
			e.printStackTrace();
		}

		return parametros;
	}

	public String eliminar() {

		try {
			AsisRegi asisRegi = asisRegiRegis.buscarPorId(this.getId());
			asisRegiRegis.eliminar(asisRegi);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, null,
							"Ex - Error al eliminar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null,
						"Registro eliminado"));

		return "lista?faces-redirect=true";
	}

	public String explorar() {
		return "explora?faces-redirect=true&asisRegiId=" + this.getId();
	}

	public String grabar() {

		try {
			if (this.id == null) {
				Object id = asisRegiRegis.insertar(asisRegi);
				this.id = (Integer) id;
			} else {
				asisRegiRegis.modificar(asisRegi);
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
							"Ex - Error al grabar datos"));
			e.printStackTrace();
			return null;
		}

		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, null,
						"Registro grabado"));

		return "explora?faces-redirect=true&asisRegiId=" + this.getId();
	}

	public String modificar() {
		return "registra?faces-redirect=true&asisRegiId=" + this.getId();
	}

	public void preCargarLista() {

		this.parameEstados = this.buscarAgregarParameEstados();

		try {

			asisRegiLista.filasPagina(variablesSesion.getFilasPagina());

			this.asisRegis = asisRegiLista.buscar(this.asisRegi, this.pagina);
			this.numeroReg = asisRegis.size();
			this.contadorReg = asisRegiLista.contarRegistros(this.asisRegi);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
							"Ex - Error al buscar datos"));
			e.printStackTrace();
		}
	}

	public void preCargarRegExp() {

		FacesContext facesContext = FacesContext.getCurrentInstance();
		if (facesContext.isPostback() && facesContext.isValidationFailed()) {
			return;
		}

		this.parameEstados = this.buscarParameEstados();

		if (this.id == null) {
			this.asisRegi = new AsisRegi();
			this.asisRegi.setEstado("Activo");
		} else {

			try {
				this.asisRegi = asisRegiRegis.buscarPorId(this.getId());
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
								"Ex - Error al buscar Id"));
				e.printStackTrace();
			}
		}
	}

	// <<<<<<<<<<<<< GETTER & SETTER >>>>>>>>>>>>>
	// <<<<<<<<<<<<< GETTER & SETTER >>>>>>>>>>>>>
	// <<<<<<<<<<<<< GETTER & SETTER >>>>>>>>>>>>>

	public AsisRegi getAsisRegi() {
		return asisRegi;
	}

	public void setAsisRegi(AsisRegi asisRegi) {
		this.asisRegi = asisRegi;
	}

	public List<AsisRegi> getAsisRegis() {
		return asisRegis;
	}

	public void setAsisRegis(List<AsisRegi> asisRegis) {
		this.asisRegis = asisRegis;
	}

	public List<Parametro> getParameEstados() {
		return parameEstados;
	}

	public void setParameEstados(List<Parametro> parameEstados) {
		this.parameEstados = parameEstados;
	}
}