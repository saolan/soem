package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.ProvGrupPlanCuen;
import ec.com.tecnointel.soem.ingreso.registroInt.ProvGrupPlanCuenRegisInt;

@Stateless
public class ProvGrupPlanCuenRegisImp extends GestorRegisSoem<ProvGrupPlanCuen>
		implements ProvGrupPlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = -1004622270255979597L;
	
	@Override
	public ProvGrupPlanCuen buscarPorId(Integer id) {

		EntityGraph pgpcGraph = this.entityManager.getEntityGraph("pgpc.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", pgpcGraph);

		return entityManager.find(ProvGrupPlanCuen.class, id, hints);
	}

}
