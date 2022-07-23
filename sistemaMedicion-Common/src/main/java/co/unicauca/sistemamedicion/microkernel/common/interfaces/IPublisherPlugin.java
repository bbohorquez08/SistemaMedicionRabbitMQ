/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.sistemamedicion.microkernel.common.interfaces;

import java.util.Properties;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public interface IPublisherPlugin {
    public void publish(String msg);
    public void setProperties(Properties publisherProperties);
}
