package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.TipoCont;
import ec.com.saolan.soem.asistencia.registroInt.TipoContRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class TipoContRegisImp extends GestorRegisSoem<TipoCont>
		implements
			TipoContRegisInt,
			Serializable {

	private static final long serialVersionUID = -4733318739810183678L;

}
