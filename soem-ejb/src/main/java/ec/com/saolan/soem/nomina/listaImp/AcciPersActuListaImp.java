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

import ec.com.saolan.soem.nomina.listaInt.AcciPersActuListaInt;
import ec.com.saolan.soem.nomina.modelo.AcciPersActu;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class AcciPersActuListaImp extends GestorListaSoem<AcciPersActu> implements AcciPersActuListaInt, Serializable {

	private static final long serialVersionUID = -2870007154075625814L;

	@Override
	public List<AcciPersActu> buscar(AcciPersActu acciPersActu, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<AcciPersActu> query = builder.createQuery(AcciPersActu.class);
		Root<AcciPersActu> acciPersActuRoot = query.from(AcciPersActu.class);

		query.orderBy(builder.desc(acciPersActuRoot.get("acciPersActuId")));
		TypedQuery<AcciPersActu> consulta = this.entityManager
				.createQuery(query.select(acciPersActuRoot).where(getSearchPredicates(acciPersActuRoot, acciPersActu)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(AcciPersActu acciPersActu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<AcciPersActu> acciPersActuRoot = countQuery.from(AcciPersActu.class);

		countQuery = countQuery.select(builder.count(acciPersActuRoot))
				.where(getSearchPredicates(acciPersActuRoot, acciPersActu));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<AcciPersActu> acciPersActuRoot, AcciPersActu acciPersActu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}