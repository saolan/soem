package ec.com.tecnointel.soem.parametro.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.parametro.listaInt.MesaListaInt;
import ec.com.tecnointel.soem.parametro.modelo.Mesa;

@Stateless
public class MesaListaImp extends GestorListaSoem<Mesa> implements MesaListaInt, Serializable {

	private static final long serialVersionUID = 5779776152710591456L;

	@Override
	public List<Mesa> buscar(Mesa mesa, Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Mesa> query = builder.createQuery(Mesa.class);
		Root<Mesa> mesaRoot = query.from(Mesa.class);

		query.orderBy(builder.asc(mesaRoot.get("descri")));
		TypedQuery<Mesa> consulta = this.entityManager
				.createQuery(query.select(mesaRoot).where(getSearchPredicates(mesaRoot, mesa)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Mesa mesa) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Mesa> mesaRoot = countQuery.from(Mesa.class);

		countQuery = countQuery.select(builder.count(mesaRoot)).where(getSearchPredicates(mesaRoot, mesa));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Mesa> mesaRoot, Mesa mesa) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer mesaId = mesa.getMesaId();
		if (mesaId != null) {
			predicates.add(builder.equal(mesaRoot.<Integer>get("mesaId"), mesaId));
		}

		String descri = mesa.getDescri();
		if (descri != null && !"".equals(descri)) {
			predicates
					.add(builder.like(builder.lower(mesaRoot.<String>get("descri")), '%' + descri.toLowerCase() + '%'));
		}

		boolean estado = mesa.isEstado();
		predicates.add(builder.equal(mesaRoot.get("estado"), estado));

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