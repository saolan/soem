package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.egreso.modelo.PersClie;
import ec.com.tecnointel.soem.egreso.registroInt.PersClieRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class PersClieRegisImp extends GestorRegisSoem<PersClie> implements PersClieRegisInt, Serializable {

	private static final long serialVersionUID = 5206283204249573359L;

	@Override
	public PersClie buscarPorId(Integer id) {

		EntityGraph persClieGraph = this.entityManager.getEntityGraph("persClie.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", persClieGraph);

		return entityManager.find(PersClie.class, id, hints);
	}
}
