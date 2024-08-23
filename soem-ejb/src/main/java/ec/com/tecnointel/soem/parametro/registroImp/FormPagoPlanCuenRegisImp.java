package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.FormPagoPlanCuen;
import ec.com.tecnointel.soem.parametro.registroInt.FormPagoPlanCuenRegisInt;

@Stateless
public class FormPagoPlanCuenRegisImp extends GestorRegisSoem<FormPagoPlanCuen>
		implements FormPagoPlanCuenRegisInt, Serializable {

	private static final long serialVersionUID = -5998316110828766079L;

	@Override
	public FormPagoPlanCuen buscarPorId(Integer id) {

		EntityGraph fppcGraph = this.entityManager.getEntityGraph("fppc.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", fppcGraph);

		return entityManager.find(FormPagoPlanCuen.class, id, hints);
	}
}
