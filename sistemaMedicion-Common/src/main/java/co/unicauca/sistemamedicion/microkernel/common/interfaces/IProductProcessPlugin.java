/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.common.interfaces;

import co.unicauca.sistemamedicion.microkernel.common.entities.ItemMedicionElemento;
import co.unicauca.sistemamedicion.microkernel.common.entities.ProcesoElemento;
import co.unicauca.sistemamedicion.microkernel.common.entities.Sensor;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public interface IProductProcessPlugin {
    ItemMedicionElemento recoleccionDatos(ItemMedicionElemento product,float altura, float ancho, float peso);
    void transformacionDatos();
    boolean clasificacionElemento(ArrayList<Float> lstComparaciones);
    void definirAccion();
    Sensor leerSensor(Sensor sensor);
    public ArrayList<Float> analisisDatos(ItemMedicionElemento product);
    ProcesoElemento procesarMedicion(ProcesoElemento proceso,float altura, float ancho, float peso);
    public ArrayList<Float> compararValores(ItemMedicionElemento product);
    public ArrayList<Float> cargarValoresIdeales();
}
