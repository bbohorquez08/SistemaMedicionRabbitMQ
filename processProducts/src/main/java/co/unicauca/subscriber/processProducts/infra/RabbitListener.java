package co.unicauca.subscriber.processProducts.infra;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;
/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public class RabbitListener implements Runnable{
    private final static String FILE_NAME = "connectionProperties.properties";
    ISubscriber myOffice;
    Properties connectionProperties;

    /**
     * Constructor parametrizado
     * @param office instancia de la interfaz ISubscriber
     */
    public RabbitListener(ISubscriber office) {
        this.myOffice = office; 
        loadProperties(getBaseFilePath());
    }
    
    /**
     * Realiza la conexion para poder recibir mensajes 
     */
    @Override
    public void run() {
    try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost(connectionProperties.getProperty("hostName"));
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare( connectionProperties.getProperty("queueName"), false, false, false, null);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            
            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String message = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + message + "'");
                myOffice.onMessage(message);
            };
            channel.basicConsume(connectionProperties.getProperty("queueName"), true, deliverCallback, consumerTag -> { });
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Obtiene la ruta del archivo base
     */
    private String getBaseFilePath() {
        String path = RabbitListener.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();
            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
        }
        return path;
    }
    /**
     * Carga las propiedades del archivo base
     */
    private void loadProperties(String basePath){   
        try {
            connectionProperties = new Properties();
            String filePath = basePath+FILE_NAME;
            filePath = URLDecoder.decode(filePath, "UTF-8");
            try (FileInputStream stream = new FileInputStream(filePath)) { 
                connectionProperties.load(stream);                
            } catch (IOException ex) {
                Logger.getLogger("DeliveryPluginManager").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
            }            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RabbitListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
