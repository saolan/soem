package ec.com.saolan.soem.nomina.listaImp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.saolan.soem.nomina.listaInt.DocuNomiPlanCuenListaInt;
import ec.com.saolan.soem.nomina.modelo.DocuNomiPlanCuen;
import ec.com.tecnointel.soem.general.util.GestorListaSoem;

@Stateless
public class DocuNomiPlanCuenListaImp extends GestorListaSoem<DocuNomiPlanCuen>
		implements
			DocuNomiPlanCuenListaInt,
			Serializable {

	private static final long serialVersionUID = -4280149246267765987L;

	@Override
	public List<DocuNomiPlanCuen> buscar(DocuNomiPlanCuen docuNomiPlanCuen,
			Integer pagina) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<DocuNomiPlanCuen> query = builder
				.createQuery(DocuNomiPlanCuen.class);
		Root<DocuNomiPlanCuen> docuNomiPlanCuenRoot = query
				.from(DocuNomiPlanCuen.class);

		query.orderBy(builder.desc(docuNomiPlanCuenRoot
				.get("docuNomiPlanCuenId")));
		TypedQuery<DocuNomiPlanCuen> consulta = this.entityManager
				.createQuery(query.select(docuNomiPlanCuenRoot).where(
						getSearchPredicates(docuNomiPlanCuenRoot,
								docuNomiPlanCuen)));

		if (pagina != null) {
			consulta.setFirstResult(pagina * filasPagina).setMaxResults(
					filasPagina);
		}

		return consulta.getResultList();
	}

	@Override
	public long contarRegistros(DocuNomiPlanCuen docuNomiPlanCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
		Root<DocuNomiPlanCuen> docuNomiPlanCuenRoot = countQuery
				.from(DocuNomiPlanCuen.class);

		countQuery = countQuery.select(builder.count(docuNomiPlanCuenRoot))
				.where(getSearchPredicates(docuNomiPlanCuenRoot,
						docuNomiPlanCuen));
		return this.entityManager.createQuery(countQuery).getSingleResult();

	}

	private Predicate[] getSearchPredicates(
			Root<DocuNomiPlanCuen> docuNomiPlanCuenRoot,
			DocuNomiPlanCuen docuNomiPlanCuen) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		return predicates.toArray(new Predicate[predicates.size()]);
	}
}