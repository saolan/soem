package ec.com.tecnointel.soem.caja.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.parametro.modelo.DocuEgre;

/**
 * CajaDocuEgre generated by hbm2java
 */
@Entity
@Table(name = "caja_docu_egre")
@NamedEntityGraph(name = "cajaDocuEgre.Graph", attributeNodes = {
@NamedAttributeNode(value = "caja"),
@NamedAttributeNode(value = "docuEgre") })
public class CajaDocuEgre implements java.io.Serializable {

	private Integer cajaDocuEgreId;
	private Caja caja;
	private DocuEgre docuEgre;
	private String serie1;
	private String serie2;
	private Integer numero;
	
	private Set<SaliArch> saliArchs = new HashSet<SaliArch>();

	private static final long serialVersionUID = 4177774948989518740L;

	public CajaDocuEgre() {
	}

	public CajaDocuEgre(Integer cajaDocuEgreId, Caja caja, DocuEgre docuEgre, String serie1, String serie2,
			Integer numero) {
		this.cajaDocuEgreId = cajaDocuEgreId;
		this.caja = caja;
		this.docuEgre = docuEgre;
		this.serie1 = serie1;
		this.serie2 = serie2;
		this.numero = numero;
	}

	public CajaDocuEgre(Integer cajaDocuEgreId, Caja caja, DocuEgre docuEgre, String serie1, String serie2,
			Integer numero, Set<SaliArch> saliArchs) {
		this.cajaDocuEgreId = cajaDocuEgreId;
		this.caja = caja;
		this.docuEgre = docuEgre;
		this.serie1 = serie1;
		this.serie2 = serie2;
		this.numero = numero;
		this.saliArchs = saliArchs;
	}

	@Id
	@TableGenerator(name = "idCajaDocuEgre", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "caja_docu_egre", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idCajaDocuEgre")
	@Column(name = "CAJA_DOCU_EGRE_ID", unique = true, nullable = false)
	public Integer getCajaDocuEgreId() {
		return this.cajaDocuEgreId;
	}

	public void setCajaDocuEgreId(Integer cajaDocuEgreId) {
		this.cajaDocuEgreId = cajaDocuEgreId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CAJA_ID", nullable = false)
	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENTO_ID", nullable = false)
	public DocuEgre getDocuEgre() {
		return this.docuEgre;
	}

	public void setDocuEgre(DocuEgre docuEgre) {
		this.docuEgre = docuEgre;
	}

	@Column(name = "SERIE1", nullable = false, length = 3)
	public String getSerie1() {
		return this.serie1;
	}

	public void setSerie1(String serie1) {
		this.serie1 = serie1;
	}

	@Column(name = "SERIE2", nullable = false, length = 3)
	public String getSerie2() {
		return this.serie2;
	}

	public void setSerie2(String serie2) {
		this.serie2 = serie2;
	}

	@Column(name = "NUMERO", nullable = false, precision = 10, scale = 0)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cajaDocuEgre")
	public Set<SaliArch> getSaliArchs() {
		return saliArchs;
	}

	public void setSaliArchs(Set<SaliArch> saliArchs) {
		this.saliArchs = saliArchs;
	}

}