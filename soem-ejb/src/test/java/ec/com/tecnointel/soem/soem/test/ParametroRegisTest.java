package ec.com.tecnointel.soem.soem.test;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import ec.com.tecnointel.soem.parametro.listaInt.ParametroListaInt;
import ec.com.tecnointel.soem.parametro.modelo.Parametro;

@RunWith(Arquillian.class)
public class ParametroRegisTest {

	@Inject
	ParametroListaInt parametroLista;

	@Test
	public void grabar() throws Exception {

		assertEquals(Long.valueOf(0), parametroLista.buscarTodo("descri"));
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.war")
				.addClass(Parametro.class)
				.addClass(ParametroListaInt.class)	
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("META-INF/test-persistence.xml", "test-persistence.xml");
	}
}
