package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;
import ec.com.tecnointel.soem.seguridad.registroInt.RolDocuRegisInt;

@Stateless
public class RolDocuRegisImp extends GestorRegisSoem<RolDocu> implements RolDocuRegisInt, Serializable {

	private static final long serialVersionUID = -7086631680899061090L;

	@Override
	public RolDocu buscarPorId(Integer id) {

		EntityGraph rolDocuGraph = this.entityManager.getEntityGraph("rolDocu.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolDocuGraph);

		return entityManager.find(RolDocu.class, id, hints);
	}
}
