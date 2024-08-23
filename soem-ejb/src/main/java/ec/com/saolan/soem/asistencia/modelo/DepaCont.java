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

/**
 * DepaCont generated by hbm2java
 */
@Entity
@Table(name = "depa_cont")
public class DepaCont implements java.io.Serializable {

	private Integer depaContId;
	private PersEmpl persEmpl;
	private boolean jefe;
	private String ausencAutoPrea;
	private String accionAutoPrea;
	private String extrasAutoPrea;
	private Integer nivel;
	private String estado;
	private Set<Departamento> departamentos = new HashSet<Departamento>(0);

	private static final long serialVersionUID = -8561474650773895156L;

	public DepaCont() {
	}

	public DepaCont(Integer depaContId, PersEmpl persEmpl, boolean jefe,
			String ausencAutoPrea, String accionAutoPrea,
			String extrasAutoPrea, Integer nivel, String estado) {
		this.depaContId = depaContId;
		this.persEmpl = persEmpl;
		this.jefe = jefe;
		this.ausencAutoPrea = ausencAutoPrea;
		this.accionAutoPrea = accionAutoPrea;
		this.extrasAutoPrea = extrasAutoPrea;
		this.nivel = nivel;
		this.estado = estado;
	}

	public DepaCont(Integer depaContId, PersEmpl persEmpl, boolean jefe,
			String ausencAutoPrea, String accionAutoPrea,
			String extrasAutoPrea, Integer nivel, String estado,
			Set<Departamento> departamentos) {
		this.depaContId = depaContId;
		this.persEmpl = persEmpl;
		this.jefe = jefe;
		this.ausencAutoPrea = ausencAutoPrea;
		this.accionAutoPrea = accionAutoPrea;
		this.extrasAutoPrea = extrasAutoPrea;
		this.nivel = nivel;
		this.estado = estado;
		this.departamentos = departamentos;
	}

	@Id
	@TableGenerator(name = "idDepaCont", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "depa_cont", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idDepaCont")
	@Column(name = "depa_cont_id", unique = true, nullable = false)
	public Integer getDepaContId() {
		return this.depaContId;
	}

	public void setDepaContId(Integer depaContId) {
		this.depaContId = depaContId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	public PersEmpl getPersEmpl() {
		return this.persEmpl;
	}

	public void setPersEmpl(PersEmpl persEmpl) {
		this.persEmpl = persEmpl;
	}

	@Column(name = "jefe", nullable = false)
	public boolean isJefe() {
		return this.jefe;
	}

	public void setJefe(boolean jefe) {
		this.jefe = jefe;
	}

	@Column(name = "ausenc_auto_prea", nullable = false, length = 4)
	public String getAusencAutoPrea() {
		return this.ausencAutoPrea;
	}

	public void setAusencAutoPrea(String ausencAutoPrea) {
		this.ausencAutoPrea = ausencAutoPrea;
	}

	@Column(name = "accion_auto_prea", nullable = false, length = 4)
	public String getAccionAutoPrea() {
		return this.accionAutoPrea;
	}

	public void setAccionAutoPrea(String accionAutoPrea) {
		this.accionAutoPrea = accionAutoPrea;
	}

	@Column(name = "extras_auto_prea", nullable = false, length = 4)
	public String getExtrasAutoPrea() {
		return this.extrasAutoPrea;
	}

	public void setExtrasAutoPrea(String extrasAutoPrea) {
		this.extrasAutoPrea = extrasAutoPrea;
	}

	@Column(name = "nivel", nullable = false)
	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "depaCont")
	public Set<Departamento> getDepartamentos() {
		return this.departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
}