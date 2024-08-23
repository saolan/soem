package ec.com.tecnointel.soem.egreso.modelo;

import java.io.Serializable;

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

import ec.com.tecnointel.soem.contabilidad.modelo.Transaccion;

@Entity
@Table(name = "egre_tran")
@NamedEntityGraph(name = "egreTran.Graph", attributeNodes = { 
@NamedAttributeNode(value = "egreso"),
@NamedAttributeNode(value = "transaccion") 
})
public class EgreTran implements Serializable {

	private Integer egreTranId;
	private Egreso egreso;
	private Transaccion transaccion;
	private String descri;

	private static final long serialVersionUID = 4560153463193001129L;
		
	public EgreTran() {
	}

	public EgreTran(Egreso egreso, Transaccion transaccion, String descri) {
		this(egreso,transaccion);
//		this.egreso = egreso;
//		this.transaccion = transaccion;
		this.descri = descri;
	}

	public EgreTran(Egreso egreso, Transaccion transaccion) {
		this.egreso = egreso;
		this.transaccion = transaccion;
	}

	@Id
	@TableGenerator(name = "idEgreTran", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "egre_tran", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idEgreTran")
	@Column(name = "EGRE_TRAN_ID", unique = true, nullable = false)
	public Integer getEgreTranId() {
		return egreTranId;
	}

	public void setEgreTranId(Integer egreTranId) {
		this.egreTranId = egreTranId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EGRESO_ID", nullable = false)
	public Egreso getEgreso() {
		return egreso;
	}

	public void setEgreso(Egreso egreso) {
		this.egreso = egreso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACCION_ID", nullable = false)	
	public Transaccion getTransaccion() {
		return transaccion;
	}

	public void setTransaccion(Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	@Column(name = "DESCRI", nullable = false, length = 32)
	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}
}
