package ec.com.tecnointel.soem.inventario.registroImp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityGraph;

import ec.com.tecnointel.soem.general.util.GestorRegisSoem;
import ec.com.tecnointel.soem.inventario.modelo.ProdPrec;
import ec.com.tecnointel.soem.inventario.registroInt.ProdPrecRegisInt;
import ec.com.tecnointel.soem.parametro.modelo.Dimm;

@Stateless
public class ProdPrecRegisImp extends GestorRegisSoem<ProdPrec> implements ProdPrecRegisInt, Serializable {

	private static final long serialVersionUID = -4293879033414045431L;

	@Override
	public ProdPrec buscarPorId(Integer id) {

		EntityGraph prodPrecGraph = this.entityManager.getEntityGraph("prodPrec.Graph");
		Map hints = new HashMap();
		hints.put("javax.persistence.loadgraph", prodPrecGraph);

		return entityManager.find(ProdPrec.class, id, hints);
	}
	
	/**
	 * Calcula nuevo precio
	 * @throws Exception 
	*/
	@Override
	public ProdPrec calcularPrecio(String campoCalculo, ProdPrec prodPrec, Dimm dimm, int redondeo) throws Exception {
						
//		Recupera la implementacion que se va a ejecutar
		ProdPrecModiPrecio procPrecModiPrecio = recuperarInterfaceCalculo(campoCalculo);
			
		return procPrecModiPrecio.calcularPrecio(prodPrec, dimm.getPorcen(), redondeo);
	}
	
	/*
	Recorre un arreglo con las interfaces que calculan el precio para poder seleccionar una de acuerdo 
	al parametro campoCalculo
	*/
	private ProdPrecModiPrecio recuperarInterfaceCalculo (String campoCalculo) {
		
		// Crea el arreglo con las implentaciones del inteface
		ProdPrecModiPrecio[] procPrecModiPrecios = {new ProdPrecModiConImpu(), new ProdPrecModiSinImpu()};
		
		// Recorre las implementaciones
		for (ProdPrecModiPrecio procPrecModiPrecio : procPrecModiPrecios) {

//			Asigna la anotacion con la que esta marcada la implementacion 
			ProdPrecCampoCalculo campoRecalculo =  procPrecModiPrecio.getClass().getAnnotation(ProdPrecCampoCalculo.class);
			
//			Trae el nombre de la anotacion con la que esta marcada la implementacion
			String campo = campoRecalculo.value();
			
//			Compara el valor de la anotacion con el valor que selecciono el usuario
//			para determinar que implentacion seleccionar y retornar la elegida
			if (campoCalculo.equalsIgnoreCase(campo)) {
				return procPrecModiPrecio;
			}
		}
		
		return null;
	}
}