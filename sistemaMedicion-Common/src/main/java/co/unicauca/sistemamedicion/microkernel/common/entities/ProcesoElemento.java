package co.unicauca.sistemamedicion.microkernel.common.entities;

/**
 *
 * @author mfcaicedo, bbohorquez, elcamacho, yavigutierrez, juanjosz
 */
public class ProcesoElemento {
    /*Atributos*/
    private ItemMedicionElemento elemento;
    private String idProcess;
       
    /**
     * Constructor sin parametros
     */
    public ProcesoElemento(){}
    /**
     * Constructor con parametros
     * @param elemento 
     * @param idProcess 
     */
    public ProcesoElemento(ItemMedicionElemento elemento, String idProcess){
        this.elemento = elemento;
        this.idProcess = idProcess;
    }
    
    /**
     * Getters ans Setters
     */
    public ItemMedicionElemento getElemento() {
        return elemento;
    }

    public void setElemento(ItemMedicionElemento elemento) {
        this.elemento = elemento;
    }

    public String getIdProcess() {
        return idProcess;
    }

    public void setIdProcess(String idProcess) {
        this.idProcess = idProcess;
    }
}
