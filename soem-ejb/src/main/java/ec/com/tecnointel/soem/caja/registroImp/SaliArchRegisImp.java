package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.SaliArch;
import ec.com.tecnointel.soem.caja.registroInt.SaliArchRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class SaliArchRegisImp extends GestorRegisSoem<SaliArch> implements SaliArchRegisInt, Serializable {

	private static final long serialVersionUID = -5972995989656573410L;

	@Override
	public SaliArch buscarPorId(Integer id) {

		EntityGraph saliArchGraph = this.entityManager.getEntityGraph("saliArch.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", saliArchGraph);

		return entityManager.find(SaliArch.class, id, hints);
	}
}