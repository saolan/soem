package ec.com.saolan.soem.nomina.modelo;
// Generated 27/05/2020 20:38:02 by Hibernate Tools 5.2.0.Final

import java.util.HashSet;
import java.util.Set;

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

import ec.com.tecnointel.soem.parametro.modelo.Documento;

/**
 * DocuNomi generated by hbm2java
 */
@Entity
@Table(name = "docu_nomi")
public class DocuNomi implements java.io.Serializable {

	private Integer documentoId;
	private Documento documento;
	private String codigo;
	private String formulCalc;
	private String tipo;
	private boolean afectaIess;
	private boolean afectaImpuRent;
	private String estado;
	private Set<DocuNomiPlanCuen> docuNomiPlanCuens = new HashSet<DocuNomiPlanCuen>(
			0);
	private Set<NomiDeta> nomiMovis = new HashSet<NomiDeta>(0);

	private static final long serialVersionUID = 1722523945214258472L;

	public DocuNomi() {
	}

	public DocuNomi(Documento documento, String codigo, String formulCalc,
			String tipo, boolean afectaIess, boolean afectaImpuRent,
			String estado) {
		this.documento = documento;
		this.codigo = codigo;
		this.formulCalc = formulCalc;
		this.tipo = tipo;
		this.afectaIess = afectaIess;
		this.afectaImpuRent = afectaImpuRent;
		this.estado = estado;
	}

	public DocuNomi(Documento documento, String codigo, String formulCalc,
			String tipo, boolean afectaIess, boolean afectaImpuRent,
			String estado, Set<DocuNomiPlanCuen> docuNomiPlanCuens,
			Set<NomiDeta> nomiMovis) {
		this.documento = documento;
		this.codigo = codigo;
		this.formulCalc = formulCalc;
		this.tipo = tipo;
		this.afectaIess = afectaIess;
		this.afectaImpuRent = afectaImpuRent;
		this.estado = estado;
		this.docuNomiPlanCuens = docuNomiPlanCuens;
		this.nomiMovis = nomiMovis;
	}

	@Id
	@GenericGenerator(name = "idDocuNomi", strategy = "foreign", parameters = @Parameter(name = "property", value = "documento"))
	@GeneratedValue(generator = "idDocuNomi")
	@Column(name = "documento_id", unique = true, nullable = false)
	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@Column(name = "codigo", nullable = false, length = 4)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "formul_calc", nullable = false, length = 100)
	public String getFormulCalc() {
		return this.formulCalc;
	}

	public void setFormulCalc(String formulCalc) {
		this.formulCalc = formulCalc;
	}

	@Column(name = "tipo", nullable = false, length = 12)
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "afecta_iess", nullable = false)
	public boolean isAfectaIess() {
		return this.afectaIess;
	}

	public void setAfectaIess(boolean afectaIess) {
		this.afectaIess = afectaIess;
	}

	@Column(name = "afecta_impu_rent", nullable = false)
	public boolean isAfectaImpuRent() {
		return this.afectaImpuRent;
	}

	public void setAfectaImpuRent(boolean afectaImpuRent) {
		this.afectaImpuRent = afectaImpuRent;
	}

	@Column(name = "estado", nullable = false, length = 12)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuNomi")
	public Set<DocuNomiPlanCuen> getDocuNomiPlanCuens() {
		return this.docuNomiPlanCuens;
	}

	public void setDocuNomiPlanCuens(Set<DocuNomiPlanCuen> docuNomiPlanCuens) {
		this.docuNomiPlanCuens = docuNomiPlanCuens;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuNomi")
	public Set<NomiDeta> getNomiMovis() {
		return this.nomiMovis;
	}

	public void setNomiMovis(Set<NomiDeta> nomiMovis) {
		this.nomiMovis = nomiMovis;
	}

}