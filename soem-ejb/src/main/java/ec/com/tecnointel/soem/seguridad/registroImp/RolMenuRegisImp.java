package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolMenu;
import ec.com.tecnointel.soem.seguridad.registroInt.RolMenuRegisInt;

@Stateless
public class RolMenuRegisImp extends GestorRegisSoem<RolMenu> implements RolMenuRegisInt, Serializable {

	private static final long serialVersionUID = -1357502943763959564L;

	@Override
	public RolMenu buscarPorId(Integer id) {

		EntityGraph rolMenuGraph = this.entityManager.getEntityGraph("rolMenu.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolMenuGraph);

		return entityManager.find(RolMenu.class, id, hints);
	}
}
