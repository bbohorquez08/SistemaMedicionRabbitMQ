/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.core.plugin.manager;

import co.unicauca.sistemamedicion.microkernel.common.interfaces.IProductProcessPlugin;
import co.unicauca.sistemamedicion.microkernel.common.interfaces.IPublisherPlugin;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eri-k
 */
public class PluginManager {
    private static final String FILE_NAME = "plugin.properties";
    private static PluginManager instance;

    private Properties pluginProperties;

    private PluginManager() {
        pluginProperties = new Properties();
    }

    public static PluginManager getInstance() {
        return instance;
    }

    public static void init(String basePath) throws Exception {

        instance = new PluginManager();
        instance.loadProperties(basePath);
        if (instance.pluginProperties.isEmpty()) {
            throw new Exception("Could not initialize plugins");
        }

    }
    private void loadProperties(String basePath){   
        try {
            String filePath = basePath+FILE_NAME;
            filePath = URLDecoder.decode(filePath, "UTF-8");
            try (FileInputStream stream = new FileInputStream(filePath)) {
                
                pluginProperties.load(stream);
                
            } catch (IOException ex) {
                //revisarrrrrrrrr
                Logger.getLogger("DeliveryPluginManager").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
            }            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Object getAnyObject(String classNameProperty) {
        if (!pluginProperties.containsKey(classNameProperty)) {
            return null;
        }

        Object plugin = null;
        //Obtener el nombre de la clase del plugin.
        String pluginClassName = pluginProperties.getProperty(classNameProperty);
        System.out.println(pluginClassName);

        try {

            //Obtener una referencia al tipo de la clase del plugin.
            Class<?> pluginClass = Class.forName(pluginClassName);
            if (pluginClass != null) {
                //Crear un nuevo objeto del plugin.
                plugin = pluginClass.getDeclaredConstructor().newInstance();
            }

        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            Logger.getLogger("PluginManager").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
        return plugin;
    }    
    
    public IPublisherPlugin getPublisherPlugin(String propertyTechPublisher) {
        IPublisherPlugin plugin = null;
        Object pluginObject= getAnyObject(propertyTechPublisher);
        if (pluginObject instanceof IPublisherPlugin) {
                    plugin = (IPublisherPlugin) pluginObject;
        }
        plugin.setProperties(pluginProperties);
        return plugin;
    }
    public IProductProcessPlugin getProductProcessPlugin(String codeProduct){
        return null;
    }
}
