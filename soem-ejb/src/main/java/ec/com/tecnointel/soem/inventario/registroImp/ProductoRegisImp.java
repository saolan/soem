package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.Producto;
import ec.com.tecnointel.soem.inventario.registroInt.ProductoRegisInt;

@Stateless
public class ProductoRegisImp extends GestorRegisSoem<Producto> implements ProductoRegisInt, Serializable {

	private static final long serialVersionUID = -1374248277967880746L;
	
	@Override
	public Producto buscarPorId(Integer id) {

		EntityGraph productoGraph = this.entityManager.getEntityGraph("producto.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", productoGraph);

		return entityManager.find(Producto.class, id, hints);

	}

}
