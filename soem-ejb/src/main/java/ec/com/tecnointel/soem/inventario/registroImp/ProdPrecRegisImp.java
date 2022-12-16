package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdPrec;
import ec.com.tecnointel.soem.inventario.registroInt.ProdPrecRegisInt;

@Stateless
public class ProdPrecRegisImp extends GestorRegisSoem<ProdPrec> implements ProdPrecRegisInt, Serializable {

	private static final long serialVersionUID = -4293879033414045431L;

	@Override
	public ProdPrec buscarPorId(Integer id) {

		EntityGraph prodPrecGraph = this.entityManager.getEntityGraph("prodPrec.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodPrecGraph);

		return entityManager.find(ProdPrec.class, id, hints);
	}
}
