package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.MenuNive;
import ec.com.tecnointel.soem.seguridad.registroInt.MenuNiveRegisInt;

@Stateless
public class MenuNiveRegisImp extends GestorRegisSoem<MenuNive> implements MenuNiveRegisInt, Serializable {

	private static final long serialVersionUID = 676550085839443015L;

}
