
package co.unicauca.subscriber.processProduct.acces;

import co.unicauca.subscriber.processProduct.model.Measurement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    /**
     * Agrega una medición en la base de datos 
     * @param objM medición realiazada 
     * @return 1 en caso de guardar exitosamente 0 en caso contrario
     * @throws SQLException  capturamos posibles excepciones 
     */
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

    /**
     * Obtiene las medidas que se han almacenado en la base de datos 
     * @return un arrayList que contiene las medidas de los productos que se han ingresado
     * @throws SQLException se capturan posibles excepciones
     */
    public ArrayList<Measurement> getMeasurements()throws SQLException{
        Connection con  = null;
        PreparedStatement stmt;
        String sql;
        ResultSet result;
        ArrayList<Measurement> auxListMeasurements = new ArrayList<>();
        Measurement objMeasurement = null;
        try {
            con = connect.getConexion();
            sql = "SELECT * FROM Medicion ORDER BY nombreProducto ASC;";
            stmt = con.prepareStatement(sql);
            result = stmt.executeQuery(sql);
            if(result.next()) { 
                do{
                    objMeasurement = new Measurement(result.getInt("idMedicion"), result.getString("nombreProducto"),
                        result.getFloat("anchoReal"),result.getFloat("altoReal"), result.getFloat("pesoReal"), 
                        result.getFloat("anchoIdeal"), result.getFloat("altoIdeal"), result.getFloat("pesoIdeal"), 
                        result.getString("tipoProducto"), result.getString("estadoProducto"));         
                    auxListMeasurements.add(objMeasurement);
                }while(result.next());
            }
            return auxListMeasurements;
        } catch (SQLException e) {
            System.out.println("Error en la consulta");
            System.out.println(e);
        }finally{
            con.close();
        }
        return auxListMeasurements;
    }    
}
