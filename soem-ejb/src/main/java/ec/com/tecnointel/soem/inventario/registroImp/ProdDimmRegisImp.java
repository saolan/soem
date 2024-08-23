package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdDimm;
import ec.com.tecnointel.soem.inventario.registroInt.ProdDimmRegisInt;

@Stateless
public class ProdDimmRegisImp extends GestorRegisSoem<ProdDimm> implements ProdDimmRegisInt, Serializable {

	private static final long serialVersionUID = 760740319031291641L;

	@Override
	public ProdDimm buscarPorId(Integer id) {

		EntityGraph prodDimmGraph = this.entityManager.getEntityGraph("prodDimm.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodDimmGraph);

		return entityManager.find(ProdDimm.class, id, hints);
	}
}
