package ec.com.tecnointel.soem.inventario.modelo;
// Generated 27/01/2021 19:41:12 by Hibernate Tools 5.2.11.Final

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
import javax.validation.constraints.DecimalMin;

/**
 * ProdSubp generated by hbm2java
 */
@Entity
@Table(name = "prod_subp")
@NamedEntityGraph(name = "prodSubp.Graph", attributeNodes = { 
		@NamedAttributeNode(value = "subProducto"),
		@NamedAttributeNode(value = "producto")})
public class ProdSubp implements Serializable {

	private Integer prodSubpId;
	private Producto producto;
	private Producto subProducto;
	private BigDecimal cantid;

	private static final long serialVersionUID = -7823879669486634330L;

	public ProdSubp() {
	}

	public ProdSubp(Producto producto) {
		this.producto = producto;
	}

	public ProdSubp(Integer prodSubpId, Producto producto, Producto subProducto, BigDecimal cantid) {
		this.prodSubpId = prodSubpId;
		this.producto = producto;
		this.subProducto = subProducto;
		this.cantid = cantid;
	}

	@Id
	@TableGenerator(name = "idProdSubp", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "prod_subp", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idProdSubp")
	@Column(name = "prod_subp_id", unique = true, nullable = false)
	public Integer getProdSubpId() {
		return this.prodSubpId;
	}

	public void setProdSubpId(Integer prodSubpId) {
		this.prodSubpId = prodSubpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producto_id", nullable = false)
	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sub_producto_id", nullable = false)
	public Producto getSubProducto() {
		return this.subProducto;
	}

	public void setSubProducto(Producto subProducto) {
		this.subProducto = subProducto;
	}

	@Column(name = "cantid", nullable = false, precision = 12, scale = 6)
	@DecimalMin(value = "0.0001")
	public BigDecimal getCantid() {
		return this.cantid;
	}

	public void setCantid(BigDecimal cantid) {
		this.cantid = cantid;
	}

}