package ec.com.tecnointel.soem.ingreso.modelo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.parametro.modelo.Precio;

@Entity
@Table(name = "ingr_deta_prec")
@NamedEntityGraph(name = "ingrDetaPrec.Graph", attributeNodes = {
		@NamedAttributeNode(value = "precio") 
		}
)
public class IngrDetaPrec implements Serializable {

	private Integer IngrDetaPrecId;
	private IngrDeta ingrDeta;
	private Precio precio;
	private BigDecimal factor;
	private BigDecimal precioSinImpu;
	private BigDecimal precioConImpu;
	private BigDecimal utilid;

	private static final long serialVersionUID = 5154907290880039613L;

	public IngrDetaPrec() {
	}

	public IngrDetaPrec(Integer ingrDetaPrecId, IngrDeta ingrDeta, Precio precio, BigDecimal factor, 
			BigDecimal precioSinImpu, BigDecimal precioConImpu, BigDecimal utilid) {
		this.IngrDetaPrecId = ingrDetaPrecId;
		this.precio = precio;
		this.factor = factor;
		this.ingrDeta = ingrDeta;
		this.precioSinImpu = precioSinImpu;
		this.precioConImpu = precioConImpu;
		this.utilid = utilid;
	}

	@Id
	@TableGenerator(name = "idIngrDetaPrecId", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "ingr_deta_prec", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idIngrDetaPrecId")
	@Column(name = "INGR_DETA_PREC_ID", unique = true, nullable = false)
	public Integer getIngrDetaPrecId() {
		return this.IngrDetaPrecId;
	}

	public void setIngrDetaPrecId(Integer ingrDetaPrecId) {
		IngrDetaPrecId = ingrDetaPrecId;
	}

	@Column(name = "FACTOR", nullable = false, precision = 12, scale = 6)
	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRECIO_ID", nullable = false)
	public Precio getPrecio() {
		return this.precio;
	}

	public void setPrecio(Precio precio) {
		this.precio = precio;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INGR_DETA_ID", nullable = false)
	public IngrDeta getIngrDeta() {
		return ingrDeta;
	}

	public void setIngrDeta(IngrDeta ingrDeta) {
		this.ingrDeta = ingrDeta;
	}

	@Column(name = "PRECIO_SIN_IMPU", nullable = false, precision = 14, scale = 6)
	public BigDecimal getPrecioSinImpu() {
		return precioSinImpu;
	}

	public void setPrecioSinImpu(BigDecimal precioSinImpu) {
		this.precioSinImpu = precioSinImpu;
	}

	@Column(name = "PRECIO_CON_IMPU", nullable = false, precision = 14, scale = 6)
	public BigDecimal getPrecioConImpu() {
		return precioConImpu;
	}

	public void setPrecioConImpu(BigDecimal precioConImpu) {
		this.precioConImpu = precioConImpu;
	}

	@Column(name = "UTILID", nullable = false, precision = 14, scale = 4)
//	@Digits(integer=10, fraction=4)
	public BigDecimal getUtilid() {
		return this.utilid;
	}

	public void setUtilid(BigDecimal utilid) {
		this.utilid = utilid;
	}
}
