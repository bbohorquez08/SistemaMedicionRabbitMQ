/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.subscriber.processProducts.infra;

/**
 *
 * @author yavigutierrez
 */
public interface ISubscriber {  
    public void onMessage(String msg);
}
