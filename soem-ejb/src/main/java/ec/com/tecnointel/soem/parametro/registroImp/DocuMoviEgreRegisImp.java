package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuMoviEgre;
import ec.com.tecnointel.soem.parametro.registroInt.DocuMoviEgreRegisInt;

@Stateless
public class DocuMoviEgreRegisImp extends GestorRegisSoem<DocuMoviEgre> implements DocuMoviEgreRegisInt, Serializable {

	private static final long serialVersionUID = 6056784054977640648L;

}
