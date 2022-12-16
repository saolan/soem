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

import ec.com.saolan.soem.asistencia.listaInt.HoraExtrListaInt;
import ec.com.saolan.soem.asistencia.modelo.HoraExtr;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class HoraExtrListaImp extends GestorListaSoem<HoraExtr>
		implements
			HoraExtrListaInt,
			Serializable {

	private static final long serialVersionUID = -2511294529077068613L;

	@Override
	public List<HoraExtr> buscar(HoraExtr horaExtr, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<HoraExtr> query = builder.createQuery(HoraExtr.class);
		Root<HoraExtr> horaExtrRoot = query.from(HoraExtr.class);

		query.orderBy(builder.desc(horaExtrRoot.get("horaExtrId")));
		TypedQuery<HoraExtr> consulta = this.entityManager.createQuery(query
				.select(horaExtrRoot).where(
						getSearchPredicates(horaExtrRoot, horaExtr)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(HoraExtr horaExtr) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<HoraExtr> horaExtrRoot = countQuery.from(HoraExtr.class);

		countQuery = countQuery.select(builder.count(horaExtrRoot)).where(
				getSearchPredicates(horaExtrRoot, horaExtr));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<HoraExtr> horaExtrRoot,
			HoraExtr horaExtr) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}