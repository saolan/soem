package ec.com.tecnointel.soem.reportIngr.controlador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class IngresoReportControl extends IngresoModuloControl implements Serializable {

	private static final long serialVersionUID = -3727377946324322437L;

	@Override
	public void descargar() {

		String nombreReporte = "compras";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();

			parametrosJasper.put("persProvApelliDesd", this.getPersProvDesd().getPersona().getApelli());
			parametrosJasper.put("persProvApelliHast", this.getPersProvHast().getPersona().getApelli());

			parametrosJasper.put("persProvCedulaDesd", this.getPersProvDesd().getPersona().getCedulaRuc());
			parametrosJasper.put("persProvCedulaHast", this.getPersProvHast().getPersona().getCedulaRuc());

			parametrosJasper.put("ingresoFechaDesd", this.getIngresoDesd().getFechaEmis());
			parametrosJasper.put("ingresoFechaHast", this.getIngresoHast().getFechaEmis());

			parametrosJasper.put("sucursalIds", this.sucursalIds);
			parametrosJasper.put("docuIngrIds", this.docuIngrIds);

			parametrosJasper.put("persProvEstado", this.persProvEstado);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper, rutaJrxml, rutaReporteCompilado,
					formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Error al descargar reporte de compras"));
			e.printStackTrace();
		}
	}
}
