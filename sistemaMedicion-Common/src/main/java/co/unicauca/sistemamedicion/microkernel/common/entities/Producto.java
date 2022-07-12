/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.common.entities;

/**
 *
 * @author eri-k
 */
public class Producto extends Elemento {
    /*
    Atributos
    */
    private float altura; 
    private float ancho; 
    private float peso; 
    
    public Producto(String nombre, String estado, String referencia, float altura, float ancho, float peso){
        super(nombre,estado,referencia);
        this.altura = altura;
        this.ancho = ancho; 
        this.peso = peso;
    }
    public Producto(){}

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
