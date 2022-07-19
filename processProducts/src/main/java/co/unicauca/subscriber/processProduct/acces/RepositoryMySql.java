
package co.unicauca.subscriber.processProduct.acces;

import co.unicauca.subscriber.processProduct.model.Measurement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author mfcaicedo
 */
public class RepositoryMySql {
    
    ConnectDB connect = new ConnectDB();
    /**
     * Constructor vacío
     */
    public RepositoryMySql(){
        
    } 
    
    public int addMeasurement(Measurement objM) throws SQLException{
        
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        
        try {
            con = connect.getConexion();
            sql = "INSERT INTO medicion (idMedicion, nombreProducto, anchoReal, altoReal, pesoReal, anchoIdeal, "
                    + "altoIdeal, pesoIdeal, tipoProducto, estadoProducto) VALUES (?,?,?,?,?,?,?,?,?,?);";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, objM.getIdMedicion());
            stmt.setString(2, objM.getNombreProducto());
            stmt.setFloat(3, objM.getAnchoReal());
            stmt.setFloat(4, objM.getAltoReal());
            stmt.setFloat(5, objM.getPesoReal());
            stmt.setFloat(6, objM.getAnchoIdeal());
            stmt.setFloat(7, objM.getAltoIdeal());
            stmt.setFloat(8, objM.getPesoIdeal());
            stmt.setString(9, objM.getTipoProducto());
            stmt.setString(10, objM.getEstadoProducto());
            int i = stmt.executeUpdate();
            if (i == 1) {
                return 1;
            }
        } catch (SQLException e) {
            System.out.println("Error en la inserción ");
            System.out.println(e);
        }finally{
            con.close();            
        }
        
        return 0; 
    }
    
}
