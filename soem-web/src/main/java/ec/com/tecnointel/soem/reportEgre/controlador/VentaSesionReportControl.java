package ec.com.tecnointel.soem.reportEgre.controlador;

import java.io.Serializable;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class VentaSesionReportControl extends EgresoModuloControl implements Serializable {

	private static final long serialVersionUID = -5940012523537540731L;
	
	String nombreReporte = "ventasSesion";
	
	@Override
	public void descargar() {

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();
			
			parametrosJasper.put("cajaMoviFechaDesd", Date.from(this.getCajaMoviDesd().getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			parametrosJasper.put("cajaMoviFechaHast", Date.from(this.getCajaMoviHast().getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant()));

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
