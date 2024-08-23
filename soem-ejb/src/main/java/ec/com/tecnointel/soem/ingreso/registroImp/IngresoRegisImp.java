package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;
import ec.com.tecnointel.soem.ingreso.registroInt.IngresoRegisInt;

@Stateless
public class IngresoRegisImp extends GestorRegisSoem<Ingreso> implements IngresoRegisInt, Serializable {

	private static final long serialVersionUID = 1038514296278574711L;

	@Override
	public Ingreso buscarPorId(Integer id) {

		EntityGraph ingresoGraph = this.entityManager.getEntityGraph("ingreso.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", ingresoGraph);

		return entityManager.find(Ingreso.class, id, hints);

	}

}
