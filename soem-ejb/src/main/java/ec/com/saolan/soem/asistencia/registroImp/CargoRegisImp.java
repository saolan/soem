package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.Cargo;
import ec.com.saolan.soem.asistencia.registroInt.CargoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class CargoRegisImp extends GestorRegisSoem<Cargo>
		implements
			CargoRegisInt,
			Serializable {

	private static final long serialVersionUID = 1807073902372604784L;

}
