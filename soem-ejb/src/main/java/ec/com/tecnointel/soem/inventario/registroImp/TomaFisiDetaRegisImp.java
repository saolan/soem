package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.TomaFisiDeta;
import ec.com.tecnointel.soem.inventario.registroInt.TomaFisiDetaRegisInt;

@Stateless
public class TomaFisiDetaRegisImp extends GestorRegisSoem<TomaFisiDeta> implements TomaFisiDetaRegisInt, Serializable {

	private static final long serialVersionUID = 293502834804344918L;

//	@Override
//	public TomaFisiDeta buscarPorId(Integer id) {
//
//		EntityGraph productoGraph = this.entityManager.getEntityGraph("tomaFisiDeta.Graph");
//		Map hints = new HashMap();
//		hints.put("javax.persistence.loadgraph", productoGraph);
//
//		return entityManager.find(TomaFisiDeta.class, id, hints);
//
//	}

}
