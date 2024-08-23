package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolBode;
import ec.com.tecnointel.soem.seguridad.registroInt.RolBodeRegisInt;

@Stateless
public class RolBodeRegisImp extends GestorRegisSoem<RolBode> implements RolBodeRegisInt, Serializable {

	private static final long serialVersionUID = -9146363225131347105L;

	@Override
	public RolBode buscarPorId(Integer id) {

		EntityGraph rolBodeGraph = this.entityManager.getEntityGraph("rolBode.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolBodeGraph);

		return entityManager.find(RolBode.class, id, hints);
	}
}
