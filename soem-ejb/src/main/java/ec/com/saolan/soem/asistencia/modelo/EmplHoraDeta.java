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
 * EmplHoraDeta generated by hbm2java
 */
@Entity
@Table(name = "empl_hora_deta")
public class EmplHoraDeta implements java.io.Serializable {

	private Integer emplHoraDetaId;
	private EmplHora emplHora;
	private Horario horario;
	private PersEmpl persEmpl;
	private Date fecha;

	private static final long serialVersionUID = -1593144204100507280L;

	public EmplHoraDeta() {
	}

	public EmplHoraDeta(Integer emplHoraDetaId, EmplHora emplHora,
			Horario horario, PersEmpl persEmpl, Date fecha) {
		this.emplHoraDetaId = emplHoraDetaId;
		this.emplHora = emplHora;
		this.horario = horario;
		this.persEmpl = persEmpl;
		this.fecha = fecha;
	}

	@Id
	@TableGenerator(name = "idEmplHoraDeta", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "empl_hora_deta", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idEmplHoraDeta")
	@Column(name = "empl_hora_deta_id", unique = true, nullable = false)
	public Integer getEmplHoraDetaId() {
		return this.emplHoraDetaId;
	}

	public void setEmplHoraDetaId(Integer emplHoraDetaId) {
		this.emplHoraDetaId = emplHoraDetaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "empl_hora_id", nullable = false)
	public EmplHora getEmplHora() {
		return this.emplHora;
	}

	public void setEmplHora(EmplHora emplHora) {
		this.emplHora = emplHora;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "horario_id", nullable = false)
	public Horario getHorario() {
		return this.horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona_id", nullable = false)
	public PersEmpl getPersEmpl() {
		return this.persEmpl;
	}

	public void setPersEmpl(PersEmpl persEmpl) {
		this.persEmpl = persEmpl;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha", nullable = false, length = 13)
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}