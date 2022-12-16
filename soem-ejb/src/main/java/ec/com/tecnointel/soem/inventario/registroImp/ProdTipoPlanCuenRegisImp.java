package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdTipoPlanCuen;
import ec.com.tecnointel.soem.inventario.registroInt.ProdTipoPlanCuenRegisInt;

@Stateless
public class ProdTipoPlanCuenRegisImp extends GestorRegisSoem<ProdTipoPlanCuen>
		implements ProdTipoPlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = 8489166755480731026L;

	@Override
	public ProdTipoPlanCuen buscarPorId(Integer id) {

		EntityGraph ptpcGraph = this.entityManager.getEntityGraph("ptpc.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", ptpcGraph);

		return entityManager.find(ProdTipoPlanCuen.class, id, hints);
	}
}
