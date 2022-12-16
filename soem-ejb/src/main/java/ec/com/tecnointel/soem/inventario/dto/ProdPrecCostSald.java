package ec.com.tecnointel.soem.inventario.dto;

import java.math.BigDecimal;

public class ProdPrecCostSald {

	Integer precioId;
	BigDecimal precio;
	BigDecimal ktv_cantid;
	String prodCodigoBarra;
	String prodDescri;

	public ProdPrecCostSald(Integer precioId, BigDecimal precio, BigDecimal ktv_cantid, String prodCodigoBarra,
			String prodDescri) {
		this.precioId = precioId;
		this.precio = precio;
		this.ktv_cantid = ktv_cantid;
		this.prodCodigoBarra = prodCodigoBarra;
		this.prodDescri = prodDescri;
	}

	public Integer getPrecioId() {
		return precioId;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public BigDecimal getKtv_cantid() {
		return ktv_cantid;
	}

	public String getProdCodigoBarra() {
		return prodCodigoBarra;
	}

	public String getProdDescri() {
		return prodDescri;
	}
}
