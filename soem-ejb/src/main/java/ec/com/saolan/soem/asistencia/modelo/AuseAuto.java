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
 * AuseAuto generated by hbm2java
 */
@Entity
@Table(name = "ause_auto")
public class AuseAuto implements java.io.Serializable {

	private Integer auseAutoId;
	private Ausencia ausencia;
	private PersEmpl persEmpl;
	private Date fecha;
	private String estado;
	private Integer nivel;

	private static final long serialVersionUID = -8482285540110797483L;

	public AuseAuto() {
	}

	public AuseAuto(Integer auseAutoId, Ausencia ausencia, PersEmpl persEmpl,
			Date fecha, String estado, Integer nivel) {
		this.auseAutoId = auseAutoId;
		this.ausencia = ausencia;
		this.persEmpl = persEmpl;
		this.fecha = fecha;
		this.estado = estado;
		this.nivel = nivel;
	}

	@Id
	@TableGenerator(name = "idAuseAuto", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "ause_auto", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idAuseAuto")
	@Column(name = "ause_auto_id", unique = true, nullable = false)
	public Integer getAuseAutoId() {
		return this.auseAutoId;
	}

	public void setAuseAutoId(Integer auseAutoId) {
		this.auseAutoId = auseAutoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ausencia_id", nullable = false)
	public Ausencia getAusencia() {
		return this.ausencia;
	}

	public void setAusencia(Ausencia ausencia) {
		this.ausencia = ausencia;
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
	@Column(name = "fecha", nullable = false, length = 29)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Column(name = "estado", nullable = false, length = 4)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Column(name = "nivel", nullable = false)
	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

}
