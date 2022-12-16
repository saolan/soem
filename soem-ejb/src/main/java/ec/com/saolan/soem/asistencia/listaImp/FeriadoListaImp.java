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

import ec.com.saolan.soem.asistencia.listaInt.FeriadoListaInt;
import ec.com.saolan.soem.asistencia.modelo.Feriado;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class FeriadoListaImp extends GestorListaSoem<Feriado>
		implements
			FeriadoListaInt,
			Serializable {

	private static final long serialVersionUID = -9170815135004793407L;

	@Override
	public List<Feriado> buscar(Feriado feriado, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Feriado> query = builder.createQuery(Feriado.class);
		Root<Feriado> feriadoRoot = query.from(Feriado.class);

		query.orderBy(builder.desc(feriadoRoot.get("feriadoId")));
		TypedQuery<Feriado> consulta = this.entityManager.createQuery(query
				.select(feriadoRoot).where(
						getSearchPredicates(feriadoRoot, feriado)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Feriado feriado) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Feriado> feriadoRoot = countQuery.from(Feriado.class);

		countQuery = countQuery.select(builder.count(feriadoRoot)).where(
				getSearchPredicates(feriadoRoot, feriado));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Feriado> feriadoRoot,
			Feriado feriado) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}