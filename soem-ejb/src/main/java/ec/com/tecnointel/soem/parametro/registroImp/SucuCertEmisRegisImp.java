package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.SucuCertEmis;
import ec.com.tecnointel.soem.parametro.registroInt.SucuCertEmisRegisInt;

@Stateless
public class SucuCertEmisRegisImp extends GestorRegisSoem<SucuCertEmis> implements SucuCertEmisRegisInt, Serializable {
	
	private static final long serialVersionUID = 1768360387056858169L;

	@Override
	public SucuCertEmis buscarPorId(Integer id) {

		EntityGraph sucuCertEmisGraph = this.entityManager.getEntityGraph("sucuCertEmis.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", sucuCertEmisGraph);

		return entityManager.find(SucuCertEmis.class, id, hints);
	}
}
