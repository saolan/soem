package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.EmplHoraDeta;
import ec.com.saolan.soem.asistencia.registroInt.EmplHoraDetaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class EmplHoraDetaRegisImp extends GestorRegisSoem<EmplHoraDeta>
		implements
			EmplHoraDetaRegisInt,
			Serializable {

	private static final long serialVersionUID = 566537201361380225L;

}
