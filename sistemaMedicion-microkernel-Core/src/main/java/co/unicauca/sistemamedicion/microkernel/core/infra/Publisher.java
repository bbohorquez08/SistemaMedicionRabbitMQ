package co.unicauca.sistemamedicion.microkernel.core.infra;


import co.unicauca.sistemamedicion.microkernel.common.interfaces.IProductProcessPlugin;
import co.unicauca.sistemamedicion.microkernel.common.interfaces.IPublisherPlugin;
import co.unicauca.sistemamedicion.microkernel.core.plugin.manager.PluginManager;

/**
 *
 * @author mfcaicedo. erikalcamacho, yavigutierrez, juanjosz, bbohorquez
 */
public class Publisher {

    public Publisher() {
    }
    /**
     * Se encarga de enviar el mensaje al suscriptor
     * @param msg mensaje a publicar
     */
    public void publish(String msg){
        PluginManager manager = PluginManager.getInstance();
        IPublisherPlugin publisher = manager.getPublisherPlugin("publisherTech"); 
        publisher.publish(msg);
    }
    
}
