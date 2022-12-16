package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.tesoreria.modelo.FpmeFormPago;
import ec.com.tecnointel.soem.tesoreria.registroInt.FpmeFormPagoRegisInt;

@Stateless
public class FpmeFormPagoRegisImp extends GestorRegisSoem<FpmeFormPago> implements FpmeFormPagoRegisInt, Serializable {

	private static final long serialVersionUID = -2673794221732225429L;

	@Override
	public FpmeFormPago buscarPorId(Integer id) {

		EntityGraph fpmeFormPagoGraph = this.entityManager.getEntityGraph("fpmeFormPago.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", fpmeFormPagoGraph);

		return entityManager.find(FpmeFormPago.class, id, hints);

	}

}
