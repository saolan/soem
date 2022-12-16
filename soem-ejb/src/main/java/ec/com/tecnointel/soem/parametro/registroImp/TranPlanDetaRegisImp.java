package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.TranPlanDeta;
import ec.com.tecnointel.soem.parametro.registroInt.TranPlanDetaRegisInt;

@Stateless
public class TranPlanDetaRegisImp extends GestorRegisSoem<TranPlanDeta> implements TranPlanDetaRegisInt, Serializable {

	private static final long serialVersionUID = -1661953311350803820L;
	
	@Override
	public TranPlanDeta buscarPorId(Integer id) {

		EntityGraph tranPlanDetaGraph = this.entityManager.getEntityGraph("tranPlanDeta.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", tranPlanDetaGraph);

		return entityManager.find(TranPlanDeta.class, id, hints);
	}

}
