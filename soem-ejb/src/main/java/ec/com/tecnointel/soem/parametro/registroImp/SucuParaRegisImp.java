package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.SucuPara;
import ec.com.tecnointel.soem.parametro.registroInt.SucuParaRegisInt;

@Stateless
public class SucuParaRegisImp extends GestorRegisSoem<SucuPara> implements SucuParaRegisInt, Serializable {

	private static final long serialVersionUID = 3590168411353683210L;

	@Override
	public SucuPara buscarPorId(Integer id) {

		EntityGraph sucuParaGraph = this.entityManager.getEntityGraph("sucuPara.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", sucuParaGraph);

		return entityManager.find(SucuPara.class, id, hints);
	}

}
