package ec.com.tecnointel.soem.caja.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.caja.modelo.Periferico;
import ec.com.tecnointel.soem.caja.registroInt.PerifericoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class PerifericoRegisImp extends GestorRegisSoem<Periferico> implements PerifericoRegisInt, Serializable {

	private static final long serialVersionUID = 2501092770881422443L;

}
