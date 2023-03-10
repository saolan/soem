package ec.com.tecnointel.soem.seguridad.modelo;
// Generated 26-jul-2016 22:29:48 by Hibernate Tools 5.1.0.Alpha2

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

import ec.com.tecnointel.soem.parametro.modelo.Sucursal;

/**
 * RolSucu generated by hbm2java
 */
@Entity
@Table(name = "rol_sucu")
@NamedEntityGraph(name = "rolSucu.Graph", attributeNodes = {
@NamedAttributeNode(value = "rol"),
@NamedAttributeNode(value = "sucursal") })
public class RolSucu implements java.io.Serializable {

	private Integer rolSucuId;
	private Rol rol;
	private Sucursal sucursal;
	private Boolean acceso;

	private static final long serialVersionUID = 7530463225454566772L;

	public RolSucu() {
	}

	public RolSucu(Integer rolSucuId, Rol rol, Sucursal sucursal, Boolean acceso) {
		this.rolSucuId = rolSucuId;
		this.rol = rol;
		this.sucursal = sucursal;
		this.acceso = acceso;
	}

	@Id
	@TableGenerator(name = "idRolSucu", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "rol_sucu", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idRolSucu")
	@Column(name = "ROL_SUCU_ID", unique = true, nullable = false)
	public Integer getRolSucuId() {
		return this.rolSucuId;
	}

	public void setRolSucuId(Integer rolSucuId) {
		this.rolSucuId = rolSucuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUCURSAL_ID", nullable = false)
	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@Column(name = "ACCESO", nullable = false)
	public Boolean getAcceso() {
		return acceso;
	}

	public void setAcceso(Boolean acceso) {
		this.acceso = acceso;
	}

}
