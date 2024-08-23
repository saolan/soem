package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolFormPago;
import ec.com.tecnointel.soem.seguridad.registroInt.RolFormPagoRegisInt;

@Stateless
public class RolFormPagoRegisImp extends GestorRegisSoem<RolFormPago> implements RolFormPagoRegisInt, Serializable {

	private static final long serialVersionUID = -679897362885198335L;

	@Override
	public RolFormPago buscarPorId(Integer id) {

		EntityGraph rolFormPagoGraph = this.entityManager.getEntityGraph("rolFormPago.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolFormPagoGraph);

		return entityManager.find(RolFormPago.class, id, hints);
	}
}
