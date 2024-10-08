package ec.com.tecnointel.soem.seguridad.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

/**
 * Auditoria generated by hbm2java
 */
@Entity
@Table(name = "auditoria")
public class Auditoria implements java.io.Serializable {

	private Integer auditoriaId;
	private PersUsua persUsua;
	private Secuencial secuencial;
	private Sucursal sucursal;
	private String direccIp;
	private String operac;
	private LocalDate fecha;
	private LocalTime hora;
	private LocalDateTime fechaHora;
	private String cadenaActu;
	private String cadenaAnte;

	private static final long serialVersionUID = 653919831011067443L;

	public Auditoria() {
	}

	@Id
	@TableGenerator(name = "idAuditoria", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "auditoria", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idAuditoria")
	@Column(name = "AUDITORIA_ID", unique = true, nullable = false)
	public Integer getAuditoriaId() {
		return this.auditoriaId;
	}

	public void setAuditoriaId(Integer auditoriaId) {
		this.auditoriaId = auditoriaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONA_ID", nullable = false)
	public PersUsua getPersUsua() {
		return this.persUsua;
	}

	public void setPersUsua(PersUsua persUsua) {
		this.persUsua = persUsua;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SECUENCIAL_ID", nullable = false)
	public Secuencial getSecuencial() {
		return this.secuencial;
	}

	public void setSecuencial(Secuencial secuencial) {
		this.secuencial = secuencial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "DIRECC_IP", nullable = false, length = 32)
	public String getDireccIp() {
		return this.direccIp;
	}

	public void setDireccIp(String direccIp) {
		this.direccIp = direccIp;
	}

	@Column(name = "OPERAC", nullable = false, length = 100)
	public String getOperac() {
		return this.operac;
	}

	public void setOperac(String operac) {
		this.operac = operac;
	}

	@Column(columnDefinition = "DATE", name = "FECHA", nullable = false, length = 10)
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Column(columnDefinition = "TIME", name = "HORA", nullable = false, length = 19)
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@Column(columnDefinition = "TIMESTAMP", name = "FECHA_HORA", nullable = false, length = 19)
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Column(name = "CADENA_ACTU", nullable = false, length = 65535)
	public String getCadenaActu() {
		return this.cadenaActu;
	}

	public void setCadenaActu(String cadenaActu) {
		this.cadenaActu = cadenaActu;
	}

	@Column(name = "CADENA_ANTE", length = 65535)
	public String getCadenaAnte() {
		return this.cadenaAnte;
	}

	public void setCadenaAnte(String cadenaAnte) {
		this.cadenaAnte = cadenaAnte;
	}
}
