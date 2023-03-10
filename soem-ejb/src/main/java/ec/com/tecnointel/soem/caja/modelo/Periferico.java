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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * Periferico generated by hbm2java
 */
@Entity
@Table(name = "periferico")
public class Periferico implements java.io.Serializable {

	private Integer perifericoId;
	private String descri;
	private String puerto;
	private String ascii;
	private Long veloci;
	private Short datos;
	private String parida;
	private Short parada;
	private String flujo;
	private Short digitoPeso;
	private Short digitoCodi;
	private Long factorDivi;
	private Set<CajaPeri> cajaPeris = new HashSet<CajaPeri>(0);

	private static final long serialVersionUID = 3675977258792643584L;

	public Periferico() {
	}

	public Periferico(Integer perifericoId, String descri) {
		this.perifericoId = perifericoId;
		this.descri = descri;
	}

	public Periferico(Integer perifericoId, String descri, String puerto, String ascii, Long veloci, Short datos,
			String parida, Short parada, String flujo, Short digitoPeso, Short digitoCodi, Long factorDivi,
			Set<CajaPeri> cajaPeris) {
		this.perifericoId = perifericoId;
		this.descri = descri;
		this.puerto = puerto;
		this.ascii = ascii;
		this.veloci = veloci;
		this.datos = datos;
		this.parida = parida;
		this.parada = parada;
		this.flujo = flujo;
		this.digitoPeso = digitoPeso;
		this.digitoCodi = digitoCodi;
		this.factorDivi = factorDivi;
		this.cajaPeris = cajaPeris;
	}

	@Id
	@TableGenerator(name = "idPeriferico", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "periferico", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idPeriferico")
	@Column(name = "PERIFERICO_ID", unique = true, nullable = false)
	public Integer getPerifericoId() {
		return this.perifericoId;
	}

	public void setPerifericoId(Integer perifericoId) {
		this.perifericoId = perifericoId;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "PUERTO", length = 6)
	public String getPuerto() {
		return this.puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	@Column(name = "ASCII", length = 32)
	public String getAscii() {
		return this.ascii;
	}

	public void setAscii(String ascii) {
		this.ascii = ascii;
	}

	@Column(name = "VELOCI", precision = 10, scale = 0)
	public Long getVeloci() {
		return this.veloci;
	}

	public void setVeloci(Long veloci) {
		this.veloci = veloci;
	}

	@Column(name = "DATOS")
	public Short getDatos() {
		return this.datos;
	}

	public void setDatos(Short datos) {
		this.datos = datos;
	}

	@Column(name = "PARIDA", length = 10)
	public String getParida() {
		return this.parida;
	}

	public void setParida(String parida) {
		this.parida = parida;
	}

	@Column(name = "PARADA")
	public Short getParada() {
		return this.parada;
	}

	public void setParada(Short parada) {
		this.parada = parada;
	}

	@Column(name = "FLUJO", length = 10)
	public String getFlujo() {
		return this.flujo;
	}

	public void setFlujo(String flujo) {
		this.flujo = flujo;
	}

	@Column(name = "DIGITO_PESO")
	public Short getDigitoPeso() {
		return this.digitoPeso;
	}

	public void setDigitoPeso(Short digitoPeso) {
		this.digitoPeso = digitoPeso;
	}

	@Column(name = "DIGITO_CODI")
	public Short getDigitoCodi() {
		return this.digitoCodi;
	}

	public void setDigitoCodi(Short digitoCodi) {
		this.digitoCodi = digitoCodi;
	}

	@Column(name = "FACTOR_DIVI", precision = 10, scale = 0)
	public Long getFactorDivi() {
		return this.factorDivi;
	}

	public void setFactorDivi(Long factorDivi) {
		this.factorDivi = factorDivi;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "periferico")
	public Set<CajaPeri> getCajaPeris() {
		return this.cajaPeris;
	}

	public void setCajaPeris(Set<CajaPeri> cajaPeris) {
		this.cajaPeris = cajaPeris;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((perifericoId == null) ? 0 : perifericoId.hashCode());
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
		Periferico other = (Periferico) obj;
		if (perifericoId == null) {
			if (other.perifericoId != null)
				return false;
		} else if (!perifericoId.equals(other.perifericoId))
			return false;
		return true;
	}

}
