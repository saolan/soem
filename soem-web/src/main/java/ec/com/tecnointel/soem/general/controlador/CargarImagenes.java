package ec.com.tecnointel.soem.general.controlador;

import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import ec.com.tecnointel.soem.parametro.modelo.Parametro;
import ec.com.tecnointel.soem.parametro.registroInt.ParametroRegisInt;

@Named
@ApplicationScoped
public class CargarImagenes {

	@Inject
	ParametroRegisInt parametroRegis;
	
	public Parametro buscarRutaImagenInventario(){
		
		Parametro parametro = null;
		
		try {
			parametro = parametroRegis.buscarPorId(5020);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "Excepcion 5020 - Error al buscar ruta imagenes inventario"));
			e.printStackTrace();
		}
		
		return parametro;
		
	}
	
	public StreamedContent getImagen() throws IOException {

		Parametro parametro = new Parametro(); 
		String rutaImagen;
		
	    FacesContext context = FacesContext.getCurrentInstance();

	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        return new DefaultStreamedContent();
	    } else {
	        
	        parametro = this.buscarRutaImagenInventario();
	        rutaImagen = parametro.getDescri();
	        	        
	        String archivo = context.getExternalContext().getRequestParameterMap().get("productoId") + ".png";
	        	        
	        return new DefaultStreamedContent(new FileInputStream(rutaImagen + archivo), "image/png");
	        
//	        Tambien funciona con esta linea
//	        return new DefaultStreamedContent(new FileInputStream(new File("rutaImagen", archivo)));	        
	        
	    }
	}

}
