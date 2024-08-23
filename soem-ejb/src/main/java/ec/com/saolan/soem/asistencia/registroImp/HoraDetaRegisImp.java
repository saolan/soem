package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.HoraDeta;
import ec.com.saolan.soem.asistencia.registroInt.HoraDetaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class HoraDetaRegisImp extends GestorRegisSoem<HoraDeta>
		implements
			HoraDetaRegisInt,
			Serializable {

	private static final long serialVersionUID = -9085782465733707734L;

}
