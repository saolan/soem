package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.IngrDetaPrec;
import ec.com.tecnointel.soem.ingreso.registroInt.IngrDetaPrecRegisInt;

@Stateless
public class IngrDetaPrecRegisImp extends GestorRegisSoem<IngrDetaPrec> implements IngrDetaPrecRegisInt, Serializable {

	private static final long serialVersionUID = 5376766809757520942L;

}
