package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.FeriRecu;
import ec.com.saolan.soem.asistencia.registroInt.FeriRecuRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class FeriRecuRegisImp extends GestorRegisSoem<FeriRecu>
		implements
			FeriRecuRegisInt,
			Serializable {

	private static final long serialVersionUID = -3324403998634498018L;

}
