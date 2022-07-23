package co.unicauca.sistemamedicion.microkernel.beer.plugin;

import co.unicauca.sistemamedicion.microkernel.common.entities.ItemMedicionElemento;
import co.unicauca.sistemamedicion.microkernel.common.entities.ProcesoElemento;
import co.unicauca.sistemamedicion.microkernel.common.entities.Sensor;
import co.unicauca.sistemamedicion.microkernel.common.entities.SensorCamara;
import co.unicauca.sistemamedicion.microkernel.common.interfaces.IProductProcessPlugin;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public class BeerProcessPlugin implements IProductProcessPlugin {

    /**
     * Realiza la medicion y clasificacion del proceso que llega 
     * @param proceso proceso en el que se encuentra el producto a medir 
     * @param altura altura del producto
     * @param ancho ancho del producto
     * @param peso peso del producto
     * @return 
     */
    @Override
    public ProcesoElemento procesarMedicion(ProcesoElemento proceso, float altura,
            float ancho, float peso) {
        ArrayList<Float> lstErrores = new ArrayList<>();
        ArrayList<Float> lstValoresReales = new ArrayList<>();
        ArrayList<Float> lstValoresIdeales = new ArrayList<>();
                
        //1. Recolectar datos (agregamos el sensor y el actuador)
        //elemento = recoleccionDatos(elemento);
        proceso.setElemento(recoleccionDatos(proceso.getElemento(),altura,ancho,peso));
        
        //2. Analisis de datos y transformación de datos 
        //analisisDatos(cerveza);
        lstValoresReales=analisisDatos(proceso.getElemento());
        proceso.getElemento().setLstValoresReales(lstValoresReales);
        lstValoresIdeales=cargarValoresIdeales();
        proceso.getElemento().setLstValoresIdeales(lstValoresIdeales);
        
        //3. Compara los valores 
        //lstErrores = compararValores();
        lstErrores=compararValores(proceso.getElemento());
        //4. Clasificación de los elementos 
        //cerveza = clasificarElemento(cerveza, lstErrores);
        boolean clasificacion=clasificacionElemento(lstErrores);
        if(clasificacion){
            proceso.getElemento().setEstado("Optimo");
        }else{
            proceso.getElemento().setEstado("Defectuoso");
        }
        //return cerveza;
        return proceso;
    }
    
    /**
     * Recolecta los datos por medio del sensor
     * @param elemento producto a medir
     * @param altura altura del producto
     * @param ancho ancho del producto
     * @param peso peso del producto
     * @return el producto con los datos recolectados
     */
    @Override
    public ItemMedicionElemento recoleccionDatos(ItemMedicionElemento elemento, 
            float altura, float ancho, float peso) {
        SensorCamara objCamara = new SensorCamara(elemento);
        objCamara = (SensorCamara) leerSensor(objCamara); 
        elemento = objCamara.recoleccionDatos(elemento, elemento.getTipo(), altura, ancho, peso);
        elemento.getLstSensores().add(objCamara);
        return elemento;
    }

    @Override
    public void transformacionDatos() {
    }

    /**
     * Clasifica el elemento segun valores arrojados
     * @param lstComparaciones lista que tiene el margen de error para cada valor medido
     * @return true cuando el estado es optimo, de lo contrario retorna false
     */
    @Override
    public boolean clasificacionElemento(ArrayList<Float> lstComparaciones) {
        boolean bandera=false;
        if (lstComparaciones.get(0) <= 0.04 && lstComparaciones.get(1) <= 0.04 && lstComparaciones.get(2) <= 0.04) {
            bandera=true;
        }
        return bandera;
    }

    @Override
    public void definirAccion() {
    }

    /**
     * Leer sensor 
     * @param sensor
     * @return
     */
    @Override
    public Sensor leerSensor(Sensor sensor) {
        return sensor;
    }

    /**
     * Añade los valores reales a una lista
     * @param product producto que contiene la informacion
     * @return lista con los valores reales del producto
     */
    @Override
    public ArrayList<Float> analisisDatos(ItemMedicionElemento product) {
        //Agregar a la lista de valores reales la informacion capturada por los sensores
        ArrayList<Float> lstValoresReales = new ArrayList<>();
        lstValoresReales.add(product.getAltura());
        lstValoresReales.add(product.getAncho());
        lstValoresReales.add(product.getPeso());
        return lstValoresReales;
    }

    /**
     * Compara los valores reales e ideales
     * @param product producto que contiene la informacion
     * @return lista con errores en la medicion del producto
     */
    @Override
    public ArrayList<Float> compararValores(ItemMedicionElemento product) {
        ArrayList<Float> lstErrores = new ArrayList<>();
        float errorAltura = 0.0f;
        float errorAncho = 0.0f;
        float errorPeso = 0.0f;
        for (int i = 0; i<product.getLstValoresReales().size(); i+=3) {
            //En este caso se tuvo una tolerancia de error en los valores reales con 
            //respecto a los ideales de un 4%.  
            errorAltura = Math.abs((product.getLstValoresIdeales().get(i) -product.getLstValoresReales().get(i))/(product.getLstValoresIdeales().get(i)));
            System.out.println("error altura es: "+errorAltura);
            errorAncho = Math.abs((product.getLstValoresIdeales().get(i+1) -product.getLstValoresReales().get(i+1))/(product.getLstValoresIdeales().get(i+1)));
            System.out.println("error ancho es: "+errorAncho);
            errorPeso = Math.abs((product.getLstValoresIdeales().get(i+2) -product.getLstValoresReales().get(i+2))/(product.getLstValoresIdeales().get(i+2)));
        }   System.out.println("error peso es: "+errorPeso);
        lstErrores.add(errorAltura);
        lstErrores.add(errorAncho);
        lstErrores.add(errorPeso);
        
        return lstErrores;
    }

    /**
     * Define los valores ideales para un producto cerveza y los agrega a una lista
     * @return lista con valores ideales del producto beer
     */
    @Override
    public ArrayList<Float> cargarValoresIdeales() {
        ArrayList<Float> lstValoresIdeales = new ArrayList<>();
        float alturaIdeal=12.22f;
        float anchoIdeal=5.24f;
        float pesoIdeal=0.33f;
        
        lstValoresIdeales.add(alturaIdeal);
        lstValoresIdeales.add(anchoIdeal);
        lstValoresIdeales.add(pesoIdeal);
        return lstValoresIdeales;
    }    
}
