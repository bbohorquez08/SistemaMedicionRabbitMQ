/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.rabbit.plugin;

import co.unicauca.sistemamedicion.microkernel.common.interfaces.IPublisherPlugin;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

/**
 *
 * @author eri-k
 */
public class RabbitPublisherPlugin implements IPublisherPlugin {
    private Properties properties;
    @Override
    public void publish(String msg){
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(properties.getProperty("hostName"));
        try {
            com.rabbitmq.client.Connection connection = factory.newConnection();
            com.rabbitmq.client.Channel channel = connection.createChannel();
            channel.queueDeclare(properties.getProperty("queueName"), false, false, false, null);
            channel.basicPublish("",properties.getProperty("queueName"), null, msg.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + msg + "'");
        } catch (IOException | TimeoutException ex) {
            Logger.getLogger(RabbitPublisherPlugin.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
