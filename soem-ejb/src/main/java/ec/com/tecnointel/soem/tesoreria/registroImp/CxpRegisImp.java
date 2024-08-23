package ec.com.tecnointel.soem.tesoreria.registroImp;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.ingreso.modelo.Ingreso;
import ec.com.tecnointel.soem.tesoreria.modelo.Cxp;
import ec.com.tecnointel.soem.tesoreria.registroInt.CxpRegisInt;

@Stateless
public class CxpRegisImp extends GestorRegisSoem<Cxp> implements CxpRegisInt, Serializable {

	private static final long serialVersionUID = -3076964277672531605L;
	
	@Override
	public Cxp buscarPorId(Integer id) {

		EntityGraph cxpGraph = this.entityManager.getEntityGraph("cxp.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", cxpGraph);

		return entityManager.find(Cxp.class, id, hints);
	}
	
	@Override
	public List<Cxp> generarCxp(Ingreso ingreso, BigDecimal total, Boolean estado) throws Exception {
		
		List<Cxp> cxps = new ArrayList<>();

		for (int i = 0; i < ingreso.getNumeroCuot(); i++) {
						
			Cxp cxp = new Cxp();
			cxp.setIngreso(ingreso);
			cxp.setFechaVenc(ingreso.getFechaEmis().plusDays(ingreso.getDiasPlaz()));
			cxp.setFechaHoraVenc(cxp.getFechaVenc().atTime(LocalTime.now()));
			cxp.setTotal(total.divide(new BigDecimal(ingreso.getNumeroCuot()),6,RoundingMode.HALF_UP));
			cxp.setEstado(estado);
			cxps.add(cxp);
		}

		return cxps;
	};
}
