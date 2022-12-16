package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.Retencion;
import ec.com.tecnointel.soem.ingreso.registroInt.RetencionRegisInt;

@Stateless
public class RetencionRegisImp extends GestorRegisSoem<Retencion> implements RetencionRegisInt, Serializable {

	private static final long serialVersionUID = -7825411996002170188L;

	@Override
	public Retencion buscarPorId(Integer id) {

		EntityGraph retencionGraph = this.entityManager.getEntityGraph("retencion.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", retencionGraph);

		return entityManager.find(Retencion.class, id, hints);

	}
}
