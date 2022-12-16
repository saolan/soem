package ec.com.tecnointel.soem.reportCaja.controlador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class CajaMoviReportControl extends CajaModuloControl implements Serializable {

	private static final long serialVersionUID = -7228251438932512927L;
	
	@Override
	public void descargar() {

//		Nombre del reporte en JasperReport
		String nombreReporte = "cajaMovis";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();

			parametrosJasper.put("cajaMoviFechaDesd", this.cajaMoviDesde.getFecha());
			parametrosJasper.put("cajaMoviFechaHast", this.cajaMoviHasta.getFecha());

			parametrosJasper.put("docuCajaIds", this.docuCajaIds);
			parametrosJasper.put("cajaIds", this.cajaIds);
			parametrosJasper.put("persCajeIds", this.persCajeIds);
			parametrosJasper.put("formPagoIds", this.formPagoIds);
			
			parametrosJasper.put("cajaEstado", this.cajaEstado);
						
			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper,
					rutaJrxml, rutaReporteCompilado, formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, null,"Excepcion - Error al descargar reporte productos"));
			e.printStackTrace();
		}
	}

}
