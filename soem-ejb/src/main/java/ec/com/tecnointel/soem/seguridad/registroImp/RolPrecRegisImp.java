package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolPrec;
import ec.com.tecnointel.soem.seguridad.registroInt.RolPrecRegisInt;

@Stateless
public class RolPrecRegisImp extends GestorRegisSoem<RolPrec> implements RolPrecRegisInt, Serializable {

	private static final long serialVersionUID = -3780493890373122967L;

	@Override
	public RolPrec buscarPorId(Integer id) {

		EntityGraph rolPrecGraph = this.entityManager.getEntityGraph("rolPrec.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolPrecGraph);

		return entityManager.find(RolPrec.class, id, hints);
	}
	
}
