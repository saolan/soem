package ec.com.tecnointel.soem.seguridad.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.seguridad.listaInt.RolSucuListaInt;
import ec.com.tecnointel.soem.seguridad.modelo.RolPersUsua;
import ec.com.tecnointel.soem.seguridad.modelo.RolSucu;

@Stateless
public class RolSucuListaImp extends GestorListaSoem<RolSucu> implements RolSucuListaInt, Serializable {

	private static final long serialVersionUID = -7197102924741157322L;

	// Busca con paginaci�n
	@Override
	public List<RolSucu> buscar(RolSucu rolSucu, Integer pagina) {

		EntityGraph rolSucuGraph = this.entityManager.getEntityGraph("rolSucu.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RolSucu> query = builder.createQuery(RolSucu.class);
		Root<RolSucu> rolSucuRoot = query.from(RolSucu.class);

		query.orderBy(builder.asc(rolSucuRoot.get("rolSucuId")));
		TypedQuery<RolSucu> consulta = this.entityManager
				.createQuery(query.select(rolSucuRoot).where(getSearchPredicates(rolSucuRoot, rolSucu)));
		consulta.setHint("javax.persistence.loadgraph", rolSucuGraph);
		
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
	public long contarRegistros(RolSucu rolSucu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<RolSucu> rolSucuRoot = countQuery.from(RolSucu.class);

		countQuery = countQuery.select(builder.count(rolSucuRoot)).where(getSearchPredicates(rolSucuRoot, rolSucu));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<RolSucu> rolSucuRoot, RolSucu rolSucu) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer rolId = rolSucu.getRol().getRolId();
		if (rolId != null) {
			predicates.add(builder.equal(rolSucuRoot.get("rol").<Integer> get("rolId"), rolId));
		}

		Integer sucursalId = rolSucu.getSucursal().getSucursalId();
		if (sucursalId != null) {
			predicates.add(builder.equal(rolSucuRoot.get("sucursal").<Integer> get("sucursalId"), sucursalId));
		}
		
		Boolean acceso = rolSucu.getAcceso();
		if(acceso != null){
			predicates.add(builder.equal(rolSucuRoot.get("acceso"), acceso));	
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	@Override
	public List<RolSucu> buscar(Set<RolPersUsua> rolPersUsuas){

		List<Integer> rolIds = new ArrayList<Integer>();
		
		List<Predicate> predicates = new ArrayList<Predicate>();

		EntityGraph rolSucuGraph = this.entityManager.getEntityGraph("rolSucu.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<RolSucu> query = builder.createQuery(RolSucu.class);
		Root<RolSucu> rolSucuRoot = query.from(RolSucu.class);

//		Recorrer rolPersUsua porque se envia la lista como parametro para la clausula IN
		for (RolPersUsua rolPersUsua : rolPersUsuas) {
			
			if (rolPersUsua.getRol().isEstado()){
				
				rolIds.add(rolPersUsua.getRol().getRolId());	
			}
			
		}
				
		if (rolIds.size() != 0) {
			Expression<Integer> sucursalExpression = rolSucuRoot.get("rol").<Integer> get("rolId");
			Predicate sucursalPredicate = sucursalExpression.in(rolIds);
			predicates.add(sucursalPredicate);
		}
		
		predicates.add(builder.equal(rolSucuRoot.get("acceso"), true));
		
		query.orderBy(builder.asc(rolSucuRoot.get("rolSucuId")));
		TypedQuery<RolSucu> consulta = this.entityManager
				.createQuery(query.select(rolSucuRoot).where(predicates.toArray(new Predicate[predicates.size()])));
		consulta.setHint("javax.persistence.loadgraph", rolSucuGraph);

		return consulta.getResultList();

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