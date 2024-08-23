package ec.com.tecnointel.soem.ingreso.listaImp;

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

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.ingreso.listaInt.ProvGrupPlanCuenListaInt;
import ec.com.tecnointel.soem.ingreso.modelo.ProvGrupPlanCuen;

@Stateless
public class ProvGrupPlanCuenListaImp extends GestorListaSoem<ProvGrupPlanCuen>
		implements ProvGrupPlanCuenListaInt, Serializable {

	private static final long serialVersionUID = -8479406066802418189L;

	// Busca con paginaci�n
	@Override
	public List<ProvGrupPlanCuen> buscar(ProvGrupPlanCuen provGrupPlanCuen, Integer pagina) {
		
		EntityGraph pgpcGraph = this.entityManager.getEntityGraph("pgpc.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ProvGrupPlanCuen> query = builder.createQuery(ProvGrupPlanCuen.class);
		Root<ProvGrupPlanCuen> provGrupPlanCuenRoot = query.from(ProvGrupPlanCuen.class);

		query.orderBy(builder.asc(provGrupPlanCuenRoot.get("pgpcId")));
		TypedQuery<ProvGrupPlanCuen> consulta = this.entityManager.createQuery(
				query.select(provGrupPlanCuenRoot).where(getSearchPredicates(provGrupPlanCuenRoot, provGrupPlanCuen)));
		consulta.setHint("javax.persistence.loadgraph", pgpcGraph);

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
	public long contarRegistros(ProvGrupPlanCuen provGrupPlanCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<ProvGrupPlanCuen> provGrupPlanCuenRoot = countQuery.from(ProvGrupPlanCuen.class);

		countQuery = countQuery.select(builder.count(provGrupPlanCuenRoot))
				.where(getSearchPredicates(provGrupPlanCuenRoot, provGrupPlanCuen));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<ProvGrupPlanCuen> provGrupPlanCuenRoot,
			ProvGrupPlanCuen provGrupPlanCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer provGrupoId = provGrupPlanCuen.getProvGrup().getProvGrupId();
		if (provGrupoId != null) {
			predicates.add(builder.equal(provGrupPlanCuenRoot.get("provGrup").<Integer> get("provGrupId"), provGrupoId));
		}

		Integer planCuenId = provGrupPlanCuen.getPlanCuen().getPlanCuenId();
		if (planCuenId != null) {
			predicates.add(builder.equal(provGrupPlanCuenRoot.get("planCuen").<Integer> get("planCuentId"), planCuenId));
		}
		
		String tipoTran = provGrupPlanCuen.getTipoTran();
		if (tipoTran != null && !"".equals(tipoTran)) {
			predicates.add(
					builder.like(builder.lower(provGrupPlanCuenRoot.<String>get("tipoTran")), tipoTran.toLowerCase()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public void imprimir(ProvGrupPlanCuen provGrupPlanCuen) throws Exception {
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