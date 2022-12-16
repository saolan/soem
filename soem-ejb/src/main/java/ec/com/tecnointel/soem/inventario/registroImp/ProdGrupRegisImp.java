package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdGrup;
import ec.com.tecnointel.soem.inventario.registroInt.ProdGrupRegisInt;

@Stateless
public class ProdGrupRegisImp extends GestorRegisSoem<ProdGrup> implements ProdGrupRegisInt, Serializable {

	private static final long serialVersionUID = -432348853702846693L;
	
	@Override
	public ProdGrup buscarPorId(Integer id) {

		EntityGraph prodGrupGraph = this.entityManager.getEntityGraph("prodGrup.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodGrupGraph);

		return entityManager.find(ProdGrup.class, id, hints);

	}

}
