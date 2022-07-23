package co.unicauca.sistemamedicion.microkernel.core.business;

import co.unicauca.sistemamedicion.microkernel.common.entities.ItemMedicionElemento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  mfcaicedo, bbohorquez, erikalcamacho, yavigutierrez, juanjosz
 */
public class ProductService {
    /**
     * Obtiene los productos de prueba
     * @return lista donde se encuentran los productos de prueba
     */
    public List<ItemMedicionElemento> getProducts() {

        List<ItemMedicionElemento> products = new ArrayList<>();

        /*En un escenario normal, los productos vendrían de la capa de acceso a datos.
         * Para este ejemplo, se crearán objetos de prueba directamente aquí.
         * */
        ItemMedicionElemento productOne = new ItemMedicionElemento("Cerveza Artensanal", "15462","Poker");
        //SETEO VALOR DE ESTA MANERA YA QUE SE DIGITAN EN LA PRESENTACION, OTRA SOLUCION ES CREAR UN CONSTRUCTOR 
        //APARTE
        productOne.setAltura(2.22f);
        productOne.setAncho(5.42f);
        productOne.setPeso(0.33f);
        ItemMedicionElemento productTwo = new ItemMedicionElemento("Soda Artesanal", "46412", "Fanta");
        productTwo.setAltura(15.22f);
        productTwo.setAncho(8.24f);
        productTwo.setPeso(3.33f);

        products.add(productOne);
        products.add(productTwo);       

        return products;
    }
}
