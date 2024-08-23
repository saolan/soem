package ec.com.saolan.soem.ws;

import java.time.LocalDate;

public class ProductoWs {

	private Integer id;
	private String codigo;
	private String nombre;
	private LocalDate fechaCrea;
	private boolean estado;

	public ProductoWs() {
	}

	public ProductoWs(Integer id, String nombre, String codigo, LocalDate fechaCrea, boolean estado) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCrea = fechaCrea;
		this.estado = estado;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaCrea() {
		return fechaCrea;
	}

	public void setFechaCrea(LocalDate fechaCrea) {
		this.fechaCrea = fechaCrea;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
