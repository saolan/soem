package ec.com.tecnointel.soem.parametro.modelo;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrupPlanCuen;
import ec.com.tecnointel.soem.ingreso.modelo.ProvGrupPlanCuen;
import ec.com.tecnointel.soem.inventario.modelo.Kardex;
import ec.com.tecnointel.soem.inventario.modelo.ProdGrupPlanCuen;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

/**
 * Documento generated by hbm2java
 */
@Entity
@Table(name = "documento")
public class Documento implements java.io.Serializable {

	private Integer documentoId;
	private String descri;
	private Integer numero;
	private boolean contab;
	private String format;
	private short copias;
	private boolean enviaCorreo;
	private short factor;
	private boolean estado;
	
	private Documento documento;
	private DocuTran docuTran;
	private DocuCaja docuCaja;
	private DocuMoviIngr docuMoviIngr;
	private DocuMoviEgre docuMoviEgre;
	private DocuIngr docuIngr;
	private DocuEgre docuEgre;
	
	private Set<RolDocu> rolDocus = new HashSet<RolDocu>(0);
	private Set<Kardex> kardexs = new HashSet<Kardex>(0);
	
	private Set<ProdGrupPlanCuen> prodGrupPlanCuens = new HashSet<>(0);
	private Set<ProvGrupPlanCuen> provGrupPlanCuens = new HashSet<>(0);
	private Set<ClieGrupPlanCuen> clieGrupPlanCuens = new HashSet<>(0);
	
	private static final long serialVersionUID = -8539679635848001944L;

	public Documento() {
	}
			
//	Constructor A
	public Documento(boolean estado) {
		this.estado =  estado;
	}

//	Constructor B encadenado a constrictor A
	public Documento(String descri, boolean estado) {
		this(estado);
		this.descri = descri;
	}

	@Id
	@TableGenerator(name = "idDocumento", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "documento", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idDocumento")
	@Column(name = "DOCUMENTO_ID", unique = true, nullable = false)
	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "NUMERO", nullable = false, precision = 10, scale = 0)
	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	@Column(name = "CONTAB", nullable = false)
	public boolean isContab() {
		return this.contab;
	}

	public void setContab(boolean contab) {
		this.contab = contab;
	}

	@Column(name = "FORMAT", nullable = false)
	public String getFormat() {
		return this.format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Column(name = "COPIAS", nullable = false)
	public short getCopias() {
		return this.copias;
	}

	public void setCopias(short copias) {
		this.copias = copias;
	}

	@Column(name = "ENVIA_CORREO", nullable = false)
	public boolean isEnviaCorreo() {
		return enviaCorreo;
	}

	public void setEnviaCorreo(boolean enviaCorreo) {
		this.enviaCorreo = enviaCorreo;
	}

	@Column(name = "FACTOR", nullable = false)
	public short getFactor() {
		return this.factor;
	}

	public void setFactor(short factor) {
		this.factor = factor;
	}

	@Column(name = "ESTADO", nullable = false)
	public boolean isEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuTran getDocuTran() {
		return this.docuTran;
	}

	public void setDocuTran(DocuTran docuTran) {
		this.docuTran = docuTran;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuCaja getDocuCaja() {
		return this.docuCaja;
	}

	public void setDocuCaja(DocuCaja docuCaja) {
		this.docuCaja = docuCaja;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuMoviIngr getDocuMoviIngr() {
		return docuMoviIngr;
	}

	public void setDocuMoviIngr(DocuMoviIngr docuMoviIngr) {
		this.docuMoviIngr = docuMoviIngr;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuMoviEgre getDocuMoviEgre() {
		return docuMoviEgre;
	}

	public void setDocuMoviEgre(DocuMoviEgre docuMoviEgre) {
		this.docuMoviEgre = docuMoviEgre;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuIngr getDocuIngr() {
		return this.docuIngr;
	}

	public void setDocuIngr(DocuIngr docuIngr) {
		this.docuIngr = docuIngr;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "documento")
	public DocuEgre getDocuEgre() {
		return this.docuEgre;
	}

	public void setDocuEgre(DocuEgre docuEgre) {
		this.docuEgre = docuEgre;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "documento")
	public Set<RolDocu> getRolDocus() {
		return this.rolDocus;
	}

	public void setRolDocus(Set<RolDocu> rolDocus) {
		this.rolDocus = rolDocus;
	}
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="documento")
    public Set<Kardex> getKardexs() {
        return this.kardexs;
    }
    
    public void setKardexs(Set<Kardex> kardexs) {
        this.kardexs = kardexs;
    }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="documento")
	public Set<ProdGrupPlanCuen> getProdGrupPlanCuens() {
		return prodGrupPlanCuens;
	}

	public void setProdGrupPlanCuens(Set<ProdGrupPlanCuen> prodGrupPlanCuens) {
		this.prodGrupPlanCuens = prodGrupPlanCuens;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="documento")
	public Set<ProvGrupPlanCuen> getProvGrupPlanCuens() {
		return provGrupPlanCuens;
	}

	public void setProvGrupPlanCuens(Set<ProvGrupPlanCuen> provGrupPlanCuens) {
		this.provGrupPlanCuens = provGrupPlanCuens;
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="documento")
	public Set<ClieGrupPlanCuen> getClieGrupPlanCuens() {
		return clieGrupPlanCuens;
	}

	public void setClieGrupPlanCuens(Set<ClieGrupPlanCuen> clieGrupPlanCuens) {
		this.clieGrupPlanCuens = clieGrupPlanCuens;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCUMENTO_SUPE_ID")
	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
    
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((documentoId == null) ? 0 : documentoId.hashCode());
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
		Documento other = (Documento) obj;
		if (documentoId == null) {
			if (other.documentoId != null)
				return false;
		} else if (!documentoId.equals(other.documentoId))
			return false;
		return true;
	}
}
