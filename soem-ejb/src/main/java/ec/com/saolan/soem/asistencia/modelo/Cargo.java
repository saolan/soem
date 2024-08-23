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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.saolan.soem.nomina.modelo.AcciPersActu;
import ec.com.saolan.soem.nomina.modelo.AcciPersProp;

/**
 * Cargo generated by hbm2java
 */
@Entity
@Table(name = "cargo")
public class Cargo implements java.io.Serializable {

	private Integer cargoId;
	private String descri;
	private Integer numeroPues;
	private String estado;
	private Set<AcciPersActu> acciPersActus = new HashSet<AcciPersActu>(0);
	private Set<AcciPersProp> acciPersProps = new HashSet<AcciPersProp>(0);

	private static final long serialVersionUID = -6332246248039555045L;

	public Cargo() {
	}

	public Cargo(Integer cargoId, String descri, Integer numeroPues,
			String estado) {
		this.cargoId = cargoId;
		this.descri = descri;
		this.numeroPues = numeroPues;
		this.estado = estado;
	}

	public Cargo(Integer cargoId, String descri, Integer numeroPues,
			String estado, Set<AcciPersActu> acciPersActus,
			Set<AcciPersProp> acciPersProps) {
		this.cargoId = cargoId;
		this.descri = descri;
		this.numeroPues = numeroPues;
		this.estado = estado;
		this.acciPersActus = acciPersActus;
		this.acciPersProps = acciPersProps;
	}

	@Id
	@TableGenerator(name = "idCargo", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "cargo", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idCargo")
	@Column(name = "cargo_id", unique = true, nullable = false)
	public Integer getCargoId() {
		return this.cargoId;
	}

	public void setCargoId(Integer cargoId) {
		this.cargoId = cargoId;
	}

	@Column(name = "descri", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "numero_pues", nullable = false)
	public Integer getNumeroPues() {
		return this.numeroPues;
	}

	public void setNumeroPues(Integer numeroPues) {
		this.numeroPues = numeroPues;
	}

	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<AcciPersActu> getAcciPersActus() {
		return this.acciPersActus;
	}

	public void setAcciPersActus(Set<AcciPersActu> acciPersActus) {
		this.acciPersActus = acciPersActus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cargo")
	public Set<AcciPersProp> getAcciPersProps() {
		return this.acciPersProps;
	}

	public void setAcciPersProps(Set<AcciPersProp> acciPersProps) {
		this.acciPersProps = acciPersProps;
	}

}
