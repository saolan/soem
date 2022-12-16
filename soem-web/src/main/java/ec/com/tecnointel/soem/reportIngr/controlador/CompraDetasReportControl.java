package ec.com.tecnointel.soem.reportIngr.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import ec.com.tecnointel.soem.parametro.modelo.DocuIngr;

@Named
@ViewScoped
public class CompraDetasReportControl extends IngresoModuloControl implements Serializable {

	private List<DocuIngr> docuIngrAnexos;
	
	private static final long serialVersionUID = -545489945228761773L;

//	Se cambia el nombre del metodo porque sino no se ejecuta el postconstructor de la clase que se esta heredando
	@PostConstruct
	public void cargarCompraDetas() {
		
		this.docuIngrAnexos =  new ArrayList<>();
		
		for (DocuIngr docuIngr : this.docuIngrs) {
			if (docuIngr.isGeneraAnex()) {
				this.docuIngrAnexos.add(docuIngr);
			} 
		}
	}
	
	@Override
	public void descargar() {

		String nombreReporte = "compraDetas";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();

			parametrosJasper.put("ingresoFechaDesd", this.getIngresoDesd().getFechaEmis());
			parametrosJasper.put("ingresoFechaHast", this.getIngresoHast().getFechaEmis());

			parametrosJasper.put("sucursalIds", this.sucursalIds);
			parametrosJasper.put("docuIngrIds", this.docuIngrIds);

			parametrosJasper.put("persProvEstado", this.persProvEstado);
			
			parametrosJasper.put("rutaJrxml", this.rutaJrxml);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper, rutaJrxml, rutaReporteCompilado,
					formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Error al descargar reporte de compras"));
			e.printStackTrace();
		}
	}

	
	public void descargarFp() {

		String nombreReporte = "compraFormPagos";

		Map<String, Object> parametrosJasper = new HashMap<String, Object>();

		try {

			super.descargar();

			parametrosJasper.put("ingresoFechaDesd", this.getIngresoDesd().getFechaEmis());
			parametrosJasper.put("ingresoFechaHast", this.getIngresoHast().getFechaEmis());

			parametrosJasper.put("sucursalIds", this.sucursalIds);
			parametrosJasper.put("docuIngrIds", this.docuIngrIds);

			parametrosJasper.put("persProvEstado", this.persProvEstado);
			
			parametrosJasper.put("rutaJrxml", this.rutaJrxml);

			generaJasperReportes.crearArchivo(nombreReporte, parametrosJasper, rutaJrxml, rutaReporteCompilado,
					formatoReporte);

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
					"Excepcion - Error al descargar reporte de compras"));
			e.printStackTrace();
		}
	}

	public ArrayList<String> getDocuIngrIds() {
		return docuIngrIds;
	}

	public void setDocuIngrIds(ArrayList<String> docuIngrIds) {
		this.docuIngrIds = docuIngrIds;
	}

	public List<DocuIngr> getDocuIngrAnexos() {
		return docuIngrAnexos;
	}

	public void setDocuIngrAnexos(List<DocuIngr> docuIngrAnexos) {
		this.docuIngrAnexos = docuIngrAnexos;
	}
}
