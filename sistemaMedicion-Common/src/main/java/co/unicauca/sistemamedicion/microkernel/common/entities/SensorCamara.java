package co.unicauca.sistemamedicion.microkernel.common.entities;



/**
 *
 * @author Milthon Caicedo 
 */
public class SensorCamara extends Sensor{
    
    private ItemMedicionElemento elemento;
    
    public SensorCamara(ItemMedicionElemento product){
        this.elemento = elemento;
    }
    
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
