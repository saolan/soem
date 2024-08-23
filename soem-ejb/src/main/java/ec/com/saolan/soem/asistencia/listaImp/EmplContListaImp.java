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

import ec.com.saolan.soem.asistencia.listaInt.EmplContListaInt;
import ec.com.saolan.soem.asistencia.modelo.EmplCont;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class EmplContListaImp extends GestorListaSoem<EmplCont>
		implements
			EmplContListaInt,
			Serializable {

	private static final long serialVersionUID = -3635581566456011761L;

	@Override
	public List<EmplCont> buscar(EmplCont emplCont, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<EmplCont> query = builder.createQuery(EmplCont.class);
		Root<EmplCont> emplContRoot = query.from(EmplCont.class);

		query.orderBy(builder.desc(emplContRoot.get("emplContId")));
		TypedQuery<EmplCont> consulta = this.entityManager.createQuery(query
				.select(emplContRoot).where(
						getSearchPredicates(emplContRoot, emplCont)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(EmplCont emplCont) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<EmplCont> emplContRoot = countQuery.from(EmplCont.class);

		countQuery = countQuery.select(builder.count(emplContRoot)).where(
				getSearchPredicates(emplContRoot, emplCont));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<EmplCont> emplContRoot,
			EmplCont emplCont) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}