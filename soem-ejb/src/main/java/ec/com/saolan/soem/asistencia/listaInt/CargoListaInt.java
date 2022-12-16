package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.Cargo;

@Local
public interface CargoListaInt {

	public List<Cargo> buscar(Cargo cargo, Integer pagina) throws Exception;

	public long contarRegistros(Cargo cargo) throws Exception;

	public void filasPagina(int filasPagina);
	
}
