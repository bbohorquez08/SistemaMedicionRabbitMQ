/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.sistemamedicion.microkernel.common.entities;

/**
 *
 * @author mfcaicedo
 */
public class ProcesoElemento {
    
    /*Atributos*/
    private ItemMedicionElemento elemento;
    private String idProcess;
    
    
    //COSNTRUCTORES
    public ProcesoElemento(){}
    
    public ProcesoElemento(ItemMedicionElemento elemento, String idProcess){
        this.elemento = elemento;
        this.idProcess = idProcess;
    }
    
    //GETTERS AND SETTERS
    public ItemMedicionElemento getElemento() {
        return elemento;
    }

    public void setElemento(ItemMedicionElemento elemento) {
        this.elemento = elemento;
    }

    public String getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(String idProcess) {
        this.idProcess = idProcess;
    }
    
    //METODOS U OPERACIONES

    
}
