package ec.com.tecnointel.soem.ingreso.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.ingreso.listaInt.RetencionListaInt;
import ec.com.tecnointel.soem.ingreso.modelo.Retencion;

@Stateless
public class RetencionListaImp extends GestorListaSoem<Retencion> implements RetencionListaInt, Serializable {

	private static final long serialVersionUID = -4929515347113141615L;

	// Busca con paginaci�n
	@Override
	public List<Retencion> buscar(Retencion retencion, Integer pagina) {

		EntityGraph retencionGraph = this.entityManager.getEntityGraph("retencion.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Retencion> query = builder.createQuery(Retencion.class);
		Root<Retencion> retencionRoot = query.from(Retencion.class);

		query.orderBy(builder.asc(retencionRoot.get("retencionId")));
		TypedQuery<Retencion> consulta = this.entityManager
				.createQuery(query.select(retencionRoot).where(getSearchPredicates(retencionRoot, retencion)));
		consulta.setHint("javax.persistence.loadgraph", retencionGraph);

		// Si se pasa null a pagina se listan todos los datos de acuerdo a
		// parametros
		// Es decir no realiza paginaci�n
		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		// consulta.setFirstResult(pagina *
		// getFilasPagina()).setMaxResults(getFilasPagina());

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Retencion retencion) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Retencion> retencionRoot = countQuery.from(Retencion.class);

		countQuery = countQuery.select(builder.count(retencionRoot))
				.where(getSearchPredicates(retencionRoot, retencion));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Retencion> retencionRoot, Retencion retencion) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer retencionId = retencion.getRetencionId();
		if (retencionId != null) {
			predicates.add(builder.equal(retencionRoot.get("retencionId"), retencionId));
		}

		Integer ingresoId = retencion.getIngreso().getIngresoId();
		if (ingresoId != null) {
			predicates.add(builder.equal(retencionRoot.get("ingreso").get("ingresoId"), ingresoId));
		}

		Integer RetencionNumero = retencion.getNumero();
		if (RetencionNumero != null) {
			predicates.add(builder.equal(retencionRoot.get("numero"), RetencionNumero));
		}

		Integer facturaNumero = retencion.getIngreso().getNumero();
		if (facturaNumero != null) {
			predicates.add(builder.equal(retencionRoot.get("ingreso").get("numero"), facturaNumero));
		}

		Date fechaEmis = retencion.getFechaEmis();
		if (fechaEmis != null) {
			predicates.add(builder.greaterThanOrEqualTo(retencionRoot.<Date>get("fechaEmis"), fechaEmis));
		}

		String estado = retencion.getEstado();
		if (estado != null) {
			predicates.add(builder.equal(builder.lower(retencionRoot.<String>get("estado")), estado.toLowerCase()));
		}

		String tipoRete = retencion.getIngreso().getDocuIngr().getTipoRete();
		if (tipoRete != null) {
			predicates.add(
					builder.equal(builder.lower(retencionRoot.get("ingreso").get("docuIngr").<String>get("tipoRete")),
							tipoRete.toLowerCase()));
		}

		String estadoDocuElec = retencion.getEstadoDocuElec();
		if (estadoDocuElec != null) {
			predicates.add(builder.notEqual(builder.lower(retencionRoot.<String>get("estadoDocuElec")),
					estadoDocuElec.toLowerCase()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}	
}