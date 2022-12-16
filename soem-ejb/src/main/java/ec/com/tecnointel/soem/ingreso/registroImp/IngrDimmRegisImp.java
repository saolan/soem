package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.IngrDimm;
import ec.com.tecnointel.soem.ingreso.registroInt.IngrDimmRegisInt;

@Stateless
public class IngrDimmRegisImp extends GestorRegisSoem<IngrDimm> implements IngrDimmRegisInt, Serializable {

	private static final long serialVersionUID = -958837722947480104L;

	@Override
	public IngrDimm buscarPorId(Integer id) {

		EntityGraph ingrDimmGraph = this.entityManager.getEntityGraph("ingrDimm.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", ingrDimmGraph);

		return entityManager.find(IngrDimm.class, id, hints);
	}
}
