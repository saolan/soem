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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;

/**
 * DocuIngr generated by hbm2java
 */
@Entity
@Table(name = "docu_ingr")
@NamedEntityGraph(name = "docuIngr.Graph", 
attributeNodes = { @NamedAttributeNode(value = "dimm") })
public class DocuIngr implements java.io.Serializable {

	private Integer documentoId;
	private Dimm dimm;
	private Documento documento;
	private String forma2;
	private boolean afectaCost;
	private boolean generaAnex;
	private boolean generaCxp;
	private boolean generaImpu;
	private String tipoComp;
	private String documeElec;
	private String ambien;
	private String tipoEmis;
	private String tipoRete;
	private String codigoTipoCompRete;
	private Set<Ingreso> ingresos = new HashSet<Ingreso>(0);

	private static final long serialVersionUID = -3590811651369336909L;

	public DocuIngr() {
	}

	public DocuIngr(Documento documento) {
		this.documento = documento;
	}

	@Id
	@GenericGenerator(name = "idDocuIngr", strategy = "foreign", parameters = @Parameter(name = "property", value = "documento"))
	@GeneratedValue(generator = "idDocuIngr")
	// @TableGenerator(name = "idDocuIngr", table = "Secuencial", pkColumnName =
	// "secuencial_id", pkColumnValue = "17", valueColumnName = "numero",
	// allocationSize = 1)
	// @GeneratedValue(strategy = GenerationType.TABLE, generator =
	// "idDocuIngr")
	@Column(name = "DOCUMENTO_ID", unique = true, nullable = false)
	public Integer getDocumentoId() {
		return this.documentoId;
	}

	public void setDocumentoId(Integer documentoId) {
		this.documentoId = documentoId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIMM_ID", nullable = false)
	public Dimm getDimm() {
		return this.dimm;
	}

	public void setDimm(Dimm dimm) {
		this.dimm = dimm;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	public Documento getDocumento() {
		return this.documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	@Column(name = "FORMA2", nullable = false)
	public String getForma2() {
		return forma2;
	}

	public void setForma2(String forma2) {
		this.forma2 = forma2;
	}
	
	@Column(name = "AFECTA_COST", nullable = false)
	public boolean isAfectaCost() {
		return afectaCost;
	}

	public void setAfectaCost(boolean afectaCost) {
		this.afectaCost = afectaCost;
	}

	@Column(name = "GENERA_ANEX", nullable = false)
	public boolean isGeneraAnex() {
		return this.generaAnex;
	}

	public void setGeneraAnex(boolean generaAnex) {
		this.generaAnex = generaAnex;
	}

	@Column(name = "GENERA_CXP", nullable = false)
	public boolean isGeneraCxp() {
		return this.generaCxp;
	}

	public void setGeneraCxp(boolean generaCxp) {
		this.generaCxp = generaCxp;
	}

	@Column(name = "GENERA_IMPU", nullable = false)
	public boolean isGeneraImpu() {
		return generaImpu;
	}

	public void setGeneraImpu(boolean generaImpu) {
		this.generaImpu = generaImpu;
	}

	@Column(name = "TIPO_COMP", nullable = false)
	public String getTipoComp() {
		return tipoComp;
	}

	public void setTipoComp(String tipoComp) {
		this.tipoComp = tipoComp;
	}

	@Column(name = "DOCUME_ELEC", nullable = false)
	public String getDocumeElec() {
		return documeElec;
	}

	public void setDocumeElec(String documeElec) {
		this.documeElec = documeElec;
	}
	
	@Column(name = "AMBIEN", nullable = false)
	public String getAmbien() {
		return ambien;
	}

	public void setAmbien(String ambien) {
		this.ambien = ambien;
	}

	@Column(name = "TIPO_EMIS", nullable = false)
	public String getTipoEmis() {
		return tipoEmis;
	}

	public void setTipoEmis(String tipoEmis) {
		this.tipoEmis = tipoEmis;
	}

	@Column(name = "TIPO_RETE", nullable = false)
	public String getTipoRete() {
		return tipoRete;
	}

	public void setTipoRete(String tipoRete) {
		this.tipoRete = tipoRete;
	}
	
	@Column(name = "CODIGO_TIPO_COMP_RETE", nullable = false)
	public String getCodigoTipoCompRete() {
		return codigoTipoCompRete;
	}

	public void setCodigoTipoCompRete(String codigoTipoCompRete) {
		this.codigoTipoCompRete = codigoTipoCompRete;
	}

	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docuIngr")
	public Set<Ingreso> getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(Set<Ingreso> ingresos) {
		this.ingresos = ingresos;
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
		DocuIngr other = (DocuIngr) obj;
		if (documentoId == null) {
			if (other.documentoId != null)
				return false;
		} else if (!documentoId.equals(other.documentoId))
			return false;
		return true;
	}
}