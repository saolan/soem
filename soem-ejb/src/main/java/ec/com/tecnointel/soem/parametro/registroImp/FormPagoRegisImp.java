package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.FormPago;
import ec.com.tecnointel.soem.parametro.registroInt.FormPagoRegisInt;

@Stateless
public class FormPagoRegisImp extends GestorRegisSoem<FormPago> implements FormPagoRegisInt, Serializable {

	private static final long serialVersionUID = 873507002642788633L;

	@Override
	public FormPago buscarPorId(Integer id) {

		EntityGraph formPagoGraph = this.entityManager.getEntityGraph("formPago.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", formPagoGraph);

		return entityManager.find(FormPago.class, id, hints);

	}
	
}
