package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.PersEmpl;
import ec.com.saolan.soem.asistencia.registroInt.PersEmplRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class PersEmplRegisImp extends GestorRegisSoem<PersEmpl>
		implements
			PersEmplRegisInt,
			Serializable {

	private static final long serialVersionUID = -2476878014176819503L;

}
