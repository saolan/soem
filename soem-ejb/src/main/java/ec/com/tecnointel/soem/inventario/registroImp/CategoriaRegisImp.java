package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.Categoria;
import ec.com.tecnointel.soem.inventario.registroInt.CategoriaRegisInt;

@Stateless
public class CategoriaRegisImp extends GestorRegisSoem<Categoria> implements CategoriaRegisInt, Serializable {

	private static final long serialVersionUID = -5502649997510542961L;

}
