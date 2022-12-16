package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuEgre;
import ec.com.tecnointel.soem.parametro.registroInt.DocuEgreRegisInt;

@Stateless
public class DocuEgreRegisImp extends GestorRegisSoem<DocuEgre> implements DocuEgreRegisInt, Serializable {

	private static final long serialVersionUID = 5847494188544016535L;

	@Override
	public DocuEgre buscarPorId(Integer id) {

		EntityGraph egreDetaGraph = this.entityManager.getEntityGraph("docuEgre.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", egreDetaGraph);

		return entityManager.find(DocuEgre.class, id, hints);
	}
}
