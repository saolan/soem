package ec.com.saolan.soem.asistencia.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

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

import ec.com.tecnointel.soem.parametro.modelo.Mapa;

/**
 * MapaFeri generated by hbm2java
 */
@Entity
@Table(name = "mapa_feri")
public class FeriMapa implements java.io.Serializable {

	private Integer feriMapaId;
	private Feriado feriado;
	private Mapa mapa;

	private static final long serialVersionUID = -2899344246633883968L;

	public FeriMapa() {
	}

	public FeriMapa(Integer feriMapaId, Feriado feriado, Mapa mapa) {
		this.feriMapaId = feriMapaId;
		this.feriado = feriado;
		this.mapa = mapa;
	}

	@Id
	@TableGenerator(name = "idMapaFeri", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "mapa_feri", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idMapaFeri")
	@Column(name = "mapa_fest_id", unique = true, nullable = false)
	public Integer getFeriMapaId() {
		return feriMapaId;
	}

	public void setFeriMapaId(Integer feriMapaId) {
		this.feriMapaId = feriMapaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "feriado_id", nullable = false)
	public Feriado getFeriado() {
		return this.feriado;
	}

	public void setFeriado(Feriado feriado) {
		this.feriado = feriado;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "mapa_id", nullable = false)
	public Mapa getMapa() {
		return this.mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}
}
