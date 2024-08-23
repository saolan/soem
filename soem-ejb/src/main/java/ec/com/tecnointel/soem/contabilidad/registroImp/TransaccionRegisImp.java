package ec.com.tecnointel.soem.contabilidad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.contabilidad.modelo.Transaccion;
import ec.com.tecnointel.soem.contabilidad.registroInt.TransaccionRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class TransaccionRegisImp extends GestorRegisSoem<Transaccion> implements TransaccionRegisInt, Serializable {

	private static final long serialVersionUID = 5160593982555426903L;
	
	@Override
	public Transaccion buscarPorId(Integer id) {

		EntityGraph transaccionGraph = this.entityManager.getEntityGraph("transaccion.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", transaccionGraph);

		return entityManager.find(Transaccion.class, id, hints);
	}
}
