package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.ReteDeta;
import ec.com.tecnointel.soem.ingreso.registroInt.ReteDetaRegisInt;

@Stateless
public class ReteDetaRegisImp extends GestorRegisSoem<ReteDeta> implements ReteDetaRegisInt, Serializable {

	private static final long serialVersionUID = 2414675252228509438L;

}
