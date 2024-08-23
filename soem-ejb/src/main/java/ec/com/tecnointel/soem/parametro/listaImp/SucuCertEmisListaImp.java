package ec.com.tecnointel.soem.parametro.listaImp;

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
import ec.com.tecnointel.soem.parametro.listaInt.SucuCertEmisListaInt;
import ec.com.tecnointel.soem.parametro.modelo.SucuCertEmis;

@Stateless
public class SucuCertEmisListaImp extends GestorListaSoem<SucuCertEmis> implements SucuCertEmisListaInt, Serializable {

	private static final long serialVersionUID = -2844690343583930017L;

	@Override
	public List<SucuCertEmis> buscar(SucuCertEmis sucuCertEmis, Integer pagina) {

		EntityGraph sucuCertEmisGraph = this.entityManager.getEntityGraph("sucuCertEmis.Graph");
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<SucuCertEmis> query = builder.createQuery(SucuCertEmis.class);
		Root<SucuCertEmis> sucuCertEmisRoot = query.from(SucuCertEmis.class);

		query.orderBy(builder.asc(sucuCertEmisRoot.get("sucursalId")));
		TypedQuery<SucuCertEmis> consulta = this.entityManager
				.createQuery(query.select(sucuCertEmisRoot).where(getSearchPredicates(sucuCertEmisRoot, sucuCertEmis)));
		consulta.setHint("javax.persistence.loadgraph", sucuCertEmisGraph);

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(SucuCertEmis sucuCert) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<SucuCertEmis> sucuCertEmisRoot = countQuery.from(SucuCertEmis.class);

		countQuery = countQuery.select(builder.count(sucuCertEmisRoot)).where(getSearchPredicates(sucuCertEmisRoot, sucuCert));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<SucuCertEmis> sucuCertRoot, SucuCertEmis sucuCert) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer sucursalId = sucuCert.getSucursal().getSucursalId();
		if (sucursalId != null) {
			predicates.add(builder.equal(sucuCertRoot.get("sucursal").<Integer> get("sucursalId"), sucursalId));
		}

		Integer certEmisId = sucuCert.getCertEmis().getCertEmisId();
		if (certEmisId != null) {
			predicates.add(builder.equal(sucuCertRoot.get("certEmis").<Integer> get("certEmisId"), certEmisId));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}