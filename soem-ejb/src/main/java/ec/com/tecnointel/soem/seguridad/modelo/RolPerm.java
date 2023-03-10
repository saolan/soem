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

/**
 * RolPerm generated by hbm2java
 */
@Entity
@Table(name = "rol_perm")
@NamedEntityGraph(name = "rolPerm.Graph", attributeNodes = {
@NamedAttributeNode(value = "rol"), 
@NamedAttributeNode(value = "permiso") })
public class RolPerm implements java.io.Serializable {

	private Integer rolPermId;
	private Permiso permiso;
	private Rol rol;
	private Boolean acceso;

	private static final long serialVersionUID = -2463927469909777163L;

	public RolPerm() {
	}

	public RolPerm(Integer rolPermId, Permiso permiso, Rol rol, Boolean acceso) {
		this.rolPermId = rolPermId;
		this.permiso = permiso;
		this.rol = rol;
		this.acceso = acceso;
	}

	@Id
	@TableGenerator(name = "idRolPerm", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "rol_perm", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idRolPerm")
	@Column(name = "ROL_PERM_ID", unique = true, nullable = false)
	public Integer getRolPermId() {
		return this.rolPermId;
	}

	public void setRolPermId(Integer rolPermId) {
		this.rolPermId = rolPermId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERMISO_ID", nullable = false)
	public Permiso getPermiso() {
		return this.permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID", nullable = false)
	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Column(name = "ACCESO", nullable = false)
	public Boolean getAcceso() {
		return acceso;
	}

	public void setAcceso(Boolean acceso) {
		this.acceso = acceso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permiso == null) ? 0 : permiso.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
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
		RolPerm other = (RolPerm) obj;
		if (permiso == null) {
			if (other.permiso != null)
				return false;
		} else if (!permiso.equals(other.permiso))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}

}
