package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuIngr;
import ec.com.tecnointel.soem.parametro.registroInt.DocuIngrRegisInt;

@Stateless
public class DocuIngrRegisImp extends GestorRegisSoem<DocuIngr> implements DocuIngrRegisInt, Serializable {

	private static final long serialVersionUID = 460618948089260432L;

	@Override
	public DocuIngr buscarPorId(Integer id) {

		EntityGraph ingrDetaGraph = this.entityManager.getEntityGraph("docuIngr.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", ingrDetaGraph);

		return entityManager.find(DocuIngr.class, id, hints);
	}

}
