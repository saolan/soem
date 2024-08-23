package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.HoraPlan;
import ec.com.saolan.soem.asistencia.registroInt.HoraPlanRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class HoraPlanRegisImp extends GestorRegisSoem<HoraPlan>
		implements
			HoraPlanRegisInt,
			Serializable {

	private static final long serialVersionUID = -1844552452956203267L;

}
