package ec.com.tecnointel.soem.reportEgre.controlador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VentaSesionReportControl extends EgresoModuloControl implements Serializable {


	String nombreReporte = "ventasSesion";
	
	@Override
	public void descargar() {

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();
			
			parametrosJasper.put("cajaMoviFechaDesd", this.getCajaMoviDesd().getFecha());
			parametrosJasper.put("cajaMoviFechaHast", this.getCajaMoviHast().getFecha());

			parametrosJasper.put("cajaIds", this.cajaIds);
			parametrosJasper.put("docuEgreIds", this.docuEgreIds);
			
			parametrosJasper.put("persClieEstado", this.persClieEstado);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper,
					rutaJrxml, rutaReporteCompilado, formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null,"Excepcion - Error al descargar reporte de ventas"));
			e.printStackTrace();
		}
	}
}
