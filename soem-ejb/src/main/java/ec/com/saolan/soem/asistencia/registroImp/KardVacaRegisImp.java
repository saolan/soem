package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.KardVaca;
import ec.com.saolan.soem.asistencia.registroInt.KardVacaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class KardVacaRegisImp extends GestorRegisSoem<KardVaca>
		implements
			KardVacaRegisInt,
			Serializable {

	private static final long serialVersionUID = 3912304427880108310L;

}
