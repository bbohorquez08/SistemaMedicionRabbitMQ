package co.unicauca.sistemamedicion.microkernel.common.entities;
/**
 *
 * @author milthon F caicedo, Erika Camacho, Yazmin Gutierrez, Brandon Nicolas, Juan Medicis
 */
public class Disparador {
    private String peticion;
    /**
     * Constructor sin parametros
     */
    public Disparador(){
    }
    /**
     * Constructor con parametros
     * @param peticion 
     */
    public Disparador(String peticion){
        this.peticion = peticion;
    }
    /**
     * Getters and Setterss
     */
    public String getPeticion() {
        return peticion;
    }

    public void setPeticion(String peticion) {
        this.peticion = peticion;
    }    
    /**
     * Detección de elemento. 
     * @param peticion 
     */
    public void deteccionElemento(String peticion){
        this.setPeticion(peticion);
    }    
}
