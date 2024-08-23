package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviIngr;
import ec.com.tecnointel.soem.tesoreria.registroInt.FormPagoMoviIngrRegisInt;

@Stateless
public class FormPagoMoviIngrRegisImp extends GestorRegisSoem<FormPagoMoviIngr>
		implements FormPagoMoviIngrRegisInt, Serializable {

	private static final long serialVersionUID = -3349768012732129381L;

	@Override
	public FormPagoMoviIngr buscarPorId(Integer id) {

		EntityGraph fpmiGraph = this.entityManager.getEntityGraph("fpmi.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", fpmiGraph);

		return entityManager.find(FormPagoMoviIngr.class, id, hints);

	}
	
}
