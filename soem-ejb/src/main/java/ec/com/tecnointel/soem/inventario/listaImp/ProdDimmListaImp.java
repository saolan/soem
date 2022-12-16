package ec.com.tecnointel.soem.inventario.listaImp;

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
import ec.com.tecnointel.soem.inventario.listaInt.ProdDimmListaInt;
import ec.com.tecnointel.soem.inventario.modelo.ProdDimm;

@Stateless
public class ProdDimmListaImp extends GestorListaSoem<ProdDimm> implements ProdDimmListaInt, Serializable {

	private static final long serialVersionUID = -6463955212882454682L;

	// Busca con paginaci�n
	@Override
	public List<ProdDimm> buscar(ProdDimm prodDimm, Integer pagina) {

		EntityGraph prodDimmGraph = this.entityManager.getEntityGraph("prodDimm.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ProdDimm> query = builder.createQuery(ProdDimm.class);
		Root<ProdDimm> prodDimmRoot = query.from(ProdDimm.class);

		query.orderBy(builder.asc(prodDimmRoot.get("prodDimmId")));
		TypedQuery<ProdDimm> consulta = this.entityManager
				.createQuery(query.select(prodDimmRoot).where(getSearchPredicates(prodDimmRoot, prodDimm)));
		consulta.setHint("javax.persistence.loadgraph", prodDimmGraph);

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(ProdDimm prodDimm) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<ProdDimm> prodDimmRoot = countQuery.from(ProdDimm.class);

		countQuery = countQuery.select(builder.count(prodDimmRoot)).where(getSearchPredicates(prodDimmRoot, prodDimm));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<ProdDimm> prodDimmRoot, ProdDimm prodDimm) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer productoId = prodDimm.getProducto().getProductoId();
		if (productoId != null) {
			predicates.add(builder.equal(prodDimmRoot.get("producto").get("productoId"), productoId));
		}
		
		Integer dimmId = prodDimm.getDimm().getDimmId();
		if (dimmId != null) {
			predicates.add(builder.equal(prodDimmRoot.get("dimm").<Integer> get("dimmId"), dimmId));
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