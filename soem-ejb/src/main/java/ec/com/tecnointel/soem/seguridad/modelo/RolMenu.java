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
 * RolMenu generated by hbm2java
 */
@Entity
@Table(name = "rol_menu")
@NamedEntityGraph(name = "rolMenu.Graph", attributeNodes = { 
		@NamedAttributeNode(value = "rol"),
		@NamedAttributeNode(value = "menu")})
public class RolMenu implements java.io.Serializable {

	private Integer rolMenuId;
	private Menu menu;
	private Rol rol;
	private Boolean acceso;

	private static final long serialVersionUID = 8990086521684517127L;

	public RolMenu() {
	}

	public RolMenu(Integer rolMenuId, Menu menu, Rol rol, Boolean acceso) {
		this.rolMenuId = rolMenuId;
		this.menu = menu;
		this.rol = rol;
		this.acceso = acceso;
	}

	@Id
	@TableGenerator(name = "idRolMenu", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "rol_menu", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idRolMenu")
	@Column(name = "ROL_MENU_ID", unique = true, nullable = false)
	public Integer getRolMenuId() {
		return this.rolMenuId;
	}

	public void setRolMenuId(Integer rolMenuId) {
		this.rolMenuId = rolMenuId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID", nullable = false)
	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
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



}