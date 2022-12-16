package ec.com.tecnointel.soem.parametro.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.parametro.modelo.DocuTran;
import ec.com.tecnointel.soem.parametro.registroInt.DocuTranRegisInt;

@Stateless
public class DocuTranRegisImp extends GestorRegisSoem<DocuTran> implements DocuTranRegisInt, Serializable {

	private static final long serialVersionUID = 6618381155054233604L;

}
