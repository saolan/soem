package ec.com.saolan.soem.asistencia.registroImp;

import java.io.Serializable;

import javax.ejb.Stateless;

import ec.com.saolan.soem.asistencia.modelo.Departamento;
import ec.com.saolan.soem.asistencia.registroInt.DepartamentoRegisInt;
import ec.com.tecnointel.soem.general.util.GestorRegisSoem;

@Stateless
public class DepartamentoRegisImp extends GestorRegisSoem<Departamento>
		implements
			DepartamentoRegisInt,
			Serializable {

	private static final long serialVersionUID = -4280573985506691319L;

}
