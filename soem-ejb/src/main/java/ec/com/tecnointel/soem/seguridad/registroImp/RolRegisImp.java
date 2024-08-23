package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.Rol;
import ec.com.tecnointel.soem.seguridad.registroInt.RolRegisInt;

@Stateless
public class RolRegisImp extends GestorRegisSoem<Rol> implements RolRegisInt, Serializable {

	private static final long serialVersionUID = 8896521026643073594L;

}
