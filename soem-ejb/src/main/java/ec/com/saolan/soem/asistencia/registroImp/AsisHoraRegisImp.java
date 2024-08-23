package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.AsisHora;
import ec.com.saolan.soem.asistencia.registroInt.AsisHoraRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class AsisHoraRegisImp extends GestorRegisSoem<AsisHora>
		implements
			AsisHoraRegisInt,
			Serializable {

	private static final long serialVersionUID = -6345229928655037726L;

}
