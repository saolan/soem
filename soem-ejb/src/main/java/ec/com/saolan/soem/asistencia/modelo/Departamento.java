package ec.com.saolan.soem.asistencia.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.saolan.soem.nomina.modelo.AcciPersActu;
import ec.com.saolan.soem.nomina.modelo.AcciPersProp;

/**
 * Departamento generated by hbm2java
 */
@Entity
@Table(name = "departamento")
public class Departamento implements java.io.Serializable {

	private Integer departamentoId;
	private DepaCont depaCont;
	private DepaNive depaNive;
	private Departamento departamento;
	private String descri;
	private boolean detall;
	private String estado;
	private Set<Departamento> departamentos = new HashSet<Departamento>(0);
	private Set<AcciPersProp> acciPersProps = new HashSet<AcciPersProp>(0);
	private Set<AcciPersActu> acciPersActus = new HashSet<AcciPersActu>(0);

	private static final long serialVersionUID = 3370742475244936856L;

	public Departamento() {
	}

	public Departamento(Integer departamentoId, DepaNive depaNive,
			String descri, boolean detall, String estado) {
		this.departamentoId = departamentoId;
		this.depaNive = depaNive;
		this.descri = descri;
		this.detall = detall;
		this.estado = estado;
	}

	public Departamento(Integer departamentoId, DepaCont depaCont,
			DepaNive depaNive, Departamento departamento, String descri,
			boolean detall, String estado, Set<Departamento> departamentos,
			Set<AcciPersProp> acciPersProps, Set<AcciPersActu> acciPersActus) {
		this.departamentoId = departamentoId;
		this.depaCont = depaCont;
		this.depaNive = depaNive;
		this.departamento = departamento;
		this.descri = descri;
		this.detall = detall;
		this.estado = estado;
		this.departamentos = departamentos;
		this.acciPersProps = acciPersProps;
		this.acciPersActus = acciPersActus;
	}

	@Id
	@TableGenerator(name = "idDepartamento", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "departamento", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idDepartamento")
	@Column(name = "departamento_id", unique = true, nullable = false)
	public Integer getDepartamentoId() {
		return this.departamentoId;
	}

	public void setDepartamentoId(Integer departamentoId) {
		this.departamentoId = departamentoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depa_cont_id")
	public DepaCont getDepaCont() {
		return this.depaCont;
	}

	public void setDepaCont(DepaCont depaCont) {
		this.depaCont = depaCont;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depa_nive_id", nullable = false)
	public DepaNive getDepaNive() {
		return this.depaNive;
	}

	public void setDepaNive(DepaNive depaNive) {
		this.depaNive = depaNive;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "depa_supe_id")
	public Departamento getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Column(name = "descri", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "detall", nullable = false)
	public boolean isDetall() {
		return this.detall;
	}

	public void setDetall(boolean detall) {
		this.detall = detall;
	}

	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	public Set<AcciPersProp> getAcciPersProps() {
		return this.acciPersProps;
	}

	public void setAcciPersProps(Set<AcciPersProp> acciPersProps) {
		this.acciPersProps = acciPersProps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	public Set<AcciPersActu> getAcciPersActus() {
		return this.acciPersActus;
	}

	public void setAcciPersActus(Set<AcciPersActu> acciPersActus) {
		this.acciPersActus = acciPersActus;
	}

}
