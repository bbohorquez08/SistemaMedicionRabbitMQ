package co.unicauca.subscriber.processProduct.acces;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author mfcaicedo    
 */
public class ConnectDB {    
    public static final String URL = "jdbc:mysql://localhost:3306/dbsistemamedicion";
    public static final String USER = "root";
    public static final String CLAVE = "root";
    /**
     * Se obtiene la conexión de la base de datos 
     * @return la conexión de tipo Connection. 
     */
    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error en la conexion: " + e.getMessage());
        }
        return con;
    }
}
