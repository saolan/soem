package ec.com.tecnointel.soem.contabilidad.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.contabilidad.modelo.PlanCuenNive;
import ec.com.tecnointel.soem.contabilidad.registroInt.PlanCuenNiveRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class PlanCuenNiveRegisImp extends GestorRegisSoem<PlanCuenNive> implements PlanCuenNiveRegisInt, Serializable {

	private static final long serialVersionUID = 8278158150971037564L;

}
