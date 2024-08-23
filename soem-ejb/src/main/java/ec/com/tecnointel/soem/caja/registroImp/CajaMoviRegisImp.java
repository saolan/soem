package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.CajaMovi;
import ec.com.tecnointel.soem.caja.registroInt.CajaMoviRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaMoviRegisImp extends GestorRegisSoem<CajaMovi> implements CajaMoviRegisInt, Serializable {

	private static final long serialVersionUID = 8082718544036401337L;
	
	@Override
	public CajaMovi buscarPorId(Integer id) {

		EntityGraph cajaMoviGraph = this.entityManager.getEntityGraph("cajaMovi.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cajaMoviGraph);

		return entityManager.find(CajaMovi.class, id, hints);

	}	

}
