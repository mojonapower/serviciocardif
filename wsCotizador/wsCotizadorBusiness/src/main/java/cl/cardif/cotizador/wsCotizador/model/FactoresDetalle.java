package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class FactoresDetalle implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Id del detalle del factor.
	 */
    private Long idFactorDetalle;
    /**
     * llave del factor.
     */
    private String llaveFactor;
    /**
     * valor del factor.
     */
    private Double valorFactor;
    
    public Long getIdFactorDetalle() {
        return idFactorDetalle;
    }
    public void setIdFactorDetalle(Long idFactorDetalle) {
        this.idFactorDetalle = idFactorDetalle;
    }
    public String getLlaveFactor() {
        return llaveFactor;
    }
    public void setLlaveFactor(String llaveFactor) {
        this.llaveFactor = llaveFactor;
    }
    public Double getValorFactor() {
        return valorFactor;
    }
    public void setValorFactor(Double valorFactor) {
        this.valorFactor = valorFactor;
    }
    

	
}
