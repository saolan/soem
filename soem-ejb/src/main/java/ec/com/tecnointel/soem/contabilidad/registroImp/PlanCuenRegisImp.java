package ec.com.tecnointel.soem.contabilidad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuen;
import ec.com.tecnointel.soem.contabilidad.registroInt.PlanCuenRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class PlanCuenRegisImp extends GestorRegisSoem<PlanCuen> implements PlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = -2130498751329955375L;

	@Override
	public PlanCuen buscarPorId(Integer id) {

		EntityGraph planCuenGraph = this.entityManager.getEntityGraph("planCuen.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph",planCuenGraph);

		return entityManager.find(PlanCuen.class, id, hints);

	}
}
