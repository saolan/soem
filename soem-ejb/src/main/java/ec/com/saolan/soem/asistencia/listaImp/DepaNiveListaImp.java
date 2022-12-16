package ec.com.saolan.soem.asistencia.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.saolan.soem.asistencia.listaInt.DepaNiveListaInt;
import ec.com.saolan.soem.asistencia.modelo.DepaNive;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class DepaNiveListaImp extends GestorListaSoem<DepaNive>
		implements
			DepaNiveListaInt,
			Serializable {

	private static final long serialVersionUID = 6948562812917426587L;

	@Override
	public List<DepaNive> buscar(DepaNive depaNive, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DepaNive> query = builder.createQuery(DepaNive.class);
		Root<DepaNive> depaNiveRoot = query.from(DepaNive.class);

		query.orderBy(builder.desc(depaNiveRoot.get("depaNiveId")));
		TypedQuery<DepaNive> consulta = this.entityManager.createQuery(query
				.select(depaNiveRoot).where(
						getSearchPredicates(depaNiveRoot, depaNive)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(DepaNive depaNive) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<DepaNive> depaNiveRoot = countQuery.from(DepaNive.class);

		countQuery = countQuery.select(builder.count(depaNiveRoot)).where(
				getSearchPredicates(depaNiveRoot, depaNive));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<DepaNive> depaNiveRoot,
			DepaNive depaNive) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		String descri = depaNive.getDescri();
		if (descri != null && !"".equals(descri)) {
			predicates.add(
					builder.like(builder.lower(depaNiveRoot.<String>get("descri")), '%' + descri.toLowerCase() + '%'));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}