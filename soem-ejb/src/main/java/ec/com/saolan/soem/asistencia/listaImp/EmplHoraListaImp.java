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

import ec.com.saolan.soem.asistencia.listaInt.EmplHoraListaInt;
import ec.com.saolan.soem.asistencia.modelo.EmplHora;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class EmplHoraListaImp extends GestorListaSoem<EmplHora>
		implements
			EmplHoraListaInt,
			Serializable {

	private static final long serialVersionUID = 520626950058740454L;

	@Override
	public List<EmplHora> buscar(EmplHora emplHora, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EmplHora> query = builder.createQuery(EmplHora.class);
		Root<EmplHora> acciAutoRoot = query.from(EmplHora.class);

		query.orderBy(builder.desc(acciAutoRoot.get("acciAutoId")));
		TypedQuery<EmplHora> consulta = this.entityManager.createQuery(query
				.select(acciAutoRoot).where(
						getSearchPredicates(acciAutoRoot, emplHora)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(EmplHora emplHora) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<EmplHora> acciAutoRoot = countQuery.from(EmplHora.class);

		countQuery = countQuery.select(builder.count(acciAutoRoot)).where(
				getSearchPredicates(acciAutoRoot, emplHora));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<EmplHora> acciAutoRoot,
			EmplHora emplHora) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}