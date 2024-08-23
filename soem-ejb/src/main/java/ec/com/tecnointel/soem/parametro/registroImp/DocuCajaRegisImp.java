package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuCaja;
import ec.com.tecnointel.soem.parametro.registroInt.DocuCajaRegisInt;

@Stateless
public class DocuCajaRegisImp extends GestorRegisSoem<DocuCaja> implements DocuCajaRegisInt, Serializable {

	private static final long serialVersionUID = -833220942936213877L;

}
