package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DimmPlanCuen;
import ec.com.tecnointel.soem.parametro.registroInt.DimmPlanCuenRegisInt;

@Stateless
public class DimmPlanCuenRegisImp extends GestorRegisSoem<DimmPlanCuen>
		implements
			DimmPlanCuenRegisInt,
			Serializable {

	private static final long serialVersionUID = 5147600939652791423L;

	@Override
	public DimmPlanCuen buscarPorId(Integer id) {

		EntityGraph dimmPlanCuenGraph = this.entityManager
				.getEntityGraph("dimmPlanCuen.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", dimmPlanCuenGraph);

		return entityManager.find(DimmPlanCuen.class, id, hints);
	}
}
