package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.Ausencia;
import ec.com.saolan.soem.asistencia.registroInt.AusenciaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class AusenciaRegisImp extends GestorRegisSoem<Ausencia>
		implements
			AusenciaRegisInt,
			Serializable {

	private static final long serialVersionUID = -8117218475593132991L;

}
