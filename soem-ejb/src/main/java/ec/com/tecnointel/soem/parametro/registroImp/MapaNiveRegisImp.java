package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.MapaNive;
import ec.com.tecnointel.soem.parametro.registroInt.MapaNiveRegisInt;

@Stateless
public class MapaNiveRegisImp extends GestorRegisSoem<MapaNive> implements MapaNiveRegisInt, Serializable {

	private static final long serialVersionUID = 1795604294636348383L;

}
