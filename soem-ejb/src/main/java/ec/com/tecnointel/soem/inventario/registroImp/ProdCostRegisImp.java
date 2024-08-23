package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdCost;
import ec.com.tecnointel.soem.inventario.registroInt.ProdCostRegisInt;

@Stateless
public class ProdCostRegisImp extends GestorRegisSoem<ProdCost> implements ProdCostRegisInt, Serializable {

	private static final long serialVersionUID = 6463835989947526616L;

	@Override
	public ProdCost buscarPorId(Integer id) {

		EntityGraph prodCostGraph = this.entityManager.getEntityGraph("prodCost.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodCostGraph);

		return entityManager.find(ProdCost.class, id, hints);
	}
}
