package ec.com.tecnointel.soem.contabilidad.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import ec.com.tecnointel.soem.parametro.modelo.DocuTran;

/**
 * PlanCuen generated by hbm2java
 */
public class TranPlantilla implements Serializable {

	int orden;
	String notaCabe;
	String notaDeta;
	LocalDate fechaEmis;
	LocalDate fechaRegi;
	LocalDateTime fechaHoraEmis;
	LocalDateTime fechaHoraRegi;	
	BigDecimal total;

	DocuTran docuTran;
	PlanCuen planCuen;

	private static final long serialVersionUID = 8398854875849573230L;

	public TranPlantilla() {
	}

	public TranPlantilla(int orden, String notaCabe, String notaDeta, LocalDate fechaEmis, LocalDate fechaRegi, 
			LocalDateTime fechaHoraEmis, LocalDateTime fechaHoraRegi, BigDecimal total,
			DocuTran docuTran, PlanCuen planCuen) {

		this.orden = orden;
		this.notaCabe = notaCabe;
		this.notaDeta = notaDeta;
		this.fechaEmis = fechaEmis;
		this.fechaRegi = fechaRegi;
		this.fechaHoraEmis = fechaHoraEmis;
		this.fechaHoraRegi = fechaHoraRegi;
		this.total = total;
		this.docuTran = docuTran;
		this.planCuen = planCuen;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public String getNotaCabe() {
		return notaCabe;
	}

	public void setNotaCabe(String notaCabe) {
		this.notaCabe = notaCabe;
	}

	public String getNotaDeta() {
		return notaDeta;
	}

	public void setNotaDeta(String notaDeta) {
		this.notaDeta = notaDeta;
	}

	public LocalDate getFechaEmis() {
		return fechaEmis;
	}

	public void setFechaEmis(LocalDate fechaEmis) {
		this.fechaEmis = fechaEmis;
	}

	public LocalDate getFechaRegi() {
		return fechaRegi;
	}

	public void setFechaRegi(LocalDate fechaRegi) {
		this.fechaRegi = fechaRegi;
	}

	public LocalDateTime getFechaHoraEmis() {
		return fechaHoraEmis;
	}

	public void setFechaHoraEmis(LocalDateTime fechaHoraEmis) {
		this.fechaHoraEmis = fechaHoraEmis;
	}

	public LocalDateTime getFechaHoraRegi() {
		return fechaHoraRegi;
	}

	public void setFechaHoraRegi(LocalDateTime fechaHoraRegi) {
		this.fechaHoraRegi = fechaHoraRegi;
	}

	public DocuTran getDocuTran() {
		return docuTran;
	}

	public void setDocuTran(DocuTran docuTran) {
		this.docuTran = docuTran;
	}

	public PlanCuen getPlanCuen() {
		return planCuen;
	}

	public void setPlanCuen(PlanCuen planCuen) {
		this.planCuen = planCuen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planCuen == null) ? 0 : planCuen.hashCode());
		return result;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TranPlantilla other = (TranPlantilla) obj;
		if (planCuen == null) {
			if (other.planCuen != null)
				return false;
		} else if (!planCuen.equals(other.planCuen))
			return false;
		return true;
	}
}
