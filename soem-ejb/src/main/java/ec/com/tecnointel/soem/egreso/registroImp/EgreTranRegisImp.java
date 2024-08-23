package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.egreso.modelo.EgreTran;
import ec.com.tecnointel.soem.egreso.registroInt.EgreTranRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EgreTranRegisImp extends GestorRegisSoem<EgreTran> implements EgreTranRegisInt, Serializable {

	private static final long serialVersionUID = -3852169885712625730L;

	@Override
	public EgreTran buscarPorId(Integer id) {

		EntityGraph egreTranGraph = this.entityManager.getEntityGraph("egreTran.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", egreTranGraph);

		return entityManager.find(EgreTran.class, id, hints);

	}
}
