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
     * Obtiene los productos con los valores ideales correspondientes a los pluggins que se tienen. 
     * @return lista donde se encuentran los productos ideales
     */
    public List<ItemMedicionElemento> getProductsIdeals() {

        List<ItemMedicionElemento> ProductosIdeales = new ArrayList<>();
        /**
         * Insertamos de manera local los valores ideales de los plugins que se tienen hasta ahora. (Cerveza y gaseosa)
         */
        ItemMedicionElemento productoCervezaIdeal = new ItemMedicionElemento("Cerveza", "","");
         productoCervezaIdeal.setAltura(2.22f);
         productoCervezaIdeal.setAncho(5.42f);
         productoCervezaIdeal.setPeso(0.33f);
        ItemMedicionElemento productoGaseosaIdeal = new ItemMedicionElemento("Gaseosa", "", "");
        productoGaseosaIdeal.setAltura(15.22f);
        productoGaseosaIdeal.setAncho(8.24f);
        productoGaseosaIdeal.setPeso(3.33f);
        
        ProductosIdeales.add(productoCervezaIdeal);
        ProductosIdeales.add(productoGaseosaIdeal);       
        return ProductosIdeales;
    }
}
