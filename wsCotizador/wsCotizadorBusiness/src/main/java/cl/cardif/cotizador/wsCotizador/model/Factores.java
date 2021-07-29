package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Factores implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id factor.
	 */
	private Integer idFactor;

    /**
     * nombre del factor.
     */
    private String nombreFactor;
    /**
     * tipo de operador.
     */
    private String tipoOperador;
	/**
	 * identificador del producto
	 */
	private Long estadoFactor;
	
	
    public Integer getIdFactor() {
        return idFactor;
    }
    public void setIdFactor(Integer idFactor) {
        this.idFactor = idFactor;
    }
    public String getNombreFactor() {
        return nombreFactor;
    }
    public void setNombreFactor(String nombreFactor) {
        this.nombreFactor = nombreFactor;
    }
    public String getTipoOperador() {
        return tipoOperador;
    }
    public void setTipoOperador(String tipoOperador) {
        this.tipoOperador = tipoOperador;
    }
    public Long getEstadoFactor() {
        return estadoFactor;
    }
    public void setEstadoFactor(Long estadoFactor) {
        this.estadoFactor = estadoFactor;
    }

	
}
