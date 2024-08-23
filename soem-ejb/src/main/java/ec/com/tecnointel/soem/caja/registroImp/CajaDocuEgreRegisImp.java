package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.CajaDocuEgre;
import ec.com.tecnointel.soem.caja.registroInt.CajaDocuEgreRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaDocuEgreRegisImp extends GestorRegisSoem<CajaDocuEgre> implements CajaDocuEgreRegisInt, Serializable {

	private static final long serialVersionUID = 8983560126509212831L;

	@Override
	public CajaDocuEgre buscarPorId(Integer id) {

		EntityGraph cajaDocuEgreGraph = this.entityManager.getEntityGraph("cajaDocuEgre.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cajaDocuEgreGraph);

		return entityManager.find(CajaDocuEgre.class, id, hints);
	}
}
