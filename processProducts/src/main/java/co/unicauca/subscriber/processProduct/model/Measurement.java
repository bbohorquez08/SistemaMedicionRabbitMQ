package co.unicauca.subscriber.processProduct.model;

/**
 *
 * @author mfcaicedo
 */
public class Measurement {
    /**
     * Atributos
     */
    private int idMedicion; 
    private String nombreProducto; 
    private float anchoReal; 
    private float altoReal; 
    private float pesoReal; 
    private float anchoIdeal; 
    private float altoIdeal; 
    private float pesoIdeal;
    private String tipoProducto;
    private String estadoProducto; 
    
    /**
     * Constructor vacio
     */
    public Measurement(){ 
    }
    /**
     * Constructor parametrizado
     * @param idMedicion codigo del producto a medir
     * @param nombreProducto nombre del producto a medir 
     * @param anchoReal ancho del producto a medir
     * @param altoReal alto del producto a medir
     * @param pesoReal peso del producto a medir
     * @param anchoIdeal ancho del producto esperado
     * @param altoIdeal alto del producto esperado
     * @param pesoIdeal peso del producto esperado
     * @param tipoProducto tipo del producto a medir
     * @param estadoProducto estado del producto a medir
     */
    public Measurement(int idMedicion, String nombreProducto, float anchoReal, float altoReal, 
            float pesoReal, float anchoIdeal, float altoIdeal, float pesoIdeal, String tipoProducto,
            String estadoProducto){
        this.idMedicion = idMedicion;
        this.nombreProducto = nombreProducto;
        this.anchoReal = anchoReal;
        this.altoReal = altoReal;
        this.pesoReal = pesoReal; 
        this.anchoIdeal = anchoIdeal;
        this.altoIdeal = altoIdeal;
        this.pesoIdeal = pesoIdeal; 
        this.tipoProducto = tipoProducto;
        this.estadoProducto = estadoProducto;
    }    
    /**
     * Getters and setters 
     */
    public int getIdMedicion() {
        return idMedicion;
    }

    public void setIdMedicion(int idMedicion) {
        this.idMedicion = idMedicion;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getAnchoReal() {
        return anchoReal;
    }

    public void setAnchoReal(float anchoReal) {
        this.anchoReal = anchoReal;
    }

    public float getAltoReal() {
        return altoReal;
    }

    public void setAltoReal(float altoReal) {
        this.altoReal = altoReal;
    }

    public float getPesoReal() {
        return pesoReal;
    }

    public void setPesoReal(float pesoReal) {
        this.pesoReal = pesoReal;
    }

    public float getAnchoIdeal() {
        return anchoIdeal;
    }

    public void setAnchoIdeal(float anchoIdeal) {
        this.anchoIdeal = anchoIdeal;
    }

    public float getAltoIdeal() {
        return altoIdeal;
    }

    public void setAltoIdeal(float altoIdeal) {
        this.altoIdeal = altoIdeal;
    }

    public float getPesoIdeal() {
        return pesoIdeal;
    }

    public void setPesoIdeal(float pesoIdeal) {
        this.pesoIdeal = pesoIdeal;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(String estadoProducto) {
        this.estadoProducto = estadoProducto;
    }
}
