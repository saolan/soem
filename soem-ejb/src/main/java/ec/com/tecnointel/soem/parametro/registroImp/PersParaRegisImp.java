package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.PersPara;
import ec.com.tecnointel.soem.parametro.registroInt.PersParaRegisInt;

@Stateless
public class PersParaRegisImp extends GestorRegisSoem<PersPara> implements PersParaRegisInt, Serializable {

	private static final long serialVersionUID = -6115395098720280168L;

}
