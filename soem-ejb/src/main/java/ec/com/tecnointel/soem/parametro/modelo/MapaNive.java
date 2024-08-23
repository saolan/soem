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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * MapaNive generated by hbm2java
 */
@Entity
@Table(name = "mapa_nive")
public class MapaNive implements java.io.Serializable {

	private Integer mapaNiveId;
	private String descri;
	private Integer nivel;
	private Set<Mapa> mapas = new HashSet<Mapa>(0);

	private static final long serialVersionUID = 2091416677462581241L;

	public MapaNive() {
	}

	public MapaNive(Integer mapaNiveId, String descri, Integer nivel) {
		this.mapaNiveId = mapaNiveId;
		this.descri = descri;
		this.nivel = nivel;
	}

	public MapaNive(Integer mapaNiveId, String descri, Integer nivel, Set<Mapa> mapas) {
		this.mapaNiveId = mapaNiveId;
		this.descri = descri;
		this.nivel = nivel;
		this.mapas = mapas;
	}

	@Id
	@TableGenerator(name = "idMapaNive", table = "secuencial", pkColumnName = "tabla", pkColumnValue = "mapa_nive", valueColumnName = "numero", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "idMapaNive")
	@Column(name = "MAPA_NIVE_ID", unique = true, nullable = false)
	public Integer getMapaNiveId() {
		return this.mapaNiveId;
	}

	public void setMapaNiveId(Integer mapaNiveId) {
		this.mapaNiveId = mapaNiveId;
	}

	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return this.descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@Column(name = "NIVEL", nullable = false)
	public Integer getNivel() {
		return this.nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mapaNive")
	public Set<Mapa> getMapas() {
		return this.mapas;
	}

	public void setMapas(Set<Mapa> mapas) {
		this.mapas = mapas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mapaNiveId == null) ? 0 : mapaNiveId.hashCode());
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
		MapaNive other = (MapaNive) obj;
		if (mapaNiveId == null) {
			if (other.mapaNiveId != null)
				return false;
		} else if (!mapaNiveId.equals(other.mapaNiveId))
			return false;
		return true;
	}

}
