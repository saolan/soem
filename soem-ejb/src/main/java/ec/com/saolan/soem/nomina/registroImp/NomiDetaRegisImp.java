package ec.com.saolan.soem.nomina.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.nomina.modelo.NomiDeta;
import ec.com.saolan.soem.nomina.registroInt.NomiDetaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class NomiDetaRegisImp extends GestorRegisSoem<NomiDeta> implements NomiDetaRegisInt, Serializable {

	private static final long serialVersionUID = -1505316623479642422L;

}
