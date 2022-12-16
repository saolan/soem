package ec.com.tecnointel.soem.ingreso.modelo;

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

import ec.com.tecnointel.soem.parametro.modelo.Dimm;

@Entity
@Table(name = "pers_prov_dimm")
@NamedEntityGraph(name = "persProvDimm.Graph", attributeNodes = { @NamedAttributeNode(value = "dimm"),
		@NamedAttributeNode(value = "persProv") })
public class PersProvDimm implements Serializable {

	private Integer persProvDimmId;
	private String tipo;
	private PersProv persProv;
	private Dimm dimm;

	private static final long serialVersionUID = 1455737552824758047L;
	
	public PersProvDimm() {
	}

	public PersProvDimm(PersProv persProv, Dimm dimm) {
		this.persProv = persProv;
		this.dimm = dimm;
	}

	@Id
	@TableGenerator(name = "idPersProvDimm", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "pers_prov_dimm", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idPersProvDimm")
	@Column(name = "PERS_PROV_DIMM_ID", unique = true, nullable = false)
	public Integer getPersProvDimmId() {
		return persProvDimmId;
	}

	public void setPersProvDimmId(Integer persProvDimmId) {
		this.persProvDimmId = persProvDimmId;
	}

	@Column(name = "TIPO", nullable = false)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSONA_ID", nullable = false)
	public PersProv getPersProv() {
		return persProv;
	}

	public void setPersProv(PersProv persProv) {
		this.persProv = persProv;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIMM_ID", nullable = false)
	public Dimm getDimm() {
		return dimm;
	}

	public void setDimm(Dimm dimm) {
		this.dimm = dimm;
	}
}
