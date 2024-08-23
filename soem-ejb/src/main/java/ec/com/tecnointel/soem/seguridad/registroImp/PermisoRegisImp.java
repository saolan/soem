package ec.com.tecnointel.soem.seguridad.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.seguridad.modelo.Permiso;
import ec.com.tecnointel.soem.seguridad.registroInt.PermisoRegisInt;

@Stateless
public class PermisoRegisImp extends GestorRegisSoem<Permiso> implements PermisoRegisInt, Serializable {

	private static final long serialVersionUID = 3484904921306611244L;

}
