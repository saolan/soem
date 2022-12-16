package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdSubp;
import ec.com.tecnointel.soem.inventario.registroInt.ProdSubpRegisInt;

@Stateless
public class ProdSubpRegisImp extends GestorRegisSoem<ProdSubp> implements ProdSubpRegisInt, Serializable {

	private static final long serialVersionUID = 4293854122493091015L;

	@Override
	public ProdSubp buscarPorId(Integer id) {

		EntityGraph prodSubpGraph = this.entityManager.getEntityGraph("prodSubp.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodSubpGraph);

		return entityManager.find(ProdSubp.class, id, hints);
	}
}
