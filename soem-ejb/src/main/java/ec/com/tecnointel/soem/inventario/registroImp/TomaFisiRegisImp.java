package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.TomaFisi;
import ec.com.tecnointel.soem.inventario.registroInt.TomaFisiRegisInt;

@Stateless
public class TomaFisiRegisImp extends GestorRegisSoem<TomaFisi> implements TomaFisiRegisInt, Serializable {

	private static final long serialVersionUID = 6142923179197833887L;

	@Override
	public TomaFisi buscarPorId(Integer id) {

		EntityGraph tomaFisiGraph = this.entityManager.getEntityGraph("tomaFisi.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", tomaFisiGraph);

		return entityManager.find(TomaFisi.class, id, hints);

	}
}
