package ec.com.tecnointel.soem.ingreso.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.ProvGrup;
import ec.com.tecnointel.soem.ingreso.registroInt.ProvGrupRegisInt;

@Stateless
public class ProvGrupRegisImp extends GestorRegisSoem<ProvGrup> implements ProvGrupRegisInt, Serializable {

	private static final long serialVersionUID = 5661023814623019368L;

}
