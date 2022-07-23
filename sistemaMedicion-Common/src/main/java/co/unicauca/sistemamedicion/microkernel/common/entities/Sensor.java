package co.unicauca.sistemamedicion.microkernel.common.entities;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public abstract class Sensor {    
    /**
     * Constructor sin parametros
     */
    public Sensor(){}
    /**
     * Metodos u operaciones
     */
    public abstract ItemMedicionElemento recoleccionDatos(ItemMedicionElemento product,String tipo,
            float altura, float ancho, float peso);
    
}
