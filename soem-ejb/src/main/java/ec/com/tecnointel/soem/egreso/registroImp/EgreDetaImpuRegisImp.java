package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.egreso.modelo.EgreDetaImpu;
import ec.com.tecnointel.soem.egreso.registroInt.EgreDetaImpuRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EgreDetaImpuRegisImp extends GestorRegisSoem<EgreDetaImpu> implements EgreDetaImpuRegisInt, Serializable {

	private static final long serialVersionUID = -524728287871785647L;

}
