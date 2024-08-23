package ec.com.tecnointel.soem.documeElec.modelo.notaDebito;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ec.com.tecnointel.soem.documeElec.modelo.InfoTributaria;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoNotaDebito", "motivos", "infoAdicional" })
@XmlRootElement(name = "notaDebito")
public class NotaDebito {
	@XmlElement(required = true)
	protected InfoTributaria infoTributaria;
	@XmlElement(required = true)
	protected InfoNotaDebito infoNotaDebito;
	@XmlElement(required = true)
	protected Motivos motivos;
	protected InfoAdicional infoAdicional;
	@XmlAttribute
	protected String id;
	@XmlAttribute(required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlSchemaType(name = "NMTOKEN")
	protected String version;

	public InfoTributaria getInfoTributaria() {
		return this.infoTributaria;
	}

	public void setInfoTributaria(InfoTributaria value) {
		this.infoTributaria = value;
	}

	public InfoNotaDebito getInfoNotaDebito() {
		return this.infoNotaDebito;
	}

	public void setInfoNotaDebito(InfoNotaDebito value) {
		this.infoNotaDebito = value;
	}

	public Motivos getMotivos() {
		return this.motivos;
	}

	public void setMotivos(Motivos value) {
		this.motivos = value;
	}

	public InfoAdicional getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(InfoAdicional value) {
		this.infoAdicional = value;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String value) {
		this.version = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "campoAdicional" })
	public static class InfoAdicional {
		@XmlElement(required = true)
		protected List<CampoAdicional> campoAdicional;

		public List<CampoAdicional> getCampoAdicional() {
			if (this.campoAdicional == null) {
				this.campoAdicional = new ArrayList();
			}
			return this.campoAdicional;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "value" })
		public static class CampoAdicional {
			@XmlValue
			protected String value;
			@XmlAttribute
			protected String nombre;

			public String getValue() {
				return this.value;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getNombre() {
				return this.nombre;
			}

			public void setNombre(String value) {
				this.nombre = value;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador",
			"razonSocialComprador", "identificacionComprador", "contribuyenteEspecial", "obligadoContabilidad", "rise",
			"codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "impuestos",
			"compensaciones", "valorTotal", "pagos" })
	public static class InfoNotaDebito {
		@XmlElement(required = true)
		protected String fechaEmision;
		protected String dirEstablecimiento;
		@XmlElement(required = true)
		protected String tipoIdentificacionComprador;
		protected String razonSocialComprador;
		@XmlElement(required = true)
		protected String identificacionComprador;
		protected String contribuyenteEspecial;
		protected String obligadoContabilidad;
		protected String rise;
		@XmlElement(required = true)
		protected String codDocModificado;
		@XmlElement(required = true)
		protected String numDocModificado;
		@XmlElement(required = true)
		protected String fechaEmisionDocSustento;
		@XmlElement(required = true)
		protected BigDecimal totalSinImpuestos;
		@XmlElement(required = true)
		protected Impuestos impuestos;
		protected compensacion compensaciones;
		@XmlElement(required = true)
		protected BigDecimal valorTotal;
		protected Pago pagos;

		public String getFechaEmision() {
			return this.fechaEmision;
		}

		public void setFechaEmision(String value) {
			this.fechaEmision = value;
		}

		public String getDirEstablecimiento() {
			return this.dirEstablecimiento;
		}

		public void setDirEstablecimiento(String value) {
			this.dirEstablecimiento = value;
		}

		public String getTipoIdentificacionComprador() {
			return this.tipoIdentificacionComprador;
		}

		public void setTipoIdentificacionComprador(String value) {
			this.tipoIdentificacionComprador = value;
		}

		public String getRazonSocialComprador() {
			return this.razonSocialComprador;
		}

		public void setRazonSocialComprador(String value) {
			this.razonSocialComprador = value;
		}

		public String getIdentificacionComprador() {
			return this.identificacionComprador;
		}

		public void setIdentificacionComprador(String value) {
			this.identificacionComprador = value;
		}

		public String getContribuyenteEspecial() {
			return this.contribuyenteEspecial;
		}

		public void setContribuyenteEspecial(String value) {
			this.contribuyenteEspecial = value;
		}

		public String getObligadoContabilidad() {
			return this.obligadoContabilidad;
		}

		public void setObligadoContabilidad(String value) {
			this.obligadoContabilidad = value;
		}

		public String getRise() {
			return this.rise;
		}

		public void setRise(String value) {
			this.rise = value;
		}

		public String getCodDocModificado() {
			return this.codDocModificado;
		}

		public void setCodDocModificado(String value) {
			this.codDocModificado = value;
		}

		public String getNumDocModificado() {
			return this.numDocModificado;
		}

		public void setNumDocModificado(String value) {
			this.numDocModificado = value;
		}

		public String getFechaEmisionDocSustento() {
			return this.fechaEmisionDocSustento;
		}

		public void setFechaEmisionDocSustento(String value) {
			this.fechaEmisionDocSustento = value;
		}

		public BigDecimal getTotalSinImpuestos() {
			return this.totalSinImpuestos;
		}

		public void setCompensaciones(compensacion compensaciones) {
			this.compensaciones = compensaciones;
		}

		public compensacion getCompensaciones() {
			return this.compensaciones;
		}

		public void setTotalSinImpuestos(BigDecimal value) {
			this.totalSinImpuestos = value;
		}

		public Pago getPagos() {
			return this.pagos;
		}

		public void setPagos(Pago pago) {
			this.pagos = pago;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "compensacion" })
		public static class compensacion {
			@XmlElement(required = true)
			protected List<detalleCompensaciones> compensacion;

			public List<detalleCompensaciones> getCompensaciones() {
				if (this.compensacion == null) {
					this.compensacion = new ArrayList();
				}
				return this.compensacion;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "codigo", "tarifa", "valor" })
			public static class detalleCompensaciones {
				@XmlElement(required = true)
				protected int codigo;
				@XmlElement(required = true)
				protected int tarifa;
				@XmlElement(required = true)
				protected BigDecimal valor;

				public int getCodigo() {
					return this.codigo;
				}

				public void setCodigo(int value) {
					this.codigo = value;
				}

				public int getTarifa() {
					return this.tarifa;
				}

				public void setTarifa(int value) {
					this.tarifa = value;
				}

				public BigDecimal getValor() {
					return this.valor;
				}

				public void setValor(BigDecimal valor) {
					this.valor = valor;
				}
			}
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "pago" })
		public static class Pago {
			@XmlElement(required = true)
			protected List<DetallePago> pago;

			public List<DetallePago> getPagos() {
				if (this.pago == null) {
					this.pago = new ArrayList();
				}
				return this.pago;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "formaPago", "total", "plazo", "unidadTiempo" })
			public static class DetallePago {
				@XmlElement(required = true)
				protected String formaPago;
				@XmlElement(required = true)
				protected BigDecimal total;
				protected String plazo;
				protected String unidadTiempo;

				public String getFormaPago() {
					return this.formaPago;
				}

				public void setFormaPago(String formaPago) {
					this.formaPago = formaPago;
				}

				public BigDecimal getTotal() {
					return this.total;
				}

				public void setTotal(BigDecimal total) {
					this.total = total;
				}

				public String getPlazo() {
					return this.plazo;
				}

				public void setPlazo(String plazo) {
					this.plazo = plazo;
				}

				public String getUnidadTiempo() {
					return this.unidadTiempo;
				}

				public void setUnidadTiempo(String unidadTiempo) {
					this.unidadTiempo = unidadTiempo;
				}
			}
		}

		public Impuestos getImpuestos() {
			return this.impuestos;
		}

		public void setImpuestos(Impuestos value) {
			this.impuestos = value;
		}

		public BigDecimal getValorTotal() {
			return this.valorTotal;
		}

		public void setValorTotal(BigDecimal value) {
			this.valorTotal = value;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "impuesto" })
		public static class Impuestos {
			@XmlElement(required = true)
			protected List<Impuesto> impuesto;

			public List<Impuesto> getImpuesto() {
				if (this.impuesto == null) {
					this.impuesto = new ArrayList();
				}
				return this.impuesto;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "motivo" })
	public static class Motivos {
		@XmlElement(required = true)
		protected List<Motivo> motivo;

		public List<Motivo> getMotivo() {
			if (this.motivo == null) {
				this.motivo = new ArrayList();
			}
			return this.motivo;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "razon", "valor" })
		public static class Motivo {
			@XmlElement(required = true)
			protected String razon;
			@XmlElement(required = true)
			protected BigDecimal valor;

			public String getRazon() {
				return this.razon;
			}

			public void setRazon(String value) {
				this.razon = value;
			}

			public BigDecimal getValor() {
				return this.valor;
			}

			public void setValor(BigDecimal value) {
				this.valor = value;
			}
		}
	}
}
