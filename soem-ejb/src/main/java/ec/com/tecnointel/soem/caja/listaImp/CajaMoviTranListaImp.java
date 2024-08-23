package ec.com.tecnointel.soem.caja.listaImp;

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

import ec.com.tecnointel.soem.caja.listaInt.CajaMoviTranListaInt;
import ec.com.tecnointel.soem.caja.modelo.CajaMoviTran;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class CajaMoviTranListaImp extends GestorListaSoem<CajaMoviTran> implements CajaMoviTranListaInt, Serializable {

	private static final long serialVersionUID = -7733811550660552681L;

	// Busca con paginaci�n
	@Override
	public List<CajaMoviTran> buscar(CajaMoviTran cajaMoviTran, Integer pagina) {

		EntityGraph cajaMoviTranGraph = this.entityManager.getEntityGraph("cajaMoviTran.Graph");

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<CajaMoviTran> query = builder.createQuery(CajaMoviTran.class);
		Root<CajaMoviTran> cajaMoviRoot = query.from(CajaMoviTran.class);

		query.orderBy(builder.asc(cajaMoviRoot.get("cajaMoviTranId")));
		TypedQuery<CajaMoviTran> consulta = this.entityManager
				.createQuery(query.select(cajaMoviRoot).where(getSearchPredicates(cajaMoviRoot, cajaMoviTran)));
		consulta.setHint("javax.persistence.loadgraph", cajaMoviTranGraph);

		// Si se pasa null a pagina se listan todos los datos de acuerdo a
		// parametros
		// Es decir no realiza paginaci�n
		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(CajaMoviTran cajaMoviTran) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<CajaMoviTran> cajaMoviRoot = countQuery.from(CajaMoviTran.class);

		countQuery = countQuery.select(builder.count(cajaMoviRoot)).where(getSearchPredicates(cajaMoviRoot, cajaMoviTran));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(Root<CajaMoviTran> cajaMoviTranRoot, CajaMoviTran cajaMoviTran) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer cajaMoviId = cajaMoviTran.getCajaMovi().getCajaMoviId();
		if (cajaMoviId != null) {
			predicates.add(builder.equal(cajaMoviTranRoot.get("cajaMovi").<Integer>get("cajaMoviId"), cajaMoviId));
		}

		Integer transaccionId = cajaMoviTran.getTransaccion().getTransaccionId();
		if (transaccionId != null) {
			predicates.add(builder.equal(cajaMoviTranRoot.get("transaccion").<Integer>get("transaccionId"), transaccionId));
		}

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}