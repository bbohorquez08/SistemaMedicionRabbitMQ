package co.unicauca.sistemamedicion.microkernel.beer.plugin;

import co.unicauca.sistemamedicion.microkernel.common.entities.ItemMedicionElemento;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public class Beer extends ItemMedicionElemento {
    /*
    Atributos
    */
    private float altura; 
    private float ancho; 
    private float peso; 
    
    public Beer(String tipo, String estado, String referencia,String nombre, float altura, float ancho, float peso){
        super(tipo,referencia,nombre);
        this.altura = altura;
        this.ancho = ancho; 
        this.peso = peso;
    }
    public Beer(){}

    /**
     *
     * @Getters and Setters
     */
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }
    
    @Override
    public boolean comprobarCalidad(){        
        return false; 
    }
    @Override
    public void obtenerDatos(){
        
    }
}
