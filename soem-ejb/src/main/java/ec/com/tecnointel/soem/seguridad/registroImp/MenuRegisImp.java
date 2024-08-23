package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.Menu;
import ec.com.tecnointel.soem.seguridad.registroInt.MenuRegisInt;

@Stateless
public class MenuRegisImp extends GestorRegisSoem<Menu> implements MenuRegisInt, Serializable {

	private static final long serialVersionUID = -2794966176314106626L;

	@Override
	public Menu buscarPorId(Integer id) {

		EntityGraph menuGraph = this.entityManager.getEntityGraph("menu.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", menuGraph);

		return entityManager.find(Menu.class, id, hints);

	}
}
