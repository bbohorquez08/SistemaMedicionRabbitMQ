/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void publish(String msg){
        PluginManager manager = PluginManager.getInstance();
        IPublisherPlugin publisher = manager.getPublisherPlugin("publisherTech"); 
        publisher.publish(msg);
    }
    
}
