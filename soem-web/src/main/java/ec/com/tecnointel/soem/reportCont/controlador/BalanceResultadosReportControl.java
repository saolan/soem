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
public class BalanceResultadosReportControl extends ContabilidadModuloControl implements Serializable {

	private static final long serialVersionUID = -4826309421876575096L;

	@Override
	public void descargar() {

		String nombreReporte = "balanceResultados";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();
			
			parametrosJasper.put("rutaJrxml", rutaJrxml);

//			parametrosJasper.put("planCuenDesd", this.getPlanCuenDesd().getCodigo());
//			parametrosJasper.put("planCuenHast", this.getPlanCuenHast().getCodigo());

			parametrosJasper.put("fechaDesd", this.getTransaccionDesd().getFechaEmis());
			parametrosJasper.put("fechaHast", this.getTransaccionHast().getFechaEmis());
			
			parametrosJasper.put("planCuenNiveId", this.planCuenNiveId);

//			parametrosJasper.put("sucursalIds", this.sucursalIds);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper,
					rutaJrxml, rutaReporteCompilado, formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(
				null,new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Error al descargar balance de resultados"));
			e.printStackTrace();
		}
	}
}
