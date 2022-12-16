package ec.com.tecnointel.soem.general.util;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.com.tecnointel.soem.general.interfac.EntityManagerSoem;
import ec.com.tecnointel.soem.general.interfac.LoggerSoem;

public class Prueba {

	@Inject
	@EntityManagerSoem
	private EntityManager entityManager;

	@Inject
	@LoggerSoem
	Logger logger;

	public void mensage() {
		logger.info("Prueba mensaje logger");
	}

}
