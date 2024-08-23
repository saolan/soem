package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdGrupPlanCuen;
import ec.com.tecnointel.soem.inventario.registroInt.ProdGrupPlanCuenRegisInt;

@Stateless
public class ProdGrupPlanCuenRegisImp extends GestorRegisSoem<ProdGrupPlanCuen>
		implements ProdGrupPlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = 8834008904451460690L;

	@Override
	public ProdGrupPlanCuen buscarPorId(Integer id) {

		EntityGraph prodgpcGraph = this.entityManager.getEntityGraph("prodgpc.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodgpcGraph);

		return entityManager.find(ProdGrupPlanCuen.class, id, hints);
	}
}
