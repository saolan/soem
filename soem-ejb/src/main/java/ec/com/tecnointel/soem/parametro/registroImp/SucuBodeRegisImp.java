package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.SucuBode;
import ec.com.tecnointel.soem.parametro.registroInt.SucuBodeRegisInt;

@Stateless
public class SucuBodeRegisImp extends GestorRegisSoem<SucuBode> implements SucuBodeRegisInt, Serializable {

	private static final long serialVersionUID = 7292171729432757134L;
	
	@Override
	public SucuBode buscarPorId(Integer id) {

		EntityGraph sucuBodeGraph = this.entityManager.getEntityGraph("sucuBode.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", sucuBodeGraph);

		return entityManager.find(SucuBode.class, id, hints);
	}

}
