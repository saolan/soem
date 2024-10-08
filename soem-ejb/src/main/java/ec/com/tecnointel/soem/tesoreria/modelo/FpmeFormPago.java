package ec.com.tecnointel.soem.tesoreria.modelo;
// Generated 27/01/2021 19:41:12 by Hibernate Tools 5.2.11.Final

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Min;

import ec.com.tecnointel.soem.parametro.modelo.FormPago;

/**
 * FpmeFormPago generated by hbm2java
 */
@Entity
@Table(name = "fpme_form_pago", schema = "public")
@NamedEntityGraph(name = "fpmeFormPago.Graph", attributeNodes = { 
@NamedAttributeNode(value = "formPago", subgraph = "dimm.Graph"),
@NamedAttributeNode(value = "formPagoMoviEgre")},
subgraphs = { @NamedSubgraph
		(
			name = "dimm.Graph", attributeNodes = {
				@NamedAttributeNode(value = "dimm")
			}
		)				
	} 
)
public class FpmeFormPago implements Serializable {

	private Integer fpmeFormPagoId;
	private FormPago formPago;
	private FormPagoMoviEgre formPagoMoviEgre;
	private LocalDate fecha;
	private LocalDateTime fechaHora;
	private short diasPlaz;
	private BigDecimal totalReci;
	private String refere;
	private String unidadTiem;
	
	private Set<CobrDeta> cobrDetas = new HashSet<CobrDeta>(0); 

	private static final long serialVersionUID = -3707745285033429995L;

	public FpmeFormPago() {
	}

	public FpmeFormPago(FormPagoMoviEgre formPagoMoviEgre) {
		this.formPagoMoviEgre = formPagoMoviEgre;
	}

	@Id
	@TableGenerator(name = "idFpmeFormPago", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "fpme_form_pago", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idFpmeFormPago")
	@Column(name = "fpme_form_pago_id", unique = true, nullable = false)
	public Integer getFpmeFormPagoId() {
		return this.fpmeFormPagoId;
	}

	public void setFpmeFormPagoId(Integer fpmeFormPagoId) {
		this.fpmeFormPagoId = fpmeFormPagoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_pago_id", nullable = false)
	public FormPago getFormPago() {
		return this.formPago;
	}

	public void setFormPago(FormPago formPago) {
		this.formPago = formPago;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fpme_id", nullable = false)
	public FormPagoMoviEgre getFormPagoMoviEgre() {
		return this.formPagoMoviEgre;
	}

	public void setFormPagoMoviEgre(FormPagoMoviEgre formPagoMoviEgre) {
		this.formPagoMoviEgre = formPagoMoviEgre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fpmeFormPago")
	public Set<CobrDeta> getCobrDetas() {
		return this.cobrDetas;
	}

	public void setCobrDetas(Set<CobrDeta> cobrDetas) {
		this.cobrDetas = cobrDetas;
	}

	@Column(columnDefinition = "DATE", name = "fecha", nullable = false, length = 10)
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Column(columnDefinition = "TIMESTAMP", name = "fecha_hora", nullable = false, length = 19)
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	@Min(0)
	@Column(name = "DIAS_PLAZ", nullable = false)
	public short getDiasPlaz() {
		return this.diasPlaz;
	}

	public void setDiasPlaz(short diasPlaz) {
		this.diasPlaz = diasPlaz;
	}

	@Column(name = "total_reci", nullable = false, precision = 14, scale = 6)
	public BigDecimal getTotalReci() {
		return this.totalReci;
	}

	public void setTotalReci(BigDecimal totalReci) {
		this.totalReci = totalReci;
	}

	@Column(name = "refere", length = 32)
	public String getRefere() {
		return this.refere;
	}

	public void setRefere(String refere) {
		this.refere = refere;
	}
	
	@Column(name = "unidad_tiem", length = 32)
	public String getUnidadTiem() {
		return unidadTiem;
	}

	public void setUnidadTiem(String unidadTiem) {
		this.unidadTiem = unidadTiem;
	}
}