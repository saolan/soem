package ec.com.tecnointel.soem.ingreso.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.ingreso.listaInt.PersProvDimmListaInt;
import ec.com.tecnointel.soem.ingreso.modelo.PersProvDimm;

@Stateless
public class PersProvDimmListaImp extends GestorListaSoem<PersProvDimm> implements PersProvDimmListaInt, Serializable {


	private static final long serialVersionUID = -6977493889531397148L;

	// Busca con paginaci�n
	@Override
	public List<PersProvDimm> buscar(PersProvDimm persProvDimm, Integer pagina) {

		EntityGraph persProvDimmGraph = this.entityManager.getEntityGraph("persProvDimm.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<PersProvDimm> query = builder.createQuery(PersProvDimm.class);
		Root<PersProvDimm> persProvDimmRoot = query.from(PersProvDimm.class);

		query.orderBy(builder.asc(persProvDimmRoot.get("persProvDimmId")));
		TypedQuery<PersProvDimm> consulta = this.entityManager
				.createQuery(query.select(persProvDimmRoot).where(getSearchPredicates(persProvDimmRoot, persProvDimm)));
		consulta.setHint("javax.persistence.loadgraph", persProvDimmGraph);

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(PersProvDimm persProvDimm) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<PersProvDimm> persProvDimmRoot = countQuery.from(PersProvDimm.class);

		countQuery = countQuery.select(builder.count(persProvDimmRoot)).where(getSearchPredicates(persProvDimmRoot, persProvDimm));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<PersProvDimm> persProvDimmRoot, PersProvDimm persProvDimm) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer personaId = persProvDimm.getPersProv().getPersonaId();
		if (personaId != null) {
			predicates.add(builder.equal(persProvDimmRoot.get("persProv").get("personaId"), personaId));
		}
		
		Integer dimmId = persProvDimm.getDimm().getDimmId();
		if (dimmId != null) {
			predicates.add(builder.equal(persProvDimmRoot.get("dimm").<Integer> get("dimmId"), dimmId));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}