package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Mapa;
import ec.com.tecnointel.soem.parametro.registroInt.MapaRegisInt;

@Stateless
public class MapaRegisImp extends GestorRegisSoem<Mapa> implements MapaRegisInt, Serializable {

	private static final long serialVersionUID = -2606855759453428356L;
	
	@Override
	public Mapa buscarPorId(Integer id) {

		EntityGraph mapaGraph = this.entityManager.getEntityGraph("mapa.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", mapaGraph);

		return entityManager.find(Mapa.class, id, hints);

	}

}
