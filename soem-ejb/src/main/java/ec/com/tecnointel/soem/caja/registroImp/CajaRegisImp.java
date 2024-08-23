package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.Caja;
import ec.com.tecnointel.soem.caja.registroInt.CajaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaRegisImp extends GestorRegisSoem<Caja> implements CajaRegisInt, Serializable {

	private static final long serialVersionUID = 7423700058798842471L;

	@Override
	public Caja buscarPorId(Integer id) {

		EntityGraph cajaGraph = this.entityManager.getEntityGraph("caja.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cajaGraph);

		return entityManager.find(Caja.class, id, hints);

	}
	
//	@Override
//	@Transactional(dontRollbackOn = IllegalArgumentException.class)
//	@Transactional(rollbackOn = IllegalArgumentException.class)
//	public Object insertar(Caja caja) {
//		return entityManager.getEntityManagerFactory().getPersistenceUnitUtil().getIdentifier(caja);
//	}
}
