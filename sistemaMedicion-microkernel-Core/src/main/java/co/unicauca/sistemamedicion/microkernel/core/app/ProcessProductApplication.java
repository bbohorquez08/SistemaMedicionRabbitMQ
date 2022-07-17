/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.core.app;

import co.unicauca.sistemamedicion.microkernel.core.plugin.manager.PluginManager;
import co.unicauca.sistemamedicion.microkernel.core.presentation.GUIMenu;
import co.unicauca.sistemamedicion.microkernel.core.presentation.GUISendProduct;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eri-k
 */
public class ProcessProductApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Inicializar el plugin manager con la ruta base de la aplicación.
        
        String basePath = getBaseFilePath();
        try {
            PluginManager.init(basePath);
             /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    GUIMenu ins = new GUIMenu();
                    ins.setLocationRelativeTo(null);
    //                ins.setExtendedState(MAXIMIZED_BOTH); //maximiza el ancho 
                    ins.setVisible(true);
                }
            });
//            new GUISendProduct().setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
    }
    /**
     * Obtiene la ruta base donde está corriendo la aplicación, sin importar que
     * sea desde un archivo .class o desde un paquete .jar.
     *
     */
    private static String getBaseFilePath() {
        String path = ProcessProductApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();

            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
        }
        return path;
    }
}
