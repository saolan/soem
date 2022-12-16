package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdTipo;
import ec.com.tecnointel.soem.inventario.registroInt.ProdTipoRegisInt;

@Stateless
public class ProdTipoRegisImp extends GestorRegisSoem<ProdTipo> implements ProdTipoRegisInt, Serializable {

	private static final long serialVersionUID = -5251715885465616780L;

}
