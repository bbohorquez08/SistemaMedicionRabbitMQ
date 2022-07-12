/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.common.interfaces;

/**
 *
 * @author eri-k
 */
public interface IProductProcessPlugin {
    //revisar que devuelve cada metodo
    void ingresoElemento();
    String recoleccionDatos();
    void transformacionDatos();
    boolean clasificacionElemento();
    void definirAccion();
}
