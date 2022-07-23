package co.unicauca.subscriber.processProducts.infra;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public interface ISubscriber {  

    public void onMessage(String msg);
}
