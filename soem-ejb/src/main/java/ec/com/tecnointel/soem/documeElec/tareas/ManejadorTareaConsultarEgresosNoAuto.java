package ec.com.tecnointel.soem.documeElec.tareas;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedScheduledExecutorService;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import ec.com.tecnointel.soem.parametro.modelo.Parametro;
import ec.com.tecnointel.soem.parametro.registroInt.ParametroRegisInt;


/**
Estas tareas todavia no se usan
 */

@Stateless
public class ManejadorTareaConsultarEgresosNoAuto {
	
//	Este recurso se utiliza para realiza tareas en segundo plano inmediata
//	@Resource
//	ManagedExecutorService managedExecutorService;
        
//	Este recurso de utiliza para hacer tareas luego de un tiempo determinado (Timer)
//	managedScheduledExecutorService.schedule; ejecuta tareas una sola
//	managedScheduledExecutorService.scheduleAtFixedRate; ejecuta tareas periodicas
//	managedScheduledExecutorService.scheduleWithFixedDelay; ejecuta tareas periodicas
	@Resource
    ManagedScheduledExecutorService managedScheduledExecutorService;
    
    @Inject
    Instance<TareaConsultarEgresosNoAuto> tareaEnviarConsultarEgresosNoAuto;    
    
    @Inject
    ParametroRegisInt parametroRegis;
    
    public void ejecutarTareaConsultarEgresosNoAuto() throws ExecutionException, InterruptedException {
    	
    	TareaConsultarEgresosNoAuto tareaConsultarEgresosNoAuto = tareaEnviarConsultarEgresosNoAuto.get();

    	Integer esperaEnvio = buscarEsperaEnvio();
    	
    	managedScheduledExecutorService.schedule(tareaConsultarEgresosNoAuto, esperaEnvio + 1, TimeUnit.SECONDS);
//    	managedScheduledExecutorService.shutdown();
    	
//        for(int i=0; i<2; i++) {
//            TareaEnviarDocu tareaEnviarDocu = tareaEnviarDocuIntence.get();
//            this.managedExecutorService.submit(tareaEnviarDocu);  ejecuta la tarea
//        }
    }
    
    public Integer buscarEsperaEnvio() {
    	
    	Parametro parametro = new Parametro();
    	
    	try {
			parametro = parametroRegis.buscarPorId(3200);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return Integer.parseInt(parametro.getDescri());
    }
}
