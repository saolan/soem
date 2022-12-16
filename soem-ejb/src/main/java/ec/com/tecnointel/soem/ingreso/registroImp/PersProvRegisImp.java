package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.PersProv;
import ec.com.tecnointel.soem.ingreso.registroInt.PersProvRegisInt;

@Stateless
public class PersProvRegisImp extends GestorRegisSoem<PersProv> implements PersProvRegisInt, Serializable {

	private static final long serialVersionUID = 7578625371113401926L;
	
	@Override
	public PersProv buscarPorId(Integer id) {

		EntityGraph persProvGraph = this.entityManager.getEntityGraph("persProv.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", persProvGraph);

		return entityManager.find(PersProv.class, id, hints);
	}

}
