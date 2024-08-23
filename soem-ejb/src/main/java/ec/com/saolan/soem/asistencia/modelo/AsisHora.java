package ec.com.saolan.soem.asistencia.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * AsisHora generated by hbm2java
 */
@Entity
@Table(name = "asis_hora")
public class AsisHora implements java.io.Serializable {

	private Integer asisHoraId;
	private AsisRegi asisRegi;
	private PersEmpl persEmpl;
	private Date fechaHora;
	private Integer minutoTole;
	private String funcio;
	private String tipoDia;
	private Integer horarioId;
	private String nota;

	private static final long serialVersionUID = 1214382179922214158L;

	public AsisHora() {
	}

	public AsisHora(Integer asisHoraId, PersEmpl persEmpl, Date fechaHora,
			Integer minutoTole, String funcio, String tipoDia, Integer horarioId) {
		this.asisHoraId = asisHoraId;
		this.persEmpl = persEmpl;
		this.fechaHora = fechaHora;
		this.minutoTole = minutoTole;
		this.funcio = funcio;
		this.tipoDia = tipoDia;
		this.horarioId = horarioId;
	}

	public AsisHora(Integer asisHoraId, AsisRegi asisRegi, PersEmpl persEmpl,
			Date fechaHora, Integer minutoTole, String funcio, String tipoDia,
			Integer horarioId, String nota) {
		this.asisHoraId = asisHoraId;
		this.asisRegi = asisRegi;
		this.persEmpl = persEmpl;
		this.fechaHora = fechaHora;
		this.minutoTole = minutoTole;
		this.funcio = funcio;
		this.tipoDia = tipoDia;
		this.horarioId = horarioId;
		this.nota = nota;
	}

	@Id
	@TableGenerator(name = "idAsisHora", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "asis_hora", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idAsisHora")
	@Column(name = "asis_hora_id", unique = true, nullable = false)
	public Integer getAsisHoraId() {
		return this.asisHoraId;
	}

	public void setAsisHoraId(Integer asisHoraId) {
		this.asisHoraId = asisHoraId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "asis_regi_id")
	public AsisRegi getAsisRegi() {
		return this.asisRegi;
	}

	public void setAsisRegi(AsisRegi asisRegi) {
		this.asisRegi = asisRegi;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	public PersEmpl getPersEmpl() {
		return this.persEmpl;
	}

	public void setPersEmpl(PersEmpl persEmpl) {
		this.persEmpl = persEmpl;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora", nullable = false, length = 29)
	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Column(name = "minuto_tole", nullable = false)
	public Integer getMinutoTole() {
		return this.minutoTole;
	}

	public void setMinutoTole(Integer minutoTole) {
		this.minutoTole = minutoTole;
	}

	@Column(name = "funcio", nullable = false, length = 12)
	public String getFuncio() {
		return this.funcio;
	}

	public void setFuncio(String funcio) {
		this.funcio = funcio;
	}

	@Column(name = "tipo_dia", nullable = false, length = 12)
	public String getTipoDia() {
		return this.tipoDia;
	}

	public void setTipoDia(String tipoDia) {
		this.tipoDia = tipoDia;
	}

	@Column(name = "horario_id", nullable = false)
	public Integer getHorarioId() {
		return this.horarioId;
	}

	public void setHorarioId(Integer horarioId) {
		this.horarioId = horarioId;
	}

	@Column(name = "nota")
	public String getNota() {
		return this.nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

}
