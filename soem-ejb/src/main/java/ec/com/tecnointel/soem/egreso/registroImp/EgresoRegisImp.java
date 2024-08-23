package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.egreso.modelo.Egreso;
import ec.com.tecnointel.soem.egreso.registroInt.EgresoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EgresoRegisImp extends GestorRegisSoem<Egreso> implements EgresoRegisInt, Serializable {

	private static final long serialVersionUID = 1654009923625360836L;

	@Override
	public Egreso buscarPorId(Integer id) {

		EntityGraph egresoGraph = this.entityManager.getEntityGraph("egreso.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", egresoGraph);

		return entityManager.find(Egreso.class, id, hints);

	}
}
