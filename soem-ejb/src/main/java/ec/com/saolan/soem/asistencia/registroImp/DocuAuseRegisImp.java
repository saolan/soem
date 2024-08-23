package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.DocuAuse;
import ec.com.saolan.soem.asistencia.registroInt.DocuAuseRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class DocuAuseRegisImp extends GestorRegisSoem<DocuAuse> implements DocuAuseRegisInt, Serializable {

	private static final long serialVersionUID = 957158536018094763L;

}
