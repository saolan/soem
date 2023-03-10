package ec.com.tecnointel.soem.caja.modelo;
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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

/**
 * Caja generated by hbm2java
 */
@Entity
@Table(name = "caja")
@NamedEntityGraph(name = "caja.Graph", attributeNodes = { 
@NamedAttributeNode(value = "sucursal") })
public class Caja implements java.io.Serializable {

	private Integer cajaId;
	private Sucursal sucursal;
	private String codigo;
	private String descri;
	private boolean estado;
	private Set<CajaDocuEgre> cajaDocuEgres = new HashSet<CajaDocuEgre>(0);
	private Set<CajaPeri> cajaPeris = new HashSet<CajaPeri>(0);
	private Set<CajaMovi> cajaMovis = new HashSet<CajaMovi>(0);

	private static final long serialVersionUID = 6518456339363668098L;

	public Caja() {
	}

	public Caja(Integer cajaId, Sucursal sucursal, String codigo, String descri, boolean estado) {
		this.cajaId = cajaId;
		this.sucursal = sucursal;
		this.codigo = codigo;
		this.descri = descri;
		this.estado = estado;
	}

	public Caja(Integer cajaId, Sucursal sucursal, String codigo, String descri, boolean estado,
			Set<CajaDocuEgre> cajaDocuEgres, Set<CajaPeri> cajaPeris, Set<CajaMovi> cajaMovis) {
		this.cajaId = cajaId;
		this.sucursal = sucursal;
		this.codigo = codigo;
		this.descri = descri;
		this.estado = estado;
		this.cajaDocuEgres = cajaDocuEgres;
		this.cajaPeris = cajaPeris;
		this.cajaMovis = cajaMovis;
	}

	@Id
	@TableGenerator(name = "idCaja", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "caja", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idCaja")
	@Column(name = "CAJA_ID", unique = true, nullable = false)
	public Integer getCajaId() {
		return this.cajaId;
	}

	public void setCajaId(Integer cajaId) {
		this.cajaId = cajaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
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

	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caja")
	public Set<CajaDocuEgre> getCajaDocuEgres() {
		return this.cajaDocuEgres;
	}

	public void setCajaDocuEgres(Set<CajaDocuEgre> cajaDocuEgres) {
		this.cajaDocuEgres = cajaDocuEgres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caja")
	public Set<CajaPeri> getCajaPeris() {
		return this.cajaPeris;
	}

	public void setCajaPeris(Set<CajaPeri> cajaPeris) {
		this.cajaPeris = cajaPeris;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "caja")
	public Set<CajaMovi> getCajaMovis() {
		return this.cajaMovis;
	}

	public void setCajaMovis(Set<CajaMovi> cajaMovis) {
		this.cajaMovis = cajaMovis;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cajaId == null) ? 0 : cajaId.hashCode());
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
		Caja other = (Caja) obj;
		if (cajaId == null) {
			if (other.cajaId != null)
				return false;
		} else if (!cajaId.equals(other.cajaId))
			return false;
		return true;
	}

	@PrePersist
	public void antesPersist () {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PrePersist en cajaRegis");
	}
	
	@PreUpdate
	public void antesUpdate () {
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< PreUpdate en cajaRegis");
	}
}
