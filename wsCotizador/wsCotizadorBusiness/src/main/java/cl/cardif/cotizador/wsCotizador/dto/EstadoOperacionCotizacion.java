package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;

public class EstadoOperacionCotizacion implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador de estado.
     */
    private Long codigoEstado;
    /**
     * Descripcion del estado.
     */
    private String descripcionEstado;

    public EstadoOperacionCotizacion() {
        super();
    }

    public EstadoOperacionCotizacion(Long codigoEstado, String descripcionEstado) {
        super();
        this.codigoEstado = codigoEstado;
        this.descripcionEstado = descripcionEstado;
    }

    /**
     * @return the codigoEstado
     */
    public Long getCodigoEstado() {
        return codigoEstado;
    }

    /**
     * @param codigoEstado
     *            the codigoEstado to set
     */
    public void setCodigoEstado(Long codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    /**
     * @return the descripcionEstado
     */
    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    /**
     * @param descripcionEstado
     *            the descripcionEstado to set
     */
    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }

}
