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

import ec.com.saolan.soem.asistencia.listaInt.AsisRegiListaInt;
import ec.com.saolan.soem.asistencia.modelo.AsisRegi;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class AsisRegiListaImp extends GestorListaSoem<AsisRegi>
		implements
			AsisRegiListaInt,
			Serializable {

	private static final long serialVersionUID = -7893614569259578395L;

	@Override
	public List<AsisRegi> buscar(AsisRegi asisRegi, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<AsisRegi> query = builder.createQuery(AsisRegi.class);
		Root<AsisRegi> asisRegiRoot = query.from(AsisRegi.class);

		query.orderBy(builder.desc(asisRegiRoot.get("asisRegiId")));
		TypedQuery<AsisRegi> consulta = this.entityManager.createQuery(query
				.select(asisRegiRoot).where(
						getSearchPredicates(asisRegiRoot, asisRegi)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(AsisRegi asisRegi) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<AsisRegi> asisRegiRoot = countQuery.from(AsisRegi.class);

		countQuery = countQuery.select(builder.count(asisRegiRoot)).where(
				getSearchPredicates(asisRegiRoot, asisRegi));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<AsisRegi> asisRegiRoot,
			AsisRegi asisRegi) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}