package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.EmplCont;
import ec.com.saolan.soem.asistencia.registroInt.EmplContRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EmplContRegisImp extends GestorRegisSoem<EmplCont>
		implements
			EmplContRegisInt,
			Serializable {

	private static final long serialVersionUID = -4642087189963994429L;

}
