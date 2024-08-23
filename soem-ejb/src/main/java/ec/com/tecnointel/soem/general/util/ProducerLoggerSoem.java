package ec.com.tecnointel.soem.general.util;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

import ec.com.tecnointel.soem.general.interfac.LoggerSoem;

public class ProducerLoggerSoem {

	@Produces
	@LoggerSoem
	public Logger produceLog(InjectionPoint injectionPoint) {
		return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}

}
