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

import ec.com.saolan.soem.asistencia.listaInt.EmplDiscListaInt;
import ec.com.saolan.soem.asistencia.modelo.EmplDisc;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class EmplDiscListaImp extends GestorListaSoem<EmplDisc>
		implements
			EmplDiscListaInt,
			Serializable {

	private static final long serialVersionUID = -3409414911277047559L;

	@Override
	public List<EmplDisc> buscar(EmplDisc emplDisc, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EmplDisc> query = builder.createQuery(EmplDisc.class);
		Root<EmplDisc> emplDiscRoot = query.from(EmplDisc.class);

		query.orderBy(builder.desc(emplDiscRoot.get("emplDiscId")));
		TypedQuery<EmplDisc> consulta = this.entityManager.createQuery(query
				.select(emplDiscRoot).where(
						getSearchPredicates(emplDiscRoot, emplDisc)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(EmplDisc emplDisc) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<EmplDisc> emplDiscRoot = countQuery.from(EmplDisc.class);

		countQuery = countQuery.select(builder.count(emplDiscRoot)).where(
				getSearchPredicates(emplDiscRoot, emplDisc));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<EmplDisc> emplDiscRoot,
			EmplDisc emplDisc) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}