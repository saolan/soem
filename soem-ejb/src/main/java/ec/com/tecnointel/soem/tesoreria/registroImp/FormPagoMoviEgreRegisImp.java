package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.Query;

import ec.com.tecnointel.soem.caja.modelo.CajaMovi;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.tesoreria.modelo.FormPagoMoviEgre;
import ec.com.tecnointel.soem.tesoreria.registroInt.FormPagoMoviEgreRegisInt;

@Stateless
public class FormPagoMoviEgreRegisImp extends GestorRegisSoem<FormPagoMoviEgre>
		implements FormPagoMoviEgreRegisInt, Serializable {

	private static final long serialVersionUID = 3213572488249516570L;
	
	@Override
	public FormPagoMoviEgre buscarPorId(Integer id) {

		EntityGraph fpmeGraph = this.entityManager.getEntityGraph("fpme.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", fpmeGraph);

		return entityManager.find(FormPagoMoviEgre.class, id, hints);

	}

	@Override
	public Integer actualizarFpme(CajaMovi cajaMovi, Integer transaccionId) {
		
		String updateFpme = "update form_pago_movi_egre fpme set transaccion_id = ?1 where fpme.caja_movi_id = ?2";
		
		Query query = (Query) this.entityManager.createNativeQuery(updateFpme);
		
		query.setParameter(1, transaccionId);
		query.setParameter(2, cajaMovi.getCajaMoviId());
		return query.executeUpdate();
		
	}
	
	@Override
	public List<Object[]> buscarFpmeRefere(String refere) throws Exception {
		
		StringBuilder sentencia = new StringBuilder();
		sentencia.append("select numero as numero, fecha as fecha from form_pago_movi_egre where lower(refere) = ?1");
		
		Query query = (Query) this.entityManager.createNativeQuery(sentencia.toString());
		query.setParameter(1, refere.toLowerCase());
		
		return query.getResultList();
	}

}
