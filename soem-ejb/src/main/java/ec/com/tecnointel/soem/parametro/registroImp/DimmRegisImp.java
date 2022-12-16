package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Dimm;
import ec.com.tecnointel.soem.parametro.registroInt.DimmRegisInt;

@Stateless
public class DimmRegisImp extends GestorRegisSoem<Dimm> implements DimmRegisInt, Serializable {

	private static final long serialVersionUID = -7822080012435183007L;

}
