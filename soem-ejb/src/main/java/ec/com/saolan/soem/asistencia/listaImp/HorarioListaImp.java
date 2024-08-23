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

import ec.com.saolan.soem.asistencia.listaInt.HorarioListaInt;
import ec.com.saolan.soem.asistencia.modelo.Horario;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class HorarioListaImp extends GestorListaSoem<Horario>
		implements
			HorarioListaInt,
			Serializable {

	private static final long serialVersionUID = -6156135480836587063L;

	@Override
	public List<Horario> buscar(Horario horario, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Horario> query = builder.createQuery(Horario.class);
		Root<Horario> horarioRoot = query.from(Horario.class);

		query.orderBy(builder.desc(horarioRoot.get("horarioId")));
		TypedQuery<Horario> consulta = this.entityManager.createQuery(query
				.select(horarioRoot).where(
						getSearchPredicates(horarioRoot, horario)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Horario horario) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Horario> horarioRoot = countQuery.from(Horario.class);

		countQuery = countQuery.select(builder.count(horarioRoot)).where(
				getSearchPredicates(horarioRoot, horario));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Horario> horarioRoot,
			Horario horario) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}