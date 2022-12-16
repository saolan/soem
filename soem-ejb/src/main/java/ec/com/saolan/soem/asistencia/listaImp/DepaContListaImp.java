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

import ec.com.saolan.soem.asistencia.listaInt.DepaContListaInt;
import ec.com.saolan.soem.asistencia.modelo.DepaCont;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class DepaContListaImp extends GestorListaSoem<DepaCont>
		implements
			DepaContListaInt,
			Serializable {

	private static final long serialVersionUID = 1666173898490896423L;

	@Override
	public List<DepaCont> buscar(DepaCont depaCont, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DepaCont> query = builder.createQuery(DepaCont.class);
		Root<DepaCont> depaContRoot = query.from(DepaCont.class);

		query.orderBy(builder.desc(depaContRoot.get("depaContId")));
		TypedQuery<DepaCont> consulta = this.entityManager.createQuery(query
				.select(depaContRoot).where(
						getSearchPredicates(depaContRoot, depaCont)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(DepaCont depaCont) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<DepaCont> depaContRoot = countQuery.from(DepaCont.class);

		countQuery = countQuery.select(builder.count(depaContRoot)).where(
				getSearchPredicates(depaContRoot, depaCont));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<DepaCont> depaContRoot,
			DepaCont depaCont) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}