package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.IngrDeta;
import ec.com.tecnointel.soem.ingreso.registroInt.IngrDetaRegisInt;

@Stateless
public class IngrDetaRegisImp extends GestorRegisSoem<IngrDeta> implements IngrDetaRegisInt, Serializable {

	private static final long serialVersionUID = 2093156576702157475L;

	@Override
	public IngrDeta buscarPorId(Integer id) {

		EntityGraph ingrDetaGraph = this.entityManager.getEntityGraph("ingrDeta.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", ingrDetaGraph);

		return entityManager.find(IngrDeta.class, id, hints);
	}

	// public void eliminar(IngrDeta ingrDeta) {
	// if(this.entityManager.contains(ingrDeta)){
	// this.entityManager.remove(this.entityManager.merge(ingrDeta));
	// }
	//
	// }

}
