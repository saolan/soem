package ec.com.tecnointel.soem.inventario.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ec.com.tecnointel.soem.general.util.GestorListaSoem;
import ec.com.tecnointel.soem.inventario.modelo.KardTotaView;
import ec.com.tecnointel.soem.inventario.modelo.ProdPrec;
import ec.com.tecnointel.soem.inventario.modelo.Producto;

@Stateless
public class ProductoListaDtoImp extends GestorListaSoem<Producto> implements ProductoListaDtoInt, Serializable {
	
	@Override
	public List<ProdPrecCostSald> buscarProdDto(Producto producto, Integer pagina, Integer filas) {
		
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<ProdPrecCostSald> query = builder.createQuery(ProdPrecCostSald.class);
		
		Root<Producto> productoRoot = query.from(Producto.class);
		Join<Producto, ProdPrec> productoProdPrecJoin = productoRoot.join("prodPrecs");
		Root<KardTotaView> kardTotaViewRoot = query.from(KardTotaView.class); 
		
//	    prodPrecJoin.on(builder.and(builder.equal(prodPrecJoin.get("precio").get("precioId"), 1)) );

		query.select(builder.construct(ProdPrecCostSald.class,
				productoProdPrecJoin.get("precio").get("precioId"),
				productoProdPrecJoin.get("precioConImpu"),
				kardTotaViewRoot.get("cantidSald"),
				productoRoot.get("codigoBarra"),
				productoRoot.get("descri")));
				
//		query.orderBy(builder.asc(productoRoot.get(orden)));
		TypedQuery<ProdPrecCostSald> consulta = this.entityManager
				.createQuery(query.where(getSearchPredicates(productoRoot, producto, productoProdPrecJoin, kardTotaViewRoot)));

		// Si se pasa null a pagina se listan todos los datos de acuerdo a parametros
		// Es decir no realiza paginacion
		if (pagina != null) {
			consulta.setFirstResult(pagina * filas).setMaxResults(filas);
		}

		return consulta.getResultList();
		 
	}
	
	private Predicate[] getSearchPredicates(Root<Producto> productoRoot, Producto producto, Join<Producto, ProdPrec> prodPrecJoin, Root<KardTotaView> kardTotaViewRoot) {

		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		List<Predicate> predicates = new ArrayList<Predicate>();

		Integer productoId = producto.getProductoId();
		if (productoId != null) {
			predicates.add(builder.equal(productoRoot.<Integer> get("productoId"), productoId));
		}
		
		String codigoBarra = producto.getCodigoBarra();
		if (codigoBarra != null && !"".equals(codigoBarra)) {
			predicates.add(builder.equal(builder.lower(productoRoot.<String> get("codigoBarra")), codigoBarra.toLowerCase() ));
		}
		
		String codigo = producto.getCodigo();
		if (codigo != null && !"".equals(codigo)) {
			predicates.add(
					builder.like(builder.lower(productoRoot.<String>get("codigo")), '%' + codigo.toLowerCase() + '%'));
		}

		String descri = producto.getDescri();
		if (descri != null && !"".equals(descri)) {
			predicates.add(
					builder.like(builder.lower(productoRoot.<String>get("descri")), '%' + descri.toLowerCase() + '%'));
		}
		
		
		predicates.add(builder.equal(kardTotaViewRoot.get("productoId"), productoRoot.get("productoId")));
		predicates.add(builder.equal(kardTotaViewRoot.get("sucursalId"), 1));
		
		predicates.add(builder.equal(prodPrecJoin.get("sucursal").get("sucursalId"), 1));
		predicates.add(builder.equal(prodPrecJoin.get("precio").get("precioId"), 1));
		
		boolean estado = producto.isEstado();
		predicates.add(builder.equal(productoRoot.get("estado"), estado));

		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< METODOS ADICIONALES
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< GETTER & SETTER
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	// <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< NOTAS
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}