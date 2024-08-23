package ec.com.tecnointel.soem.publicidad.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.tecnointel.soem.documeElec.tareas.ManejadorTareaEnviarCorreoDocu;
import ec.com.tecnointel.soem.general.controlador.PaginaControl;
import ec.com.tecnointel.soem.parametro.listaInt.PersonaListaInt;
import ec.com.tecnointel.soem.parametro.modelo.Persona;

@Named
@ViewScoped
public class PublicidadControl extends PaginaControl implements Serializable {

	private List<Persona> personas;

	@Inject
	PersonaListaInt personaLista;

	@Inject
	ManejadorTareaEnviarCorreoDocu manejadorTareaEnviarCorreoDocu;

	@PostConstruct
	public void cargar() {
		
		personas = new ArrayList<Persona>();
	}

	public void buscar() {

		Persona persona = new Persona();

		try {
			personas = personaLista.buscar(persona, null);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Error al buscar compra para retención"));
			e.printStackTrace();
		}
	}

	public void procesar() {

		for (Persona persona : personas) {
			if (persona.getCorreo() != null) {
				ejecutarTareaEnviarCorreoDocu(persona.getCorreo(), "N/D");	
			}
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, null,
				"Documentos con otros estados reprocesados y reenviados"));

	}
	
	public void ejecutarTareaEnviarCorreoDocu(String destinatario, String claveAcce) {

		try {

			manejadorTareaEnviarCorreoDocu.ejecutarTareaEnviarCorreoDocu(destinatario, claveAcce);

		} catch (ExecutionException | InterruptedException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Documento no enviado por correo al cliente " + destinatario));
			e.printStackTrace();
		}
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
}