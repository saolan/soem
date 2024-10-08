package ec.com.tecnointel.soem.inventario.modelo;
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
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.parametro.modelo.Precio;
import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

/**
 * ProdPrec generated by hbm2java
 */
@Entity
@Table(name = "prod_prec")
@NamedEntityGraph(name = "prodPrec.Graph", attributeNodes = {
		@NamedAttributeNode(value = "producto"),
		@NamedAttributeNode(value = "precio"),
		@NamedAttributeNode(value = "sucursal")
		}
)
public class ProdPrec implements java.io.Serializable {

	private Integer prodPrecId;
	private Precio precio;
	private Producto producto;
	private Sucursal sucursal;
	private BigDecimal factor; 
	private BigDecimal precioSinImpu;
	private BigDecimal precioConImpu;
	private BigDecimal utilid;

	private static final long serialVersionUID = -5612468953479989795L;

	public ProdPrec() {
	}


	public ProdPrec(Sucursal sucursal, Precio precio, Producto producto) {
		this.sucursal = sucursal;
		this.precio = precio;
		this.producto = producto;
	}

	@Id
	@TableGenerator(name = "idProdPrec", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "prod_prec", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idProdPrec")
	@Column(name = "PROD_PREC_ID", unique = true, nullable = false)
	public Integer getProdPrecId() {
		return this.prodPrecId;
	}

	public void setProdPrecId(Integer prodPrecId) {
		this.prodPrecId = prodPrecId;
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
	@JoinColumn(name = "PRODUCTO_ID", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "FACTOR", nullable = false, precision = 12, scale = 6)
	public BigDecimal getFactor() {
		return factor;
	}

	public void setFactor(BigDecimal factor) {
		this.factor = factor;
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
//	@Digits(integer=4, fraction=4)
	public BigDecimal getUtilid() {
		return this.utilid;
	}

	public void setUtilid(BigDecimal utilid) {
		this.utilid = utilid;
	}
}
