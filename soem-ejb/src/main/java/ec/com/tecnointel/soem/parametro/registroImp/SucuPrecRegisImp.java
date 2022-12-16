package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.SucuPrec;
import ec.com.tecnointel.soem.parametro.registroInt.SucuPrecRegisInt;

@Stateless
public class SucuPrecRegisImp extends GestorRegisSoem<SucuPrec> implements SucuPrecRegisInt, Serializable {

	private static final long serialVersionUID = 6018126350441856933L;
	
	@Override
	public SucuPrec buscarPorId(Integer id) {

		EntityGraph sucuPrecGraph = this.entityManager.getEntityGraph("sucuPrec.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", sucuPrecGraph);

		return entityManager.find(SucuPrec.class, id, hints);
	}

}
