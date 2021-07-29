package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Formula implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;


    private Long idFormula;
    private Long idProducto;
    private String nombreProducto;
    /*
     * Identificador del factor.
     */
    private Long idFactor;
    /*
     * Nombre del factor.
     */
    private String nombreFactor;
    /**
     * identificador del operador.
     */
    private Long idTipoFactor;
    /**
     * glosa operador.
     */
    private String operador;
    
    public Long getIdFormula() {
        return idFormula;
    }
    public void setIdFormula(Long idFormula) {
        this.idFormula = idFormula;
    }
    public Long getIdFactor() {
        return idFactor;
    }
    public void setIdFactor(Long idFactor) {
        this.idFactor = idFactor;
    }
    public Long getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }
    public String getNombreFactor() {
        return nombreFactor;
    }
    public void setNombreFactor(String nombreFactor) {
        this.nombreFactor = nombreFactor;
    }
    public Long getIdTipoFactor() {
        return idTipoFactor;
    }
    public void setIdTipoFactor(Long idTipoFactor) {
        this.idTipoFactor = idTipoFactor;
    }
    public String getOperador() {
        return operador;
    }
    public void setOperador(String operador) {
        this.operador = operador;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
	
	
}
