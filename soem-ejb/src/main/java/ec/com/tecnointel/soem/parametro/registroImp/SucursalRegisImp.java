package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.Sucursal;
import ec.com.tecnointel.soem.parametro.registroInt.SucursalRegisInt;

@Stateless
public class SucursalRegisImp extends GestorRegisSoem<Sucursal> implements SucursalRegisInt, Serializable {

	private static final long serialVersionUID = -6570866476042744317L;

}
