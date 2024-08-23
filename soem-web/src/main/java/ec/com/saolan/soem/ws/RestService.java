package ec.com.saolan.soem.ws;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.com.tecnointel.soem.inventario.listaInt.ProductoListaInt;
import ec.com.tecnointel.soem.inventario.modelo.ProdGrup;
import ec.com.tecnointel.soem.inventario.modelo.Producto;


//CLase de prueba para implemetacion de un webService

//Se llama asi desde el navegador
//http://localhost:8282/soem-web/resources/MyRestService/sayHello/

@ApplicationPath("/resources")
@Path("/MyRestService")
//Se coloco esta anotacion porque sin esto y al subir a wildfly de 11 para arriba da error
//WELD-001303: No active contexts for scope type javax.enterprise.context.RequestScoped
@ApplicationScoped 
public class RestService extends Application implements Serializable {
	
	private static final long serialVersionUID = 1L;

	List<Producto> productos = new ArrayList<>();
	
	@Inject
	ProductoListaInt productoLista;
	
	@GET
	@Path("/sayHello")
	public String getHelloMsg() {
		return "Hola Mundo";
	}

	@GET
	@Path("/echo")
	public Response echoMsg(@QueryParam("mensaje") String msg) {
		return Response.ok("El mensaje es: " + msg).build();
	}
	
	@GET
	@Path("/productos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<ProductoWs> buscarProductos () {
//	public Response buscarProductos () {
		
		Producto producto = new Producto();
		List<Producto> productos = new ArrayList<>();
		
		List<ProductoWs> productoWss = new ArrayList<>();

		producto.setProdGrup(new ProdGrup());
		producto.setEstado(true);
		
		productoLista.ordenar("descri");
		
		try {
			productos = productoLista.buscar(producto, 1, 12);
			for (Producto producto2 : productos) {
				ProductoWs productoWs = new ProductoWs(producto2.getProductoId(), producto2.getCodigo(), producto2.getDescri(), 
						 producto2.getFechaCrea(), producto2.isEstado());
				
				productoWss.add(productoWs);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productoWss;
		
//		return Response.status(200).entity(productos).build();
	}
}
