package ec.com.tecnointel.soem.inventario.dto;

import java.util.List;

import ec.com.tecnointel.soem.inventario.modelo.Producto;

public interface ProductoListaDtoInt {

	List<ProdPrecCostSald> buscarProdDto(Producto producto, Integer pagina, Integer filas);

}
