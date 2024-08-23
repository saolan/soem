package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.EmplTitu;
import ec.com.saolan.soem.asistencia.registroInt.EmplTituRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EmplTituRegisImp extends GestorRegisSoem<EmplTitu>
		implements
			EmplTituRegisInt,
			Serializable {

	private static final long serialVersionUID = -7791141918766710161L;

}
