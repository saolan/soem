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

import ec.com.saolan.soem.asistencia.listaInt.AsisHoraListaInt;
import ec.com.saolan.soem.asistencia.modelo.AsisHora;
import ec.com.saolan.soem.asistencia.registroInt.AsisHoraRegisInt;
import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.parametro.modelo.Parametro;

@Named
@ViewScoped
public class AsisHoraControl extends PaginaControl implements Serializable {

	private AsisHora asisHora;

	private List<AsisHora> asisHoras;
	private List<Parametro> parameEstados;

	@Inject
	AsisHoraRegisInt asisHoraRegis;

	@Inject
	AsisHoraListaInt asisHoraLista;

	private static final long serialVersionUID = -3581110250320381117L;

	@PostConstruct
	public void cargar() {

		this.asisHora = new AsisHora();
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
			AsisHora asisHora = asisHoraRegis.buscarPorId(this.getId());
			asisHoraRegis.eliminar(asisHora);

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
		return "explora?faces-redirect=true&asisHoraId=" + this.getId();
	}

	public String grabar() {

		try {
			if (this.id == null) {
				Object id = asisHoraRegis.insertar(asisHora);
				this.id = (Integer) id;
			} else {
				asisHoraRegis.modificar(asisHora);
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

		return "explora?faces-redirect=true&asisHoraId=" + this.getId();
	}

	public String modificar() {
		return "registra?faces-redirect=true&asisHoraId=" + this.getId();
	}

	public void preCargarLista() {

//		this.parameEstados = this.buscarAgregarParameEstados();

		try {

			asisHoraLista.filasPagina(variablesSesion.getFilasPagina());

			this.asisHoras = asisHoraLista.buscar(this.asisHora, this.pagina);
			this.numeroReg = asisHoras.size();
			this.contadorReg = asisHoraLista.contarRegistros(this.asisHora);
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

//		this.parameEstados = this.buscarParameEstados();

		if (this.id == null) {
			this.asisHora = new AsisHora();
		} else {

			try {
				this.asisHora = asisHoraRegis.buscarPorId(this.getId());
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

	public AsisHora getAsisHora() {
		return asisHora;
	}

	public void setAsisHora(AsisHora asisHora) {
		this.asisHora = asisHora;
	}

	public List<AsisHora> getAsisHoras() {
		return asisHoras;
	}

	public void setAsisHoras(List<AsisHora> asisHoras) {
		this.asisHoras = asisHoras;
	}

	public List<Parametro> getParameEstados() {
		return parameEstados;
	}

	public void setParameEstados(List<Parametro> parameEstados) {
		this.parameEstados = parameEstados;
	}
}