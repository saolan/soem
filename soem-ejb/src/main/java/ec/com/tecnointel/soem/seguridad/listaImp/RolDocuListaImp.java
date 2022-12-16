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
import ec.com.tecnointel.soem.seguridad.listaInt.RolDocuListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.RolDocu;

@Stateless
public class RolDocuListaImp extends GestorListaSoem<RolDocu> implements RolDocuListaInt, Serializable {

	private static final long serialVersionUID = -7222961182005707513L;

	@Override
	public List<RolDocu> buscar(RolDocu rolDocu, Integer pagina) {

		EntityGraph rolDocuGraph = this.entityManager.getEntityGraph("rolDocu.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RolDocu> query = builder.createQuery(RolDocu.class);
		Root<RolDocu> rolDocuRoot = query.from(RolDocu.class);

		query.orderBy(builder.asc(rolDocuRoot.get("rolDocuId")));
		TypedQuery<RolDocu> consulta = this.entityManager
				.createQuery(query.select(rolDocuRoot).where(getSearchPredicates(rolDocuRoot, rolDocu)));
		consulta.setHint("javax.persistence.loadgraph", rolDocuGraph);
		
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
	public long contarRegistros(RolDocu rolDocu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<RolDocu> rolDocuRoot = countQuery.from(RolDocu.class);

		countQuery = countQuery.select(builder.count(rolDocuRoot)).where(getSearchPredicates(rolDocuRoot, rolDocu));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<RolDocu> rolDocuRoot, RolDocu rolDocu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer rolId = rolDocu.getRol().getRolId();
		if (rolId != null) {
			predicates.add(builder.equal(rolDocuRoot.get("rol").<Integer> get("rolId"), rolId));
		}

		Integer documentoId = rolDocu.getDocumento().getDocumentoId();
		if (documentoId != null) {
			predicates.add(builder.equal(rolDocuRoot.get("documento").<Integer> get("documentoId"), documentoId));
		}

		Boolean acceso = rolDocu.getAcceso();
		if(acceso != null){
			predicates.add(builder.equal(rolDocuRoot.get("acceso"), acceso));	
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public void imprimir(RolDocu rolDocu) throws Exception {
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