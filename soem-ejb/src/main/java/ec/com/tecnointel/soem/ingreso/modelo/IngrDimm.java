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
@Table(name = "ingr_dimm")
@NamedEntityGraph(name = "ingrDimm.Graph", attributeNodes = { @NamedAttributeNode(value = "dimm"),
		@NamedAttributeNode(value = "ingreso") })
public class IngrDimm implements Serializable{

	private Integer ingrDimmId;
	private Ingreso Ingreso;
	private Dimm dimm;
	private String tipo;

	private static final long serialVersionUID = 2289891693815665038L;

	public IngrDimm() {
	}

	@Id
	@TableGenerator(name = "idIngrDimm", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "ingr_dimm", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idIngrDimm")
	@Column(name = "INGR_DIMM_ID", unique = true, nullable = false)
	public Integer getIngrDimmId() {
		return ingrDimmId;
	}

	public void setIngrDimmId(Integer ingrDimmId) {
		this.ingrDimmId = ingrDimmId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INGRESO_ID", nullable = false)
	public Ingreso getIngreso() {
		return Ingreso;
	}

	public void setIngreso(Ingreso ingreso) {
		Ingreso = ingreso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIMM_ID", nullable = false)
	public Dimm getDimm() {
		return dimm;
	}

	public void setDimm(Dimm dimm) {
		this.dimm = dimm;
	}

	@Column(name = "TIPO", nullable = false)
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}	
}
