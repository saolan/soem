package ec.com.tecnointel.soem.general.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.interfac.EntityManagerSoem;

public abstract class GestorListaSoem<T> implements Serializable {

	private static final long serialVersionUID = -4528601166664785916L;

	protected int filasPagina;

	protected String orden = "Asc";
	
	@Inject
	@EntityManagerSoem
	protected EntityManager entityManager;

	private Class<T> entityClass;

	public GestorListaSoem() {
		ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) type.getActualTypeArguments()[0];
	}

	// Busca todos los registros ordenados por alguna columna
	// Se usa para llenar combos
	public List<T> buscarTodo(String columna) throws Exception {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = builder.createQuery(entityClass);
		Root<T> root = query.from(entityClass);

		query.orderBy(builder.asc(root.get(columna)));
		TypedQuery<T> consulta = this.entityManager.createQuery(query.select(root));

		return consulta.getResultList();
	}

	public void filasPagina(int filas){
		this.filasPagina = filas;	
	}
	
	public void orden(String orden){
		this.orden = orden;	
	}

}