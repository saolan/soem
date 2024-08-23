package ec.com.tecnointel.soem.parametro.modelo;

import java.io.Serializable;

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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.validator.constraints.NotBlank;

import ec.com.tecnointel.soem.firmaElec.modelo.CertEmis;

@Entity
@Table(name = "sucu_cert_emis")
@NamedEntityGraph(name = "sucuCertEmis.Graph", attributeNodes = {
@NamedAttributeNode(value = "sucursal"), 
@NamedAttributeNode(value = "certEmis") })
public class SucuCertEmis implements Serializable {

	private Integer sucursalId;
	private Sucursal sucursal;
	private CertEmis certEmis;
	private String ruta;
	private String descri;
	private String clave;

	private static final long serialVersionUID = -2146561116787862392L;

	public SucuCertEmis() {
	}

	public SucuCertEmis(Sucursal sucursal, CertEmis certEmis) {
		this.sucursal = sucursal;
		this.certEmis = certEmis;
	}

	@Id
	@GenericGenerator(name = "idSucuCertId", strategy = "foreign", parameters = @Parameter(name = "property", value = "sucursal"))
	@GeneratedValue(generator = "idSucuCertId")
	@Column(name = "SUCURSAL_ID", unique = true, nullable = false)
	public Integer getSucursalId() {
		return sucursalId;
	}

	public void setSucursalId(Integer sucursalId) {
		this.sucursalId = sucursalId;
	}
	
	@NotBlank
	@Column(name = "RUTA", nullable = false, length = 100)
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@NotBlank
	@Column(name = "DESCRI", nullable = false, length = 100)
	public String getDescri() {
		return descri;
	}

	public void setDescri(String descri) {
		this.descri = descri;
	}

	@NotBlank
	@Column(name = "CLAVE", nullable = false, length = 100)
	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@PrimaryKeyJoinColumn
	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CERT_EMIS_ID", nullable = false)
	public CertEmis getCertEmis() {
		return certEmis;
	}

	public void setCertEmis(CertEmis certEmis) {
		this.certEmis = certEmis;
	}
}
