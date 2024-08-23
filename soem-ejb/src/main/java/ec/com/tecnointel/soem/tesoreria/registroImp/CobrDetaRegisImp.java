package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.tesoreria.modelo.CobrDeta;
import ec.com.tecnointel.soem.tesoreria.registroInt.CobrDetaRegisInt;

@Stateless
public class CobrDetaRegisImp extends GestorRegisSoem<CobrDeta> implements CobrDetaRegisInt, Serializable {

	private static final long serialVersionUID = -6363115891259494253L;
	
	@Override
	public CobrDeta buscarPorId(Integer id) {

		EntityGraph cobrDetaGraph = this.entityManager.getEntityGraph("cobrDeta.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cobrDetaGraph);

		return entityManager.find(CobrDeta.class, id, hints);

	}

}
