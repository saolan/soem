package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.PersProvDimm;
import ec.com.tecnointel.soem.ingreso.registroInt.PersProvDimmRegisInt;

@Stateless
public class PersProvDimmRegisImp extends GestorRegisSoem<PersProvDimm> implements PersProvDimmRegisInt, Serializable {

	private static final long serialVersionUID = -6626078583101526018L;

	@Override
	public PersProvDimm buscarPorId(Integer id) {

		EntityGraph persProvDimmGraph = this.entityManager.getEntityGraph("persProvDimm.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", persProvDimmGraph);

		return entityManager.find(PersProvDimm.class, id, hints);
	}
}
