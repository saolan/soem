package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviTran;
import ec.com.tecnointel.soem.caja.registroInt.CajaMoviTranRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaMoviTranRegisImp extends GestorRegisSoem<CajaMoviTran> implements CajaMoviTranRegisInt, Serializable {

	private static final long serialVersionUID = 6473799087558151348L;

	@Override
	public CajaMoviTran buscarPorId(Integer id) {

		EntityGraph cajaMoviGraph = this.entityManager.getEntityGraph("cajaMoviTran.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cajaMoviGraph);

		return entityManager.find(CajaMoviTran.class, id, hints);

	}
}
