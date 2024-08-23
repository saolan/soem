package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.egreso.modelo.EgreDeta;
import ec.com.tecnointel.soem.egreso.registroInt.EgreDetaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EgreDetaRegisImp extends GestorRegisSoem<EgreDeta> implements EgreDetaRegisInt, Serializable {

	private static final long serialVersionUID = -7882331909436493784L;

}
