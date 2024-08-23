package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrupPlanCuen;
import ec.com.tecnointel.soem.egreso.registroInt.ClieGrupPlanCuenRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class ClieGrupPlanCuenRegisImp extends GestorRegisSoem<ClieGrupPlanCuen>
		implements ClieGrupPlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = 7762174013820445425L;

	@Override
	public ClieGrupPlanCuen buscarPorId(Integer id) {

		EntityGraph cgpcGraph = this.entityManager.getEntityGraph("cgpc.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cgpcGraph);

		return entityManager.find(ClieGrupPlanCuen.class, id, hints);
	}
}
