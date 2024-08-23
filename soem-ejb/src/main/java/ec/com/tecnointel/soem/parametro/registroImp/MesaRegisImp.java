package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Mesa;
import ec.com.tecnointel.soem.parametro.registroInt.MesaRegisInt;

@Stateless
public class MesaRegisImp extends GestorRegisSoem<Mesa> implements MesaRegisInt, Serializable {

	private static final long serialVersionUID = -85636932129997893L;

}
