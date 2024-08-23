package ec.com.tecnointel.soem.tesoreria.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.math.BigDecimal;

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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * CobrDeta generated by hbm2java
 */
@Entity
@Table(name = "cobr_deta")
@NamedEntityGraph(name = "cobrDeta.Graph", attributeNodes =
{
	@NamedAttributeNode(value = "cxc", subgraph = "egreso.Graph"),
	@NamedAttributeNode(value = "fpmeFormPago")
} , 
subgraphs = {
			@NamedSubgraph(
							name = "egreso.Graph", attributeNodes = {
									@NamedAttributeNode(value = "egreso", subgraph = "persClie.Graph")
							}
						),  
			@NamedSubgraph(
					name = "persClie.Graph", attributeNodes = {
							@NamedAttributeNode(value = "persClie")
					}
				)				
			}  

)
public class CobrDeta implements java.io.Serializable {

	private Integer cobrDetaId;
	private Integer egresoId;
	private Cxc cxc;
//	private FormPagoMoviEgre formPagoMoviEgre;
	private FpmeFormPago fpmeFormPago;
	private BigDecimal total;

	private static final long serialVersionUID = 1648446627619102188L;

	public CobrDeta() {
	}

	public CobrDeta(Integer cobrDetaId, Integer egresoId, BigDecimal total, Cxc cxc) {
		this.cobrDetaId = cobrDetaId;
		this.egresoId = egresoId;
		this.total = total;
		this.cxc = cxc;
//		this.formPagoMoviEgre = formPagoMoviEgre;
	}

	@Id
	@TableGenerator(name = "idCobrDeta", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "cobr_deta", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idCobrDeta")
	@Column(name = "COBR_DETA_ID", unique = true, nullable = false)
	public Integer getCobrDetaId() {
		return this.cobrDetaId;
	}

	public void setCobrDetaId(Integer cobrDetaId) {
		this.cobrDetaId = cobrDetaId;
	}

	// Columna solo de referencia para saber de que documento del modulo del ventas es el pago
	// y realailzar el proceso de anulacion de documentos
	@Column(name = "EGRESO_ID")
	public Integer getEgresoId() {
		return egresoId;
	}

	public void setEgresoId(Integer egresoId) {
		this.egresoId = egresoId;
	}

	@Column(name = "TOTAL", nullable = false, precision = 14, scale = 6)
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CXC_ID", nullable = false)
	public Cxc getCxc() {
		return this.cxc;
	}

	public void setCxc(Cxc cxc) {
		this.cxc = cxc;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "FPME_ID", nullable = false)
//	public FormPagoMoviEgre getFormPagoMoviEgre() {
//		return this.formPagoMoviEgre;
//	}
//
//	public void setFormPagoMoviEgre(FormPagoMoviEgre formPagoMoviEgre) {
//		this.formPagoMoviEgre = formPagoMoviEgre;
//	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FPME_FORM_PAGO_ID", nullable = false)
	public FpmeFormPago getFpmeFormPago() {
		return fpmeFormPago;
	}

	public void setFpmeFormPago(FpmeFormPago fpmeFormPago) {
		this.fpmeFormPago = fpmeFormPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cobrDetaId == null) ? 0 : cobrDetaId.hashCode());
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
		CobrDeta other = (CobrDeta) obj;
		if (cobrDetaId == null) {
			if (other.cobrDetaId != null)
				return false;
		} else if (!cobrDetaId.equals(other.cobrDetaId))
			return false;
		return true;
	}

}
