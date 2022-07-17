/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.core.business;

import co.unicauca.sistemamedicion.microkernel.common.entities.ItemMedicionElemento;
import co.unicauca.sistemamedicion.microkernel.common.entities.ProcesoElemento;
import co.unicauca.sistemamedicion.microkernel.common.interfaces.IProductProcessPlugin;
import co.unicauca.sistemamedicion.microkernel.core.plugin.manager.PluginManager;

/**
 *
 * @author eri-k
 */
public class ProcessService{
    
    public ProcesoElemento ProcessProduct(ProcesoElemento elemento, float altura, 
            float ancho, float peso) throws Exception{
        System.out.println("LLEGAAAA");
        String processPlugin = elemento.getIdProcess();
        PluginManager manager = PluginManager.getInstance();
        IProductProcessPlugin plugin = manager.getProductProcessPlugin(processPlugin);
        
        if(plugin == null){
            throw new Exception("No hay un plugin disponible para el proceso indicado: " + processPlugin);
        }
        //CAMBIAAAAAAAAAAAAAAAAAR
        return plugin.procesarMedicion(elemento, altura, ancho, peso);
    }
}
