package ec.com.tecnointel.soem.ingreso.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.ingreso.listaInt.IngresoListaInt;
import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;

@Stateless
public class IngresoListaImp extends GestorListaSoem<Ingreso> implements IngresoListaInt, Serializable {

	private static final long serialVersionUID = 6529969720872352365L;

	// Busca con paginaci�n
	@Override
	public List<Ingreso> buscar(Ingreso ingreso, Integer pagina) {

		EntityGraph ingresoGraph = this.entityManager.getEntityGraph("ingreso.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ingreso> query = builder.createQuery(Ingreso.class);
		Root<Ingreso> ingresoRoot = query.from(Ingreso.class);

		if (this.orden.equals("Desc")) {
			query.orderBy(builder.desc(ingresoRoot.get("ingresoId")));
		} else {
			query.orderBy(builder.asc(ingresoRoot.get("ingresoId")));
		}	

		TypedQuery<Ingreso> consulta = this.entityManager
				.createQuery(query.select(ingresoRoot).where(getSearchPredicates(ingresoRoot, ingreso)));
		consulta.setHint("javax.persistence.loadgraph", ingresoGraph);

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Ingreso ingreso) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Ingreso> ingresoRoot = countQuery.from(Ingreso.class);

		countQuery = countQuery.select(builder.count(ingresoRoot)).where(getSearchPredicates(ingresoRoot, ingreso));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Ingreso> ingresoRoot, Ingreso ingreso) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		Integer sucursalId = ingreso.getSucursal().getSucursalId();
		if (sucursalId != null) {
			predicates.add(builder.equal(ingresoRoot.get("sucursal").<Integer> get("sucursalId"), sucursalId));
		}
		
		String cedulaRuc = ingreso.getPersProv().getPersona().getCedulaRuc();
		if (cedulaRuc != null) {
			predicates.add(builder.equal(builder.lower(ingresoRoot.get("persProv").get("persona").<String> get("cedulaRuc")), cedulaRuc.toLowerCase()));
		}
		
		String apelli = ingreso.getPersProv().getPersona().getApelli();
		if (apelli != null) {
			predicates.add(builder.like(builder.lower(ingresoRoot.get("persProv").get("persona").<String> get("apelli")), '%' + apelli.toLowerCase() + '%'));
		}
		
		String nombre = ingreso.getPersProv().getPersona().getNombre();
		if (nombre != null) {
			predicates.add(builder.like(builder.lower(ingresoRoot.get("persProv").get("persona").<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
		}	
		
		String docuIngrDescri = ingreso.getDocuIngr().getDocumento().getDescri();
		if (docuIngrDescri != null) {
			predicates.add(builder.like(builder.lower(ingresoRoot.get("docuIngr").get("documento").<String> get("descri")), '%' + docuIngrDescri.toLowerCase() + '%'));
		}

		String docuEgreDocumeElec = ingreso.getDocuIngr().getDocumeElec();
		if (docuEgreDocumeElec != null) {
			predicates.add(builder.notEqual(builder.lower(ingresoRoot.get("docuIngr").<String> get("documeElec")), docuEgreDocumeElec.toLowerCase()));
		}

		Integer ingresoId = ingreso.getIngresoId();
		if (ingresoId != null) {
			predicates.add(builder.equal(ingresoRoot.get("ingresoId"), ingresoId));
		}

		if (ingreso.getIngreso() != null) {
			Integer ingresoSupeId = ingreso.getIngreso().getIngresoId();
			if (ingresoSupeId != null) {
				predicates.add(builder.equal(ingresoRoot.get("ingreso").get("ingresoId"), ingresoSupeId));
			}
		}

		Integer numero = ingreso.getNumero();
		if (numero != null) {
			predicates.add(builder.equal(ingresoRoot.get("numero"), numero));
		}
		
		Date fechaEmis = ingreso.getFechaEmis();
		if (fechaEmis != null) {
			predicates.add(builder.greaterThanOrEqualTo(ingresoRoot.<Date> get("fechaEmis"), fechaEmis));
		}

		String estadoDocuElec = ingreso.getEstadoDocuElec();
		if (estadoDocuElec != null) {
			predicates.add(builder.notEqual(builder.lower(ingresoRoot.<String> get("estadoDocuElec")), estadoDocuElec.toLowerCase()));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	@Override
	public List<Ingreso> buscarTransaccion(Ingreso ingreso) {

		EntityGraph ingresoGraph = this.entityManager.getEntityGraph("ingreso.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Ingreso> query = builder.createQuery(Ingreso.class);
		Root<Ingreso> ingresoRoot = query.from(Ingreso.class);

		TypedQuery<Ingreso> consulta = this.entityManager
				.createQuery(query.select(ingresoRoot).where(getSearchPredicatesTransaccion(ingresoRoot, ingreso)));
		consulta.setHint("javax.persistence.loadgraph", ingresoGraph);


		return consulta.getResultList();
	}

	private Predicate[] getSearchPredicatesTransaccion(Root<Ingreso> ingresoRoot, Ingreso ingreso) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();
		
		Integer transaccionId = ingreso.getTransaccion().getTransaccionId();
		if (transaccionId != null) {
			predicates.add(builder.equal(ingresoRoot.get("transaccion").<Integer> get("transaccionId"), transaccionId));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
}