package ec.com.tecnointel.soem.seguridad.listaImp;

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
import ec.com.tecnointel.soem.seguridad.listaInt.RolFormPagoListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.RolFormPago;

@Stateless
public class RolFormPagoListaImp extends GestorListaSoem<RolFormPago> implements RolFormPagoListaInt, Serializable {

	private static final long serialVersionUID = 4793284354152926718L;

	@Override
	public List<RolFormPago> buscar(RolFormPago rolFormPago, Integer pagina) {

		EntityGraph rolFormPagoGraph = this.entityManager.getEntityGraph("rolFormPago.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RolFormPago> query = builder.createQuery(RolFormPago.class);
		Root<RolFormPago> rolFormPagoRoot = query.from(RolFormPago.class);

		query.orderBy(builder.asc(rolFormPagoRoot.get("rolFormPagoId")));
		TypedQuery<RolFormPago> consulta = this.entityManager
				.createQuery(query.select(rolFormPagoRoot).where(getSearchPredicates(rolFormPagoRoot, rolFormPago)));
		consulta.setHint("javax.persistence.loadgraph", rolFormPagoGraph);
		
		// Si se pasa null a pagina se listan todos los datos de acuerdo a
		// parametros
		// Es decir no realiza paginaci�n
		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		// consulta.setFirstResult(pagina *
		// getFilasPagina()).setMaxResults(getFilasPagina());

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(RolFormPago rolFormPago) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<RolFormPago> rolFormPagoRoot = countQuery.from(RolFormPago.class);

		countQuery = countQuery.select(builder.count(rolFormPagoRoot))
				.where(getSearchPredicates(rolFormPagoRoot, rolFormPago));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<RolFormPago> rolFormPagoRoot, RolFormPago rolFormPago) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer rolId = rolFormPago.getRol().getRolId();
		if (rolId != null) {
			predicates.add(builder.equal(rolFormPagoRoot.get("rol").<Integer> get("rolId"), rolId));
		}

		Integer formPagoId = rolFormPago.getFormPago().getFormPagoId();
		if (formPagoId != null) {
			predicates.add(builder.equal(rolFormPagoRoot.get("formPago").<Integer> get("formPagoId"), formPagoId));
		}

		Boolean acceso = rolFormPago.getAcceso();
		if(acceso != null){
			predicates.add(builder.equal(rolFormPagoRoot.get("acceso"), acceso));	
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public void imprimir(RolFormPago rolFormPago) throws Exception {
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