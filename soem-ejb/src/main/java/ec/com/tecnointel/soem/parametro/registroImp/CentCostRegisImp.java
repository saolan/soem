package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.CentCost;
import ec.com.tecnointel.soem.parametro.registroInt.CentCostRegisInt;

@Stateless
public class CentCostRegisImp extends GestorRegisSoem<CentCost> implements CentCostRegisInt, Serializable {

	private static final long serialVersionUID = -3007261403404717235L;

}
