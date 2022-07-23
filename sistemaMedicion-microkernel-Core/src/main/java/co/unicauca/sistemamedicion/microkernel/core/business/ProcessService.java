package co.unicauca.sistemamedicion.microkernel.core.business;

import co.unicauca.sistemamedicion.microkernel.common.entities.ProcesoElemento;
import co.unicauca.sistemamedicion.microkernel.common.interfaces.IProductProcessPlugin;
import co.unicauca.sistemamedicion.microkernel.core.plugin.manager.PluginManager;

/**
 *
 * @author mfcaicedo, bbohorquez, erikalcamacho, yavigutierrez, juanjosz
 */
public class ProcessService{
    
    /**
     * Obtiene el plugin para a partir de él realizar el respectivo proceso de medicion
     * @param elemento producto a medir
     * @param altura altura del producto
     * @param ancho ancho del producto
     * @param peso peso del producto
     * @return proceso que encapsula el producto a medir
     * @throws Exception se capturan posibles excepciones
     */
    public ProcesoElemento ProcessProduct(ProcesoElemento elemento, float altura, 
            float ancho, float peso) throws Exception{
        
        String processPlugin = elemento.getIdProcess();
        PluginManager manager = PluginManager.getInstance();
        IProductProcessPlugin plugin = manager.getProductProcessPlugin(processPlugin);
        
        if(plugin == null){
            throw new Exception("No hay un plugin disponible para el proceso indicado: " + processPlugin);
        }
        
        return plugin.procesarMedicion(elemento, altura, ancho, peso);
    }
}
