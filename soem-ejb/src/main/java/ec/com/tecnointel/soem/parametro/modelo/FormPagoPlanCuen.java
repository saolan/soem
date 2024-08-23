package ec.com.tecnointel.soem.parametro.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuen;

/**
 * FormPagoPlanCuen generated by hbm2java
 */
@Entity
@Table(name = "form_pago_plan_cuen")
@NamedEntityGraph(name = "fppc.Graph", attributeNodes = { @NamedAttributeNode(value = "planCuen"),
		@NamedAttributeNode(value = "formPago") })
public class FormPagoPlanCuen implements java.io.Serializable {

	private Integer fppcId;
	private FormPago formPago;
	private PlanCuen planCuen;
	private String tipoTran;

	private static final long serialVersionUID = -6700545633667655748L;

	public FormPagoPlanCuen() {
	}

	public FormPagoPlanCuen(Integer fppcId, FormPago formPago, PlanCuen planCuen, String tipoTran) {
		this.fppcId = fppcId;
		this.formPago = formPago;
		this.planCuen = planCuen;
		this.tipoTran = tipoTran;
	}

	@Id
	@TableGenerator(name = "idFormPagoPlanCuen", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "form_pago_plan_cuen", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idFormPagoPlanCuen")
	@Column(name = "FPPC_ID", unique = true, nullable = false)
	public Integer getFppcId() {
		return this.fppcId;
	}

	public void setFppcId(Integer fppcId) {
		this.fppcId = fppcId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_CUEN_ID", nullable = false)
	public PlanCuen getPlanCuen() {
		return this.planCuen;
	}

	public void setPlanCuen(PlanCuen planCuen) {
		this.planCuen = planCuen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FORM_PAGO_ID", nullable = false)
	public FormPago getFormPago() {
		return formPago;
	}

	public void setFormPago(FormPago formPago) {
		this.formPago = formPago;
	}

	@Column(name = "TIPO_TRAN", nullable = true)
	public String getTipoTran() {
		return tipoTran;
	}

	public void setTipoTran(String tipoTran) {
		this.tipoTran = tipoTran;
	}
}
