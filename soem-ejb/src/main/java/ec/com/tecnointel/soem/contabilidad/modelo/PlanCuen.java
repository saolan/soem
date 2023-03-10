package ec.com.tecnointel.soem.contabilidad.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrupPlanCuen;
import ec.com.tecnointel.soem.ingreso.modelo.ProvGrupPlanCuen;
import ec.com.tecnointel.soem.inventario.modelo.ProdTipoPlanCuen;
import ec.com.tecnointel.soem.parametro.modelo.DimmPlanCuen;
import ec.com.tecnointel.soem.parametro.modelo.FormPagoPlanCuen;

/**
 * PlanCuen generated by hbm2java
 */
@Entity
@Table(name = "plan_cuen")
@NamedEntityGraph(name = "planCuen.Graph", attributeNodes = { 
@NamedAttributeNode(value = "planCuenNive"),
@NamedAttributeNode(value = "planCuen")}
)
public class PlanCuen implements java.io.Serializable {

	private Integer planCuenId;
	private PlanCuen planCuen;
	private PlanCuenNive planCuenNive;
	private String codigo;
	private String descri;
	private Boolean detall;
	private boolean estado;
	private Set<ProvGrupPlanCuen> provGrupPlanCuens = new HashSet<ProvGrupPlanCuen>(0);
	private Set<TranDeta> tranDetas = new HashSet<TranDeta>(0);
	private Set<ClieGrupPlanCuen> clieGrupPlanCuens = new HashSet<ClieGrupPlanCuen>(0);
	private Set<ProdTipoPlanCuen> prodTipoPlanCuens = new HashSet<ProdTipoPlanCuen>(0);
	private Set<PlanCuen> planCuens = new HashSet<PlanCuen>(0);
	
	private Set<DimmPlanCuen> dimmPlanCuens = new HashSet<DimmPlanCuen>(0);
	private Set<FormPagoPlanCuen> formPagoPlanCuens = new HashSet<FormPagoPlanCuen>(0);

	private static final long serialVersionUID = -1504634328374005054L;

	public PlanCuen() {
	}

	public PlanCuen(Integer planCuenId, PlanCuenNive planCuenNive, String codigo, String descri, Boolean detall,
			boolean estado) {
		this.planCuenId = planCuenId;
		this.planCuenNive = planCuenNive;
		this.codigo = codigo;
		this.descri = descri;
		this.detall = detall;
		this.estado = estado;
	}

	public PlanCuen(Integer planCuenId, PlanCuen planCuen, PlanCuenNive planCuenNive, String codigo, String descri,
			Boolean detall, boolean estado, Set<ProvGrupPlanCuen> provGrupPlanCuens, Set<TranDeta> tranDetas, 
			Set<ClieGrupPlanCuen> clieGrupPlanCuens, Set<ProdTipoPlanCuen> prodTipoPlanCuens, Set<DimmPlanCuen> dimmPlanCuens, 
			Set<FormPagoPlanCuen> formPagoPlanCuens, Set<PlanCuen> planCuens) {
		this.planCuenId = planCuenId;
		this.planCuen = planCuen;
		this.planCuenNive = planCuenNive;
		this.codigo = codigo;
		this.descri = descri;
		this.detall = detall;
		this.estado = estado;
		this.provGrupPlanCuens = provGrupPlanCuens;
		this.tranDetas = tranDetas;
		this.clieGrupPlanCuens = clieGrupPlanCuens;
		this.prodTipoPlanCuens = prodTipoPlanCuens;
		this.planCuens = planCuens;
		this.dimmPlanCuens = dimmPlanCuens;
		this.formPagoPlanCuens = formPagoPlanCuens;
	}

	@Id
	@TableGenerator(name = "idPlanCuen", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "plan_cuen", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idPlanCuen")
	@Column(name = "PLAN_CUEN_ID", unique = true, nullable = false)
	public Integer getPlanCuenId() {
		return this.planCuenId;
	}

	public void setPlanCuenId(Integer planCuenId) {
		this.planCuenId = planCuenId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_CUEN_SUPE_ID")
	public PlanCuen getPlanCuen() {
		return this.planCuen;
	}

	public void setPlanCuen(PlanCuen planCuen) {
		this.planCuen = planCuen;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PLAN_CUEN_NIVE_ID", nullable = false)
	public PlanCuenNive getPlanCuenNive() {
		return this.planCuenNive;
	}

	public void setPlanCuenNive(PlanCuenNive planCuenNive) {
		this.planCuenNive = planCuenNive;
	}

	@Column(name = "CODIGO", nullable = false, length = 32)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "DETALL", nullable = false)
	public Boolean getDetall() {
		return detall;
	}

	public void setDetall(Boolean detall) {
		this.detall = detall;
	}

	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<ProvGrupPlanCuen> getProvGrupPlanCuens() {
		return this.provGrupPlanCuens;
	}

	public void setProvGrupPlanCuens(Set<ProvGrupPlanCuen> provGrupPlanCuens) {
		this.provGrupPlanCuens = provGrupPlanCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<TranDeta> getTranDetas() {
		return this.tranDetas;
	}

	public void setTranDetas(Set<TranDeta> tranDetas) {
		this.tranDetas = tranDetas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<ClieGrupPlanCuen> getClieGrupPlanCuens() {
		return this.clieGrupPlanCuens;
	}

	public void setClieGrupPlanCuens(Set<ClieGrupPlanCuen> clieGrupPlanCuens) {
		this.clieGrupPlanCuens = clieGrupPlanCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<ProdTipoPlanCuen> getProdTipoPlanCuens() {
		return this.prodTipoPlanCuens;
	}

	public void setProdTipoPlanCuens(Set<ProdTipoPlanCuen> prodTipoPlanCuens) {
		this.prodTipoPlanCuens = prodTipoPlanCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<PlanCuen> getPlanCuens() {
		return this.planCuens;
	}

	public void setPlanCuens(Set<PlanCuen> planCuens) {
		this.planCuens = planCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<DimmPlanCuen> getDimmPlanCuens() {
		return dimmPlanCuens;
	}

	public void setDimmPlanCuens(Set<DimmPlanCuen> dimmPlanCuens) {
		this.dimmPlanCuens = dimmPlanCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuen")
	public Set<FormPagoPlanCuen> getFormPagoPlanCuens() {
		return formPagoPlanCuens;
	}

	public void setFormPagoPlanCuens(Set<FormPagoPlanCuen> formPagoPlanCuens) {
		this.formPagoPlanCuens = formPagoPlanCuens;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planCuenId == null) ? 0 : planCuenId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlanCuen other = (PlanCuen) obj;
		if (planCuenId == null) {
			if (other.planCuenId != null)
				return false;
		} else if (!planCuenId.equals(other.planCuenId))
			return false;
		return true;
	}
}
