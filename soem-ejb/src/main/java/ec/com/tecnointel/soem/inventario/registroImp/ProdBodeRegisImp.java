package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdBode;
import ec.com.tecnointel.soem.inventario.registroInt.ProdBodeRegisInt;

@Stateless
public class ProdBodeRegisImp extends GestorRegisSoem<ProdBode> implements ProdBodeRegisInt, Serializable {

	private static final long serialVersionUID = -1342171553071588161L;

	@Override
	public ProdBode buscarPorId(Integer id) {

		EntityGraph prodBodeGraph = this.entityManager.getEntityGraph("prodBode.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodBodeGraph);

		return entityManager.find(ProdBode.class, id, hints);
	}
}
