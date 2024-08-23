package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Sucursal;
import ec.com.tecnointel.soem.parametro.registroInt.SucursalRegisInt;

@Stateless
public class SucursalRegisImp extends GestorRegisSoem<Sucursal> implements SucursalRegisInt, Serializable {

	private static final long serialVersionUID = -6570866476042744317L;
	
	@Override
	public Sucursal buscarPorId(Integer id) {

		EntityGraph sucursalGraph = this.entityManager.getEntityGraph("sucursal.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", sucursalGraph);

		return entityManager.find(Sucursal.class, id, hints);

	}

}
