package ec.com.tecnointel.soem.general.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.com.tecnointel.soem.general.interfac.EntityManagerSoem;

public class ProducerEntityManagerSoem {

	@Produces
	@EntityManagerSoem
	@PersistenceContext(unitName = "soemPU")
	private EntityManager entityManager;

}
