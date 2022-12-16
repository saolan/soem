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
public class AnexoAnulsReportControl extends IngresoModuloControl implements Serializable {

	private static final long serialVersionUID = 943304491065273360L;

	@Override
	public void descargar() {

		String nombreReporte = "anexoAnuls";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();

			parametrosJasper.put("ingresoFechaDesd", this.getIngresoDesd().getFechaEmis());
			parametrosJasper.put("ingresoFechaHast", this.getIngresoHast().getFechaEmis());

			// parametrosJasper.put("sucursalIds", this.sucursalIds);
			// parametrosJasper.put("docuIngrIds", this.docuIngrIds);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper, rutaJrxml, rutaReporteCompilado,
					formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Error al descargar reporte de compras"));
			e.printStackTrace();
		}
	}
}
