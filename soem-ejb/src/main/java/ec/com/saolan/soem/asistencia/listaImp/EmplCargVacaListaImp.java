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

import ec.com.saolan.soem.asistencia.listaInt.EmplCargVacaListaInt;
import ec.com.saolan.soem.asistencia.modelo.EmplCargVaca;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class EmplCargVacaListaImp extends GestorListaSoem<EmplCargVaca>
		implements
			EmplCargVacaListaInt,
			Serializable {

	private static final long serialVersionUID = -8301141021750543587L;

	@Override
	public List<EmplCargVaca> buscar(EmplCargVaca emplCargVaca, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EmplCargVaca> query = builder
				.createQuery(EmplCargVaca.class);
		Root<EmplCargVaca> emplCargVacaRoot = query.from(EmplCargVaca.class);

		query.orderBy(builder.desc(emplCargVacaRoot.get("emplCargVacaId")));
		TypedQuery<EmplCargVaca> consulta = this.entityManager
				.createQuery(query.select(emplCargVacaRoot).where(
						getSearchPredicates(emplCargVacaRoot, emplCargVaca)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(EmplCargVaca emplCargVaca) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<EmplCargVaca> emplCargVacaRoot = countQuery
				.from(EmplCargVaca.class);

		countQuery = countQuery.select(builder.count(emplCargVacaRoot)).where(
				getSearchPredicates(emplCargVacaRoot, emplCargVaca));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(
			Root<EmplCargVaca> emplCargVacaRoot, EmplCargVaca emplCargVaca) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}