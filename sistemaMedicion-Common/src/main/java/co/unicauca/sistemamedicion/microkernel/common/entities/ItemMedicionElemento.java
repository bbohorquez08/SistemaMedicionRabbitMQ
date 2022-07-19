/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.common.entities;

import java.util.ArrayList;

/**
 *
 * @author Milthon F Caicedo 
 */
public class ItemMedicionElemento {
    
    /**
     * Atributos 
     */
    private String tipo; 
    private String nombre;
    private String estado; 
    private String referencia;
    private float altura;
    private float ancho;
    private float peso;
    private ArrayList<Sensor> lstSensores;
    private ArrayList<Actuador> lstActuadores;  
    private ArrayList<Float> lstValoresReales;
    private ArrayList<Float> lstValoresIdeales;
    /**
     * Constructor 
     */
    public ItemMedicionElemento(){
        lstSensores = new  ArrayList<>();
        lstActuadores = new  ArrayList<>();
        lstValoresReales = new  ArrayList<>();
        lstValoresIdeales = new  ArrayList<>();
    }
    public ItemMedicionElemento(String tipo, String referencia, String nombre){
        this.tipo = tipo;
        this.referencia = referencia; 
        this.nombre=nombre;
        lstSensores = new  ArrayList<>();
        lstActuadores = new  ArrayList<>();
        lstValoresReales = new  ArrayList<>();
        lstValoresIdeales = new  ArrayList<>();
    }
    /**
     * Geters and setters
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public ArrayList<Sensor> getLstSensores() {
        return lstSensores;
    }

    public void setLstSensores(ArrayList<Sensor> lstSensores) {
        this.lstSensores = lstSensores;
    }

    public ArrayList<Actuador> getLstActuadores() {
        return lstActuadores;
    }

    public void setLstActuadores(ArrayList<Actuador> lstActuadores) {
        this.lstActuadores = lstActuadores;
    }

    public ArrayList<Float> getLstValoresReales() {
        return lstValoresReales;
    }

    public void setLstValoresReales(ArrayList<Float> lstValoresReales) {
        this.lstValoresReales = lstValoresReales;
    }

    public ArrayList<Float> getLstValoresIdeales() {
        return lstValoresIdeales;
    }

    public void setLstValoresIdeales(ArrayList<Float> lstValoresIdeales) {
        this.lstValoresIdeales = lstValoresIdeales;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    /**
     * Métods 
     */
    
    public boolean comprobarCalidad(){
        return false; 
    }
    public void obtenerDatos(){
        
    }
    
}
