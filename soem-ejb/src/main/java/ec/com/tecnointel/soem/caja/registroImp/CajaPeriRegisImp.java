package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.CajaPeri;
import ec.com.tecnointel.soem.caja.registroInt.CajaPeriRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaPeriRegisImp extends GestorRegisSoem<CajaPeri> implements CajaPeriRegisInt, Serializable {

	private static final long serialVersionUID = 3947064962590979331L;
	
	@Override
	public CajaPeri buscarPorId(Integer id) {

		EntityGraph cajaPeriGraph = this.entityManager.getEntityGraph("cajaPeri.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cajaPeriGraph);

		return entityManager.find(CajaPeri.class, id, hints);
	}

}
