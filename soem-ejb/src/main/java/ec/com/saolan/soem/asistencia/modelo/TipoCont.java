package ec.com.saolan.soem.asistencia.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

import java.math.BigDecimal;
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
 * TipoCont generated by hbm2java
 */
@Entity
@Table(name = "tipo_cont")
public class TipoCont implements java.io.Serializable {

	private Integer tipoContId;
	private String descri;
	private String tipo;
	private BigDecimal horasMes;
	private Integer tiempoCont;
	private BigDecimal vacaciFact;
	private BigDecimal vacaciDias;
	private BigDecimal vacaciDiasIncr;
	private BigDecimal vacaciDesdAnio;
	private BigDecimal vacaciMaxiDiasIncr;
	private BigDecimal vacaciMaxiPeriAcum;
	private Integer vacaciMeseCarg;
	private String estado;
	private Set<AcciPersActu> acciPersActus = new HashSet<AcciPersActu>(0);
	private Set<AcciPersProp> acciPersProps = new HashSet<AcciPersProp>(0);

	private static final long serialVersionUID = 5964120660497607096L;

	public TipoCont() {
	}

	public TipoCont(Integer tipoContId, String descri, String tipo,
			BigDecimal horasMes, Integer tiempoCont, BigDecimal vacaciFact,
			BigDecimal vacaciDias, BigDecimal vacaciDiasIncr,
			BigDecimal vacaciDesdAnio, BigDecimal vacaciMaxiDiasIncr,
			BigDecimal vacaciMaxiPeriAcum, Integer vacaciMeseCarg, String estado) {
		this.tipoContId = tipoContId;
		this.descri = descri;
		this.tipo = tipo;
		this.horasMes = horasMes;
		this.tiempoCont = tiempoCont;
		this.vacaciFact = vacaciFact;
		this.vacaciDias = vacaciDias;
		this.vacaciDiasIncr = vacaciDiasIncr;
		this.vacaciDesdAnio = vacaciDesdAnio;
		this.vacaciMaxiDiasIncr = vacaciMaxiDiasIncr;
		this.vacaciMaxiPeriAcum = vacaciMaxiPeriAcum;
		this.vacaciMeseCarg = vacaciMeseCarg;
		this.estado = estado;
	}

	public TipoCont(Integer tipoContId, String descri, String tipo,
			BigDecimal horasMes, Integer tiempoCont, BigDecimal vacaciFact,
			BigDecimal vacaciDias, BigDecimal vacaciDiasIncr,
			BigDecimal vacaciDesdAnio, BigDecimal vacaciMaxiDiasIncr,
			BigDecimal vacaciMaxiPeriAcum, Integer vacaciMeseCarg,
			String estado, Set<AcciPersActu> acciPersActus,
			Set<AcciPersProp> acciPersProps) {
		this.tipoContId = tipoContId;
		this.descri = descri;
		this.tipo = tipo;
		this.horasMes = horasMes;
		this.tiempoCont = tiempoCont;
		this.vacaciFact = vacaciFact;
		this.vacaciDias = vacaciDias;
		this.vacaciDiasIncr = vacaciDiasIncr;
		this.vacaciDesdAnio = vacaciDesdAnio;
		this.vacaciMaxiDiasIncr = vacaciMaxiDiasIncr;
		this.vacaciMaxiPeriAcum = vacaciMaxiPeriAcum;
		this.vacaciMeseCarg = vacaciMeseCarg;
		this.estado = estado;
		this.acciPersActus = acciPersActus;
		this.acciPersProps = acciPersProps;
	}

	@Id
	@TableGenerator(name = "idTipoCont", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "tipo_cont", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idTipoCont")
	@Column(name = "tipo_cont_id", unique = true, nullable = false)
	public Integer getTipoContId() {
		return this.tipoContId;
	}

	public void setTipoContId(Integer tipoContId) {
		this.tipoContId = tipoContId;
	}

	@Column(name = "descri", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "tipo", nullable = false, length = 32)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "horas_mes", nullable = false, precision = 8, scale = 4)
	public BigDecimal getHorasMes() {
		return this.horasMes;
	}

	public void setHorasMes(BigDecimal horasMes) {
		this.horasMes = horasMes;
	}

	@Column(name = "tiempo_cont", nullable = false)
	public Integer getTiempoCont() {
		return this.tiempoCont;
	}

	public void setTiempoCont(Integer tiempoCont) {
		this.tiempoCont = tiempoCont;
	}

	@Column(name = "vacaci_fact", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciFact() {
		return this.vacaciFact;
	}

	public void setVacaciFact(BigDecimal vacaciFact) {
		this.vacaciFact = vacaciFact;
	}

	@Column(name = "vacaci_dias", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciDias() {
		return this.vacaciDias;
	}

	public void setVacaciDias(BigDecimal vacaciDias) {
		this.vacaciDias = vacaciDias;
	}

	@Column(name = "vacaci_dias_incr", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciDiasIncr() {
		return this.vacaciDiasIncr;
	}

	public void setVacaciDiasIncr(BigDecimal vacaciDiasIncr) {
		this.vacaciDiasIncr = vacaciDiasIncr;
	}

	@Column(name = "vacaci_desd_anio", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciDesdAnio() {
		return this.vacaciDesdAnio;
	}

	public void setVacaciDesdAnio(BigDecimal vacaciDesdAnio) {
		this.vacaciDesdAnio = vacaciDesdAnio;
	}

	@Column(name = "vacaci_maxi_dias_incr", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciMaxiDiasIncr() {
		return this.vacaciMaxiDiasIncr;
	}

	public void setVacaciMaxiDiasIncr(BigDecimal vacaciMaxiDiasIncr) {
		this.vacaciMaxiDiasIncr = vacaciMaxiDiasIncr;
	}

	@Column(name = "vacaci_maxi_peri_acum", nullable = false, precision = 8, scale = 4)
	public BigDecimal getVacaciMaxiPeriAcum() {
		return this.vacaciMaxiPeriAcum;
	}

	public void setVacaciMaxiPeriAcum(BigDecimal vacaciMaxiPeriAcum) {
		this.vacaciMaxiPeriAcum = vacaciMaxiPeriAcum;
	}

	@Column(name = "vacaci_mese_carg", nullable = false)
	public Integer getVacaciMeseCarg() {
		return this.vacaciMeseCarg;
	}

	public void setVacaciMeseCarg(Integer vacaciMeseCarg) {
		this.vacaciMeseCarg = vacaciMeseCarg;
	}

	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCont")
	public Set<AcciPersActu> getAcciPersActus() {
		return this.acciPersActus;
	}

	public void setAcciPersActus(Set<AcciPersActu> acciPersActus) {
		this.acciPersActus = acciPersActus;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoCont")
	public Set<AcciPersProp> getAcciPersProps() {
		return this.acciPersProps;
	}

	public void setAcciPersProps(Set<AcciPersProp> acciPersProps) {
		this.acciPersProps = acciPersProps;
	}

}
