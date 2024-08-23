package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.RolPersUsua;
import ec.com.tecnointel.soem.seguridad.registroInt.RolPersUsuaRegisInt;

@Stateless
public class RolPersUsuaRegisImp extends GestorRegisSoem<RolPersUsua> implements RolPersUsuaRegisInt, Serializable {

	private static final long serialVersionUID = 4863327241104199480L;
	
	@Override
	public RolPersUsua buscarPorId(Integer id) {

		EntityGraph rolPersUsua = this.entityManager.getEntityGraph("rolPersUsua.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", rolPersUsua);

		return entityManager.find(RolPersUsua.class, id, hints);
	}

}
