package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuMoviIngr;
import ec.com.tecnointel.soem.parametro.registroInt.DocuMoviIngrRegisInt;

@Stateless
public class DocuMoviIngrRegisImp extends GestorRegisSoem<DocuMoviIngr> implements DocuMoviIngrRegisInt, Serializable {

	private static final long serialVersionUID = 6360285181976747899L;

}
