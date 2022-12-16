package ec.com.tecnointel.soem.egreso.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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

import ec.com.tecnointel.soem.egreso.listaInt.EgresoListaInt;
import ec.com.tecnointel.soem.egreso.modelo.Egreso;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class EgresoListaImp extends GestorListaSoem<Egreso> implements EgresoListaInt, Serializable {

	private static final long serialVersionUID = -2813327276841153934L;

	// Busca con paginacion
	@Override
	public List<Egreso> buscar(Egreso egreso, Integer pagina, Set<Integer> sucursals) {

		EntityGraph egresoGraph = this.entityManager.getEntityGraph("egreso.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Egreso> query = builder.createQuery(Egreso.class);
		Root<Egreso> egresoRoot = query.from(Egreso.class);
		
		if (this.orden.equals("Desc")) {
			query.orderBy(builder.desc(egresoRoot.get("numero")));
		} else {
			query.orderBy(builder.asc(egresoRoot.get("numero")));
		}	

		TypedQuery<Egreso> consulta = this.entityManager
				.createQuery(query.select(egresoRoot).where(getSearchPredicates(egresoRoot, egreso, sucursals)));
		consulta.setHint("javax.persistence.loadgraph", egresoGraph);

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(Egreso egreso, Set<Integer> sucursals) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<Egreso> egresoRoot = countQuery.from(Egreso.class);

		countQuery = countQuery.select(builder.count(egresoRoot)).where(getSearchPredicates(egresoRoot, egreso, sucursals));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<Egreso> egresoRoot, Egreso egreso, Set<Integer> sucursals) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();
		
//		Integer sucursalId = egreso.getSucursal().getSucursalId();
//		if (sucursalId != null) {
//			predicates.add(builder.equal(egresoRoot.get("sucursal").get("sucursalId"), sucursalId));
//		}
		
		if (sucursals.size() != 0) {
			Expression<Integer> expression = egresoRoot.get("sucursal").<Integer> get("sucursalId");
			Predicate predicate = expression.in(sucursals);
			predicates.add(predicate);
		}
		
		Integer cajaMoviId = egreso.getCajaMovi().getCajaMoviId();
		if (cajaMoviId != null) {
			predicates.add(builder.equal(egresoRoot.get("cajaMovi").get("cajaMoviId"), cajaMoviId));
		}
		
		Integer cajaId = egreso.getCajaMovi().getCaja().getCajaId();
		if (cajaId != null) {
			predicates.add(builder.equal(egresoRoot.get("cajaMovi").get("caja").get("cajaId"), cajaId));
		}
				
		String cedulaRuc = egreso.getPersClie().getPersona().getCedulaRuc();
		if (cedulaRuc != null) {
			predicates.add(builder.equal(builder.lower(egresoRoot.get("persClie").get("persona").<String> get("cedulaRuc")), cedulaRuc.toLowerCase()));
		}
		
		String apelli = egreso.getPersClie().getPersona().getApelli();
		if (apelli != null) {
			predicates.add(builder.like(builder.lower(egresoRoot.get("persClie").get("persona").<String> get("apelli")), '%' + apelli.toLowerCase() + '%'));
		}
		
		String nombre = egreso.getPersClie().getPersona().getNombre();
		if (nombre != null) {
			predicates.add(builder.like(builder.lower(egresoRoot.get("persClie").get("persona").<String> get("nombre")), '%' + nombre.toLowerCase() + '%'));
		}	
		
		String docuEgreDescri = egreso.getDocuEgre().getDocumento().getDescri();
		if (docuEgreDescri != null) {
			predicates.add(builder.like(builder.lower(egresoRoot.get("docuEgre").get("documento").<String> get("descri")), docuEgreDescri.toLowerCase()));
		}
		
		String docuEgreDocumeElec = egreso.getDocuEgre().getDocumeElec();
		if (docuEgreDocumeElec != null) {
			predicates.add(builder.notEqual(builder.lower(egresoRoot.get("docuEgre").<String> get("documeElec")), docuEgreDocumeElec.toLowerCase()));
		}
		
		String serie1 = egreso.getSerie1();
		if (serie1 != null) {
			predicates.add(builder.equal(egresoRoot.get("serie1"), serie1));
		}	
		
		String serie2 = egreso.getSerie2();
		if (serie2 != null) {
			predicates.add(builder.equal(egresoRoot.get("serie2"), serie2));
		}	

		Integer numero = egreso.getNumero();
		if (numero != null) {
			predicates.add(builder.equal(egresoRoot.get("numero"), numero));
		}

		Date fechaEmis = egreso.getFechaEmis();
		if (fechaEmis != null) {
			predicates.add(builder.greaterThanOrEqualTo(egresoRoot.<Date> get("fechaEmis"), fechaEmis));
		}

		String estado = egreso.getEstado();
		if (estado != null) {
			predicates.add(builder.equal(builder.lower(egresoRoot.<String> get("estado")), estado.toLowerCase()));
		}
		
		String estadoDocuElec = egreso.getEstadoDocuElec();
		if (estadoDocuElec != null) {
			predicates.add(builder.notEqual(builder.lower(egresoRoot.<String> get("estadoDocuElec")), estadoDocuElec.toLowerCase()));
		}
		
		if (egreso.getEgreso() != null) {
			Integer egresoSupeId = egreso.getEgreso().getEgresoId();
			if (egresoSupeId != null) {
				predicates.add(builder.equal(egresoRoot.get("egreso").get("egresoId"), egresoSupeId));
			}
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}