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

import ec.com.saolan.soem.asistencia.listaInt.AusenciaListaInt;
import ec.com.saolan.soem.asistencia.modelo.Ausencia;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class AusenciaListaImp extends GestorListaSoem<Ausencia>
		implements
			AusenciaListaInt,
			Serializable {

	private static final long serialVersionUID = -107007401209790533L;

	@Override
	public List<Ausencia> buscar(Ausencia ausencia, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ausencia> query = builder.createQuery(Ausencia.class);
		Root<Ausencia> ausenciaRoot = query.from(Ausencia.class);

		query.orderBy(builder.desc(ausenciaRoot.get("ausenciaId")));
		TypedQuery<Ausencia> consulta = this.entityManager.createQuery(query
				.select(ausenciaRoot).where(
						getSearchPredicates(ausenciaRoot, ausencia)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Ausencia ausencia) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Ausencia> ausenciaRoot = countQuery.from(Ausencia.class);

		countQuery = countQuery.select(builder.count(ausenciaRoot)).where(
				getSearchPredicates(ausenciaRoot, ausencia));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Ausencia> ausenciaRoot,
			Ausencia ausencia) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}