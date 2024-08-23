package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolSucu;
import ec.com.tecnointel.soem.seguridad.registroInt.RolSucuRegisInt;

@Stateless
public class RolSucuRegisImp extends GestorRegisSoem<RolSucu> implements RolSucuRegisInt, Serializable {

	private static final long serialVersionUID = -5372152284470993463L;

	@Override
	public RolSucu buscarPorId(Integer id) {

		EntityGraph rolSucuGraph = this.entityManager.getEntityGraph("rolSucu.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolSucuGraph);

		return entityManager.find(RolSucu.class, id, hints);
	}
}
