package ec.com.tecnointel.soem.parametro.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviIngr;

/**
 * DocuMoviIngr generated by hbm2java
 */
@Entity
@Table(name = "docu_movi_ingr")
public class DocuMoviIngr implements java.io.Serializable {

	private Integer documentoId;
	private String tipo;
	
	private Documento documento;
	private Set<FormPagoMoviIngr> formPagoMoviIngrs = new HashSet<FormPagoMoviIngr>(0);

	private static final long serialVersionUID = -5768213870894234125L;

	public DocuMoviIngr() {
	}

	public DocuMoviIngr(Documento documento, String tipo) {
		this.documento = documento;
		this.tipo = tipo;
	}

	public DocuMoviIngr(Documento documento, String tipo, Set<FormPagoMoviIngr> formPagoMoviIngrs) {
		this.documento = documento;
		this.tipo = tipo;
		this.formPagoMoviIngrs = formPagoMoviIngrs;
	}

	@Id
	@GenericGenerator(name = "idDocuMoviIngr", strategy = "foreign", parameters = @Parameter(name = "property", value = "documento"))
	@GeneratedValue(generator = "idDocuMoviIngr")
	// @TableGenerator(name = "idMoviIngr", table = "Secuencial",
	// pkColumnName = "secuencial_id", pkColumnValue = "16", valueColumnName =
	// "numero", allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.TABLE, generator =
	// "idMoviIngr")
	@Column(name = "DOCUMENTO_ID", unique = true, nullable = false)
	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@Column(name = "TIPO", nullable = false)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuMoviIngr")
	public Set<FormPagoMoviIngr> getFormPagoMoviIngrs() {
		return this.formPagoMoviIngrs;
	}

	public void setFormPagoMoviIngrs(Set<FormPagoMoviIngr> formPagoMoviIngrs) {
		this.formPagoMoviIngrs = formPagoMoviIngrs;
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
		DocuMoviIngr other = (DocuMoviIngr) obj;
		if (documentoId == null) {
			if (other.documentoId != null)
				return false;
		} else if (!documentoId.equals(other.documentoId))
			return false;
		return true;
	}
}
