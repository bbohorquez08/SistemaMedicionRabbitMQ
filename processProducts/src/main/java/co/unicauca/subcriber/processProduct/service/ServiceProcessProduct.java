
package co.unicauca.subcriber.processProduct.service;

import co.unicauca.subscriber.processProduct.acces.RepositoryMySql;
import co.unicauca.subscriber.processProduct.model.Measurement;
import java.sql.SQLException;

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
    
    public int addMeasurement(Measurement objM) throws SQLException{
        return objMySql.addMeasurement(objM);
    }
    
}
