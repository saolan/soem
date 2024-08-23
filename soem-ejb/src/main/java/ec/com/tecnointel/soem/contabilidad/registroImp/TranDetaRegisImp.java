package ec.com.tecnointel.soem.contabilidad.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.tecnointel.soem.contabilidad.modelo.TranDeta;
import ec.com.tecnointel.soem.contabilidad.registroInt.TranDetaRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class TranDetaRegisImp extends GestorRegisSoem<TranDeta> implements TranDetaRegisInt, Serializable {

	private static final long serialVersionUID = 69879964508397087L;

}
