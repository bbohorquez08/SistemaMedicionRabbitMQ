package co.unicauca.sistemamedicion.microkernel.common.entities;
/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public class SensorCamara extends Sensor{
    
    private ItemMedicionElemento elemento;
    /**
     * Constructor con parametros
     * @param product producto a medir
     */
    public SensorCamara(ItemMedicionElemento product){
        this.elemento = elemento;
    }
    
    /**
     * Recolecta los datos por medio del sensor
     * @param elemento producto a medir
     * @param tipo tipo de producto
     * @param altura altura del producto
     * @param ancho ancho del producto
     * @param peso peso del producto
     * @return el producto con los datos recolectados
     */
    @Override
    public ItemMedicionElemento recoleccionDatos(ItemMedicionElemento elemento, String tipo, 
            float altura, float ancho, float peso){
        
        double ref = Math.random()*100;
        elemento.setReferencia(String.valueOf(ref));
        elemento.setTipo(tipo);
        elemento.setAltura(altura);
        elemento.setAncho(ancho);
        elemento.setPeso(peso);
        return elemento;
    }
}
