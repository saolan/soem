package ec.com.tecnointel.soem.ingreso.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.math.BigDecimal;
import java.time.LocalDate;

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
import javax.persistence.Transient;

/**
 * ReteDeta generated by hbm2java
 */
@Entity
@Table(name = "rete_deta")
public class ReteDeta implements java.io.Serializable {

	private Integer reteDetaId;
	private Retencion retencion;
	private LocalDate ejerciFisc;
	private String impues;
	private String codigoImpu;
	private BigDecimal base;
	private BigDecimal porcen;

//	@Transient
	private BigDecimal reteDetaTotal;
	
	private static final long serialVersionUID = -4948870471671297275L;

	public ReteDeta() {
	}

	@Id
	@TableGenerator(name = "idReteDeta", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "rete_deta", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idReteDeta")
	@Column(name = "RETE_DETA_ID", unique = true, nullable = false)
	public Integer getReteDetaId() {
		return this.reteDetaId;
	}

	public void setReteDetaId(Integer reteDetaId) {
		this.reteDetaId = reteDetaId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "RETENCION_ID", nullable = false)
	public Retencion getRetencion() {
		return this.retencion;
	}

	public void setRetencion(Retencion retencion) {
		this.retencion = retencion;
	}

	@Column(columnDefinition = "DATE", name = "EJERCI_FISC", nullable = false, length = 10)
	public LocalDate getEjerciFisc() {
		return ejerciFisc;
	}

	public void setEjerciFisc(LocalDate ejerciFisc) {
		this.ejerciFisc = ejerciFisc;
	}

	@Column(name = "IMPUES", nullable = false, length = 50)
	public String getImpues() {
		return this.impues;
	}

	public void setImpues(String impues) {
		this.impues = impues;
	}

	@Column(name = "CODIGO_IMPU", nullable = false, length = 6)
	public String getCodigoImpu() {
		return this.codigoImpu;
	}

	public void setCodigoImpu(String codigoImpu) {
		this.codigoImpu = codigoImpu;
	}

	@Column(name = "BASE", nullable = false, precision = 14, scale = 6)
	public BigDecimal getBase() {
		return this.base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	@Column(name = "PORCEN", nullable = false, precision = 6, scale = 2)
	public BigDecimal getPorcen() {
		return this.porcen;
	}

	public void setPorcen(BigDecimal porcen) {
		this.porcen = porcen;
	}

	@Transient
	public BigDecimal getReteDetaTotal() {
		return reteDetaTotal;
	}

	public void setReteDetaTotal(BigDecimal reteDetaTotal) {
		this.reteDetaTotal = reteDetaTotal;
	}
}
