package ec.com.saolan.soem.asistencia.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Ausencia generated by hbm2java
 */
@Entity
@Table(name = "ausencia")
public class Ausencia implements java.io.Serializable {

	private Integer ausenciaId;
	private DocuAuse docuAuse;
	private PersEmpl persEmpl;
	private Integer numero;
	private Date fechaRegi;
	private Date fechaDesd;
	private Date fechaHast;
	private Date horaDesd;
	private Date horaHast;
	private boolean recupe;
	private BigDecimal valor;
	private String nota;
	private Integer accionPersId;
	private String estado;
	private Set<AuseAuto> auseAutos = new HashSet<AuseAuto>(0);
	private Set<KardVaca> kardVacas = new HashSet<KardVaca>(0);
	private Set<AuseRecu> auseRecus = new HashSet<AuseRecu>(0);

	private static final long serialVersionUID = -6934944631751441601L;

	public Ausencia() {
	}

	public Ausencia(Integer ausenciaId, DocuAuse docuAuse, PersEmpl persEmpl,
			Integer numero, Date fechaRegi, Date fechaDesd, Date fechaHast,
			Date horaDesd, Date horaHast, boolean recupe, BigDecimal valor,
			String nota, String estado) {
		this.ausenciaId = ausenciaId;
		this.docuAuse = docuAuse;
		this.persEmpl = persEmpl;
		this.numero = numero;
		this.fechaRegi = fechaRegi;
		this.fechaDesd = fechaDesd;
		this.fechaHast = fechaHast;
		this.horaDesd = horaDesd;
		this.horaHast = horaHast;
		this.recupe = recupe;
		this.valor = valor;
		this.nota = nota;
		this.estado = estado;
	}

	public Ausencia(Integer ausenciaId, DocuAuse docuAuse, PersEmpl persEmpl,
			Integer numero, Date fechaRegi, Date fechaDesd, Date fechaHast,
			Date horaDesd, Date horaHast, boolean recupe, BigDecimal valor,
			String nota, Integer accionPersId, String estado,
			Set<AuseAuto> auseAutos, Set<KardVaca> kardVacas,
			Set<AuseRecu> auseRecus) {
		this.ausenciaId = ausenciaId;
		this.docuAuse = docuAuse;
		this.persEmpl = persEmpl;
		this.numero = numero;
		this.fechaRegi = fechaRegi;
		this.fechaDesd = fechaDesd;
		this.fechaHast = fechaHast;
		this.horaDesd = horaDesd;
		this.horaHast = horaHast;
		this.recupe = recupe;
		this.valor = valor;
		this.nota = nota;
		this.accionPersId = accionPersId;
		this.estado = estado;
		this.auseAutos = auseAutos;
		this.kardVacas = kardVacas;
		this.auseRecus = auseRecus;
	}

	@Id
	@TableGenerator(name = "idAusencia", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "ausencia", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idAusencia")
	@Column(name = "ausencia_id", unique = true, nullable = false)
	public Integer getAusenciaId() {
		return this.ausenciaId;
	}

	public void setAusenciaId(Integer ausenciaId) {
		this.ausenciaId = ausenciaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "documento_id", nullable = false)
	public DocuAuse getDocuAuse() {
		return this.docuAuse;
	}

	public void setDocuAuse(DocuAuse docuAuse) {
		this.docuAuse = docuAuse;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	public PersEmpl getPersEmpl() {
		return this.persEmpl;
	}

	public void setPersEmpl(PersEmpl persEmpl) {
		this.persEmpl = persEmpl;
	}

	@Column(name = "numero", nullable = false)
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_regi", nullable = false, length = 29)
	public Date getFechaRegi() {
		return this.fechaRegi;
	}

	public void setFechaRegi(Date fechaRegi) {
		this.fechaRegi = fechaRegi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_desd", nullable = false, length = 29)
	public Date getFechaDesd() {
		return this.fechaDesd;
	}

	public void setFechaDesd(Date fechaDesd) {
		this.fechaDesd = fechaDesd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hast", nullable = false, length = 29)
	public Date getFechaHast() {
		return this.fechaHast;
	}

	public void setFechaHast(Date fechaHast) {
		this.fechaHast = fechaHast;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_desd", nullable = false, length = 29)
	public Date getHoraDesd() {
		return this.horaDesd;
	}

	public void setHoraDesd(Date horaDesd) {
		this.horaDesd = horaDesd;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_hast", nullable = false, length = 29)
	public Date getHoraHast() {
		return this.horaHast;
	}

	public void setHoraHast(Date horaHast) {
		this.horaHast = horaHast;
	}

	@Column(name = "recupe", nullable = false)
	public boolean isRecupe() {
		return this.recupe;
	}

	public void setRecupe(boolean recupe) {
		this.recupe = recupe;
	}

	@Column(name = "valor", nullable = false, precision = 8, scale = 4)
	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "nota", nullable = false)
	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	@Column(name = "accion_pers_id")
	public Integer getAccionPersId() {
		return this.accionPersId;
	}

	public void setAccionPersId(Integer accionPersId) {
		this.accionPersId = accionPersId;
	}

	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ausencia")
	public Set<AuseAuto> getAuseAutos() {
		return this.auseAutos;
	}

	public void setAuseAutos(Set<AuseAuto> auseAutos) {
		this.auseAutos = auseAutos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ausencia")
	public Set<KardVaca> getKardVacas() {
		return this.kardVacas;
	}

	public void setKardVacas(Set<KardVaca> kardVacas) {
		this.kardVacas = kardVacas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ausencia")
	public Set<AuseRecu> getAuseRecus() {
		return this.auseRecus;
	}

	public void setAuseRecus(Set<AuseRecu> auseRecus) {
		this.auseRecus = auseRecus;
	}

}
