package co.unicauca.sistemamedicion.microkernel.common.entities;


/**
 *
 * @author Milthon Caicedo 
 */
public abstract class Sensor {
    
    /**
     * Atributos 
     */
    
    /**
     * Constructor
     */
    public Sensor(){
        
    }
    
    /**
     * Métodos
     * @param product
     * @param tipo
     * @param altura
     * @param ancho
     * @param peso
     * @return 
     */
    public abstract ItemMedicionElemento recoleccionDatos(ItemMedicionElemento product,String tipo,
            float altura, float ancho, float peso);
    
}
