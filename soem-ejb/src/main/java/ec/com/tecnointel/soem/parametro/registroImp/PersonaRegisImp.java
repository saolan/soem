package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Persona;
import ec.com.tecnointel.soem.parametro.registroInt.PersonaRegisInt;

@Stateless
public class PersonaRegisImp extends GestorRegisSoem<Persona> implements PersonaRegisInt, Serializable {

	private static final long serialVersionUID = -5670089256147202084L;

}
