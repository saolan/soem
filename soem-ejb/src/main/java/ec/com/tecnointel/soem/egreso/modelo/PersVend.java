package ec.com.tecnointel.soem.egreso.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ec.com.tecnointel.soem.parametro.modelo.Persona;

/**
 * PersVend generated by hbm2java
 */
@Entity
@Table(name = "pers_vend")
public class PersVend implements java.io.Serializable {

	private Integer personaId;
	private Persona persona;
	private boolean estado;
	private Set<Egreso> egresos = new HashSet<Egreso>(0);

	private static final long serialVersionUID = -2308733790406253098L;

	public PersVend() {
	}

	public PersVend(Persona persona, boolean estado) {
		this.persona = persona;
		this.estado = estado;
	}

	public PersVend(Persona persona, boolean estado, Set<Egreso> egresos) {
		this.persona = persona;
		this.estado = estado;
		this.egresos = egresos;
	}

	@Id
	@GenericGenerator(name = "idPersVend", strategy = "foreign", parameters = @Parameter(name = "property", value = "persona"))
	@GeneratedValue(generator = "idPersVend")
	// @TableGenerator(name = "idPersVend", table = "Secuencial", pkColumnName =
	// "secuencial_id", pkColumnValue = "43", valueColumnName = "numero",
	// allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.TABLE, generator =
	// "idPersVend")
	@Column(name = "PERSONA_ID", unique = true, nullable = false)
	public Integer getPersonaId() {
		return this.personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persVend")
	public Set<Egreso> getEgresos() {
		return this.egresos;
	}

	public void setEgresos(Set<Egreso> egresos) {
		this.egresos = egresos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((personaId == null) ? 0 : personaId.hashCode());
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
		PersVend other = (PersVend) obj;
		if (personaId == null) {
			if (other.personaId != null)
				return false;
		} else if (!personaId.equals(other.personaId))
			return false;
		return true;
	}

}