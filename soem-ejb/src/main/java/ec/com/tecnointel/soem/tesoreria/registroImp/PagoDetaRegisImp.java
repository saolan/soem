package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.tesoreria.modelo.PagoDeta;
import ec.com.tecnointel.soem.tesoreria.registroInt.PagoDetaRegisInt;

@Stateless
public class PagoDetaRegisImp extends GestorRegisSoem<PagoDeta> implements PagoDetaRegisInt, Serializable {

	private static final long serialVersionUID = 7085832508510161713L;
	
	@Override
	public PagoDeta buscarPorId(Integer id) {

		EntityGraph pagoDetaGraph = this.entityManager.getEntityGraph("pagoDeta.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", pagoDetaGraph);

		return entityManager.find(PagoDeta.class, id, hints);

	}

}
