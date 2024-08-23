package ec.com.tecnointel.soem.reportCont.controlador;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PlanCuentasReportControl extends ContabilidadModuloControl implements Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public void descargar() {

		String nombreReporte = "planCuentas";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();
			
			parametrosJasper.put("rutaJrxml", rutaJrxml);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper,
					rutaJrxml, rutaReporteCompilado, formatoReporte);

		} catch (Exception e) {
			FacesContext
					.getCurrentInstance()
					.addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
									"Excepcion - Error al descargar plan de cuentas"));
			e.printStackTrace();
		}
	}
}