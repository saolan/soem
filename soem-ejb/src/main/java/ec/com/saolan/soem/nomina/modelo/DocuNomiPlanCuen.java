package ec.com.saolan.soem.nomina.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuen;

/**
 * DocuNomiPlanCuen generated by hbm2java
 */
@Entity
@Table(name = "docu_nomi_plan_cuen")
public class DocuNomiPlanCuen implements java.io.Serializable {

	private Integer dnpcId;
	private DocuNomi docuNomi;
	private PlanCuen planCuen;
	private String tipoTran;

	private static final long serialVersionUID = -8786559368854211439L;

	public DocuNomiPlanCuen() {
	}

	public DocuNomiPlanCuen(Integer dnpcId, DocuNomi docuNomi,
			PlanCuen planCuen, String tipoTran) {
		this.dnpcId = dnpcId;
		this.docuNomi = docuNomi;
		this.planCuen = planCuen;
		this.tipoTran = tipoTran;
	}

	@Id
	@TableGenerator(name = "idDocuNomiPlanCuen", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "docu_nomi_plan_cuen", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idDocuNomiPlanCuen")
	@Column(name = "dnpc_id", unique = true, nullable = false)
	public Integer getDnpcId() {
		return this.dnpcId;
	}

	public void setDnpcId(Integer dnpcId) {
		this.dnpcId = dnpcId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_id", nullable = false)
	public DocuNomi getDocuNomi() {
		return this.docuNomi;
	}

	public void setDocuNomi(DocuNomi docuNomi) {
		this.docuNomi = docuNomi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "plan_cuen_id", nullable = false)
	public PlanCuen getPlanCuen() {
		return this.planCuen;
	}

	public void setPlanCuen(PlanCuen planCuen) {
		this.planCuen = planCuen;
	}

	@Column(name = "tipo_tran", nullable = false, length = 32)
	public String getTipoTran() {
		return this.tipoTran;
	}

	public void setTipoTran(String tipoTran) {
		this.tipoTran = tipoTran;
	}

}
