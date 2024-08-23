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

import ec.com.saolan.soem.asistencia.listaInt.KardVacaListaInt;
import ec.com.saolan.soem.asistencia.modelo.KardVaca;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class KardVacaListaImp extends GestorListaSoem<KardVaca>
		implements
			KardVacaListaInt,
			Serializable {

	private static final long serialVersionUID = -2495152565625201239L;

	@Override
	public List<KardVaca> buscar(KardVaca kardVaca, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<KardVaca> query = builder.createQuery(KardVaca.class);
		Root<KardVaca> kardVacaRoot = query.from(KardVaca.class);

		query.orderBy(builder.desc(kardVacaRoot.get("kardVacaId")));
		TypedQuery<KardVaca> consulta = this.entityManager.createQuery(query
				.select(kardVacaRoot).where(
						getSearchPredicates(kardVacaRoot, kardVaca)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(KardVaca kardVaca) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<KardVaca> kardVacaRoot = countQuery.from(KardVaca.class);

		countQuery = countQuery.select(builder.count(kardVacaRoot)).where(
				getSearchPredicates(kardVacaRoot, kardVaca));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<KardVaca> kardVacaRoot,
			KardVaca kardVaca) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}