package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.caja.modelo.CajaMoviFormPago;
import ec.com.tecnointel.soem.caja.registroInt.CajaMoviFormPagoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CajaMoviFormPagoRegisImp extends GestorRegisSoem<CajaMoviFormPago>
		implements CajaMoviFormPagoRegisInt, Serializable {

	private static final long serialVersionUID = 6060563913524346394L;

	@Override
	public CajaMoviFormPago buscarPorId(Integer id) {

		EntityGraph cmfpGraph = this.entityManager.getEntityGraph("cmfp.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cmfpGraph);

		return entityManager.find(CajaMoviFormPago.class, id, hints);

	}	
}
