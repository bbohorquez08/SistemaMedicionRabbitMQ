
package co.unicauca.subcriber.processProduct.service;

import co.unicauca.subscriber.processProduct.acces.RepositoryMySql;
import co.unicauca.subscriber.processProduct.model.Measurement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author mfcaicedo
 */
public class ServiceProcessProduct {
    /**
     * Atributos
     */
    RepositoryMySql objMySql;
    /**
     * Constructor 
     */
    public ServiceProcessProduct(){
        objMySql = new RepositoryMySql();
    }
    /**
     * Fachada para llamar al método para agregar mediciones a la base de datos 
     * @param objM medición 
     * @return 1 si la inserción es correcta 0 en caso contrario 
     * @throws SQLException se capturan posibles excepciones 
     */
    public int addMeasurement(Measurement objM) throws SQLException{
        return objMySql.addMeasurement(objM);
    }

    /**
     * Fachada para obtener las medidas que se han almacenado en la base de datos 
     * @return un arrayList que contiene las medidas de los productos que se han ingresado
     * @throws SQLException se capturan posibles excepciones
     */
    public ArrayList<Measurement> getMeasurements() throws SQLException{
        return objMySql.getMeasurements();
    }
    
}
