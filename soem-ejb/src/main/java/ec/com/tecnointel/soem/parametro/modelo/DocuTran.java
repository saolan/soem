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

import ec.com.tecnointel.soem.contabilidad.modelo.Transaccion;

/**
 * DocuTran generated by hbm2java
 */
@Entity
@Table(name = "docu_tran")
public class DocuTran implements java.io.Serializable {

	private Integer documentoId;
	private Documento documento;
	private Set<Transaccion> transaccions = new HashSet<Transaccion>(0);

	private static final long serialVersionUID = -8692514175938561129L;

	public DocuTran() {
	}

	public DocuTran(Documento documento) {
		this.documento = documento;
	}

	public DocuTran(Documento documento, Set<Transaccion> transaccions) {
		this.documento = documento;
		this.transaccions = transaccions;
	}

	@Id
	@GenericGenerator(name = "idDocuTran", strategy = "foreign", parameters = @Parameter(name = "property", value = "documento"))
	@GeneratedValue(generator = "idDocuTran")
	// @TableGenerator(name = "idDocuTran", table = "Secuencial", pkColumnName =
	// "secuencial_id", pkColumnValue = "18", valueColumnName = "numero",
	// allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.TABLE, generator =
	// "idDocuTran")
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuTran")
	public Set<Transaccion> getTransaccions() {
		return this.transaccions;
	}

	public void setTransaccions(Set<Transaccion> transaccions) {
		this.transaccions = transaccions;
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
		DocuTran other = (DocuTran) obj;
		if (documentoId == null) {
			if (other.documentoId != null)
				return false;
		} else if (!documentoId.equals(other.documentoId))
			return false;
		return true;
	}

}
