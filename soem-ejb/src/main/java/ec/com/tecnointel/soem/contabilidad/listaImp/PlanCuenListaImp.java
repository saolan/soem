package ec.com.tecnointel.soem.contabilidad.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.contabilidad.listaInt.PlanCuenListaInt;
import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuen;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class PlanCuenListaImp extends GestorListaSoem<PlanCuen> implements PlanCuenListaInt, Serializable {

	private static final long serialVersionUID = -7158003147567640434L;

	// Busca con paginaci�n
	@Override
	public List<PlanCuen> buscar(PlanCuen planCuen, Integer pagina) {
		
		EntityGraph planCuenGraph = this.entityManager.getEntityGraph("planCuen.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<PlanCuen> query = builder.createQuery(PlanCuen.class);
		Root<PlanCuen> planCuenRoot = query.from(PlanCuen.class);

		query.orderBy(builder.asc(planCuenRoot.get("codigo")));
		TypedQuery<PlanCuen> consulta = this.entityManager
				.createQuery(query.select(planCuenRoot).where(getSearchPredicates(planCuenRoot, planCuen)));
		consulta.setHint("javax.persistence.loadgraph", planCuenGraph);

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
	public long contarRegistros(PlanCuen planCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<PlanCuen> planCuenRoot = countQuery.from(PlanCuen.class);

		countQuery = countQuery.select(builder.count(planCuenRoot)).where(getSearchPredicates(planCuenRoot, planCuen));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<PlanCuen> planCuenRoot, PlanCuen planCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		String codigo = planCuen.getCodigo();
		if (codigo != null) {
//			predicates.add(builder.equal(planCuenRoot.get("codigo"), codigo));
			
			predicates.add(builder.like(builder.lower(planCuenRoot.<String>get("codigo")), codigo.toLowerCase()));
		}

		String descri = planCuen.getDescri();
		if (descri != null && !"".equals(descri)) {
			predicates.add(builder.like(builder.lower(planCuenRoot.<String>get("descri")),
					'%' + descri.toLowerCase() + '%'));
		}

		Boolean detall = planCuen.getDetall();
		if (detall != null) {
			predicates.add(builder.equal(planCuenRoot.get("detall"), detall));	
		}
		
		boolean estado = planCuen.isEstado();
		predicates.add(builder.equal(planCuenRoot.get("estado"), estado));


		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public void imprimir(PlanCuen planCuen) throws Exception {
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}