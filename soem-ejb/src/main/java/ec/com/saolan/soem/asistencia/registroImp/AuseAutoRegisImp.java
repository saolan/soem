package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.AuseAuto;
import ec.com.saolan.soem.asistencia.registroInt.AuseAutoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class AuseAutoRegisImp extends GestorRegisSoem<AuseAuto>
		implements
			AuseAutoRegisInt,
			Serializable {

	private static final long serialVersionUID = -7458723612958341707L;

}
