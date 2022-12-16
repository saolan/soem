package ec.com.tecnointel.soem.egreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.egreso.modelo.ClieGrup;
import ec.com.tecnointel.soem.egreso.registroInt.ClieGrupRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class ClieGrupRegisImp extends GestorRegisSoem<ClieGrup> implements ClieGrupRegisInt, Serializable {

	private static final long serialVersionUID = 4101108150307647624L;

}
