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

import ec.com.saolan.soem.asistencia.listaInt.PersEmplListaInt;
import ec.com.saolan.soem.asistencia.modelo.PersEmpl;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class PersEmplListaImp extends GestorListaSoem<PersEmpl>
		implements
			PersEmplListaInt,
			Serializable {

	private static final long serialVersionUID = -1218097827946056439L;

	@Override
	public List<PersEmpl> buscar(PersEmpl persEmpl, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<PersEmpl> query = builder.createQuery(PersEmpl.class);
		Root<PersEmpl> persEmplRoot = query.from(PersEmpl.class);

		query.orderBy(builder.desc(persEmplRoot.get("persEmplId")));
		TypedQuery<PersEmpl> consulta = this.entityManager.createQuery(query
				.select(persEmplRoot).where(
						getSearchPredicates(persEmplRoot, persEmpl)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(PersEmpl persEmpl) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<PersEmpl> persEmplRoot = countQuery.from(PersEmpl.class);

		countQuery = countQuery.select(builder.count(persEmplRoot)).where(
				getSearchPredicates(persEmplRoot, persEmpl));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<PersEmpl> persEmplRoot,
			PersEmpl persEmpl) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}