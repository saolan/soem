package ec.com.tecnointel.soem.parametro.modelo;

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

import ec.com.tecnointel.soem.egreso.modelo.Egreso;

@Entity
@Table(name = "mesa")
public class Mesa implements java.io.Serializable {

	private Integer mesaId;
	private String descri;
	private boolean estado;
	private Set<Egreso> egresos = new HashSet<Egreso>(0);

	private static final long serialVersionUID = -2734760109127970767L;

	public Mesa() {
	}

	public Mesa(Integer mesaId, String descri, boolean estado) {
		this.mesaId = mesaId;
		this.descri = descri;
		this.estado = estado;
	}

	public Mesa(Integer mesaId, String descri, boolean estado, Set<Egreso> egresos) {
		this.mesaId = mesaId;
		this.descri = descri;
		this.estado = estado;
		this.egresos = egresos;
	}

	@Id
	@TableGenerator(name = "idMesa", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "mesa", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idMesa")
	@Column(name = "MESA_ID", unique = true, nullable = false)
	public Integer getMesaId() {
		return mesaId;
	}

	public void setMesaId(Integer mesaId) {
		this.mesaId = mesaId;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mesa")
	public Set<Egreso> getEgresos() {
		return egresos;
	}

	public void setEgresos(Set<Egreso> egresos) {
		this.egresos = egresos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mesaId == null) ? 0 : mesaId.hashCode());
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
		Mesa other = (Mesa) obj;
		if (mesaId == null) {
			if (other.mesaId != null)
				return false;
		} else if (!mesaId.equals(other.mesaId))
			return false;
		return true;
	}
}
