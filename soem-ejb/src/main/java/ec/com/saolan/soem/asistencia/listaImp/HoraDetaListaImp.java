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

import ec.com.saolan.soem.asistencia.listaInt.HoraDetaListaInt;
import ec.com.saolan.soem.asistencia.modelo.HoraDeta;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class HoraDetaListaImp extends GestorListaSoem<HoraDeta>
		implements
			HoraDetaListaInt,
			Serializable {

	private static final long serialVersionUID = -4569566624218361826L;

	@Override
	public List<HoraDeta> buscar(HoraDeta horaDeta, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<HoraDeta> query = builder.createQuery(HoraDeta.class);
		Root<HoraDeta> horaDetaRoot = query.from(HoraDeta.class);

		query.orderBy(builder.desc(horaDetaRoot.get("horaDetaId")));
		TypedQuery<HoraDeta> consulta = this.entityManager.createQuery(query
				.select(horaDetaRoot).where(
						getSearchPredicates(horaDetaRoot, horaDeta)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(HoraDeta horaDeta) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<HoraDeta> horaDetaRoot = countQuery.from(HoraDeta.class);

		countQuery = countQuery.select(builder.count(horaDetaRoot)).where(
				getSearchPredicates(horaDetaRoot, horaDeta));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<HoraDeta> horaDetaRoot,
			HoraDeta horaDeta) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}