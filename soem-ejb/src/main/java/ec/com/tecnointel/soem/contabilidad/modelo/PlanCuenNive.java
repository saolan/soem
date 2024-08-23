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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * PlanCuenNive generated by hbm2java
 */
@Entity
@Table(name = "plan_cuen_nive")
public class PlanCuenNive implements java.io.Serializable {

	private Integer planCuenNiveId;
	private Integer nivel;
	private String descri;
	private Set<PlanCuen> planCuens = new HashSet<PlanCuen>(0);

	private static final long serialVersionUID = -490097360671721638L;

	public PlanCuenNive() {
	}

	public PlanCuenNive(Integer planCuenNiveId, Integer nivel, String descri) {
		this.planCuenNiveId = planCuenNiveId;
		this.nivel = nivel;
		this.descri = descri;
	}

	public PlanCuenNive(Integer planCuenNiveId, Integer nivel, String descri, Set<PlanCuen> planCuens) {
		this.planCuenNiveId = planCuenNiveId;
		this.nivel = nivel;
		this.descri = descri;
		this.planCuens = planCuens;
	}

	@Id
	@TableGenerator(name = "idPlanCuenNive", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "plan_cuen_nive", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idPlanCuenNive")
	@Column(name = "PLAN_CUEN_NIVE_ID", unique = true, nullable = false)
	public Integer getPlanCuenNiveId() {
		return this.planCuenNiveId;
	}

	public void setPlanCuenNiveId(Integer planCuenNiveId) {
		this.planCuenNiveId = planCuenNiveId;
	}

	@Column(name = "NIVEL", nullable = false)
	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "planCuenNive")
	public Set<PlanCuen> getPlanCuens() {
		return this.planCuens;
	}

	public void setPlanCuens(Set<PlanCuen> planCuens) {
		this.planCuens = planCuens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((planCuenNiveId == null) ? 0 : planCuenNiveId.hashCode());
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
		PlanCuenNive other = (PlanCuenNive) obj;
		if (planCuenNiveId == null) {
			if (other.planCuenNiveId != null)
				return false;
		} else if (!planCuenNiveId.equals(other.planCuenNiveId))
			return false;
		return true;
	}

}
