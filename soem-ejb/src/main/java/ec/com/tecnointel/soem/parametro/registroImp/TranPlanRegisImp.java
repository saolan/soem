package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.TranPlan;
import ec.com.tecnointel.soem.parametro.registroInt.TranPlanRegisInt;

@Stateless
public class TranPlanRegisImp extends GestorRegisSoem<TranPlan> implements TranPlanRegisInt, Serializable {

	private static final long serialVersionUID = 8990556919019885507L;

}
