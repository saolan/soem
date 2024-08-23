package ec.com.tecnointel.soem.tesoreria.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

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
import javax.persistence.Transient;

import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;

/**
 * Cxp generated by hbm2java
 */
@Entity
@Table(name = "cxp")
@NamedEntityGraph(name = "cxp.Graph", attributeNodes =
{
	@NamedAttributeNode(value = "ingreso", subgraph = "persProv.Graph"),
} , 
subgraphs = { @NamedSubgraph
				(
					name = "persProv.Graph", attributeNodes = {
						@NamedAttributeNode(value = "persProv")
					}
				)				
			}  
)
public class Cxp implements java.io.Serializable {

	private Integer cxpId;
	private Ingreso ingreso;
	private LocalDate fechaVenc;
	private LocalDateTime fechaHoraVenc;
	private BigDecimal total;
	private Boolean estado;
	private Set<PagoDeta> pagoDetas = new HashSet<PagoDeta>(0);

	private BigDecimal abono;
	private BigDecimal saldo;
	
	
	private static final long serialVersionUID = -6271573223411518662L;

	public Cxp() {
	}

	@Id
	@TableGenerator(name = "idCxp", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "cxp", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idCxp")
	@Column(name = "CXP_ID", unique = true, nullable = false)
	public Integer getCxpId() {
		return this.cxpId;
	}

	public void setCxpId(Integer cxpId) {
		this.cxpId = cxpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INGRESO_ID", nullable = false)
	public Ingreso getIngreso() {
		return this.ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		this.ingreso = ingreso;
	}

	@Column(columnDefinition = "DATE", name = "FECHA_VENC", nullable = false, length = 10)
	public LocalDate getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(LocalDate fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	
	@Column(columnDefinition = "TIMESTAMP", name = "FECHA_HORA_VENC", nullable = false, length = 19)
	public LocalDateTime getFechaHoraVenc() {
		return fechaHoraVenc;
	}

	public void setFechaHoraVenc(LocalDateTime fechaHoraVenc) {
		this.fechaHoraVenc = fechaHoraVenc;
	}

	@Column(name = "TOTAL", nullable = false, precision = 14, scale = 6)	
	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Column(name = "ESTADO", nullable = false)
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cxp")
	public Set<PagoDeta> getPagoDetas() {
		return this.pagoDetas;
	}

	public void setPagoDetas(Set<PagoDeta> pagoDetas) {
		this.pagoDetas = pagoDetas;
	}
	
	@Transient
	public BigDecimal getAbono() {
		return abono;
	}

	public void setAbono(BigDecimal abono) {
		this.abono = abono;
	}

	@Transient
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cxpId == null) ? 0 : cxpId.hashCode());
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
		Cxp other = (Cxp) obj;
		if (cxpId == null) {
			if (other.cxpId != null)
				return false;
		} else if (!cxpId.equals(other.cxpId))
			return false;
		return true;
	}
}
