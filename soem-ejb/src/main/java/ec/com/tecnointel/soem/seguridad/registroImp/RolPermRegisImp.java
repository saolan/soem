package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolPerm;
import ec.com.tecnointel.soem.seguridad.registroInt.RolPermRegisInt;

@Stateless
public class RolPermRegisImp extends GestorRegisSoem<RolPerm> implements RolPermRegisInt, Serializable {

	private static final long serialVersionUID = 3521469790494172051L;
	
	@Override
	public RolPerm buscarPorId(Integer id) {

		EntityGraph rolPermGraph = this.entityManager.getEntityGraph("rolPerm.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolPermGraph);

		return entityManager.find(RolPerm.class, id, hints);
	}

}
