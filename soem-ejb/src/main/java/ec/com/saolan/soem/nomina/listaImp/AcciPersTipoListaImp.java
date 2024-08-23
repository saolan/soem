package ec.com.saolan.soem.nomina.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.saolan.soem.nomina.listaInt.AcciPersTipoListaInt;
import ec.com.saolan.soem.nomina.modelo.AcciPersTipo;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class AcciPersTipoListaImp extends GestorListaSoem<AcciPersTipo>
		implements
			AcciPersTipoListaInt,
			Serializable {

	private static final long serialVersionUID = -4248819088363184098L;

	@Override
	public List<AcciPersTipo> buscar(AcciPersTipo acciPersTipo, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<AcciPersTipo> query = builder
				.createQuery(AcciPersTipo.class);
		Root<AcciPersTipo> acciPersTipoRoot = query.from(AcciPersTipo.class);

		query.orderBy(builder.desc(acciPersTipoRoot.get("acciPersTipoId")));
		TypedQuery<AcciPersTipo> consulta = this.entityManager
				.createQuery(query.select(acciPersTipoRoot).where(
						getSearchPredicates(acciPersTipoRoot, acciPersTipo)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(AcciPersTipo acciPersTipo) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<AcciPersTipo> acciPersTipoRoot = countQuery
				.from(AcciPersTipo.class);

		countQuery = countQuery.select(builder.count(acciPersTipoRoot)).where(
				getSearchPredicates(acciPersTipoRoot, acciPersTipo));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(
			Root<AcciPersTipo> acciPersTipoRoot, AcciPersTipo acciPersTipo) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}