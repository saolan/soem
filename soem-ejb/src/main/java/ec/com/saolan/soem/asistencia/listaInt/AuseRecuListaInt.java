package ec.com.saolan.soem.asistencia.listaInt;

import java.util.List;

import javax.ejb.Local;

import ec.com.saolan.soem.asistencia.modelo.AuseRecu;

@Local
public interface AuseRecuListaInt {

	public List<AuseRecu> buscar(AuseRecu auseRecu, Integer pagina) throws Exception;

	public long contarRegistros(AuseRecu auseRecu) throws Exception;

	public void filasPagina(int filasPagina);
	
}
