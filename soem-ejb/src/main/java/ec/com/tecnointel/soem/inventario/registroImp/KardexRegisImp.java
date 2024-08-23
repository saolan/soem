package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.Kardex;
import ec.com.tecnointel.soem.inventario.registroInt.KardexRegisInt;

@Stateless
public class KardexRegisImp extends GestorRegisSoem<Kardex> implements KardexRegisInt, Serializable {

	private static final long serialVersionUID = -5521921261803334294L;

	// @Override
	// public Producto buscarPorId(Integer id) {
	//
	// EntityGraph productoGraph =
	// this.entityManager.getEntityGraph("producto.Graph");
	// Map hints = new HashMap();
	// hints.put("javax.persistence.loadgraph", productoGraph);
	//
	// return entityManager.find(Producto.class, id, hints);
	//
	// }

}
