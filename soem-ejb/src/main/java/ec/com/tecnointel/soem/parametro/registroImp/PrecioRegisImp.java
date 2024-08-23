package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Precio;
import ec.com.tecnointel.soem.parametro.registroInt.PrecioRegisInt;

@Stateless
public class PrecioRegisImp extends GestorRegisSoem<Precio> implements PrecioRegisInt, Serializable {

	private static final long serialVersionUID = -6787498500571467408L;

}
