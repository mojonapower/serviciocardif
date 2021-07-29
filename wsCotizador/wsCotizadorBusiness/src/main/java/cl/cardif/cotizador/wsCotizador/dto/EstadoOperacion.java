package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;

public class EstadoOperacion implements Serializable {

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

    /**
	 * 
	 */
    private Integer registrosEliminados;

    /**
	 * 
	 */
    private Integer registrosInsertados;

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

    /**
     * @return the registrosEliminados
     */
    public Integer getRegistrosEliminados() {
        return registrosEliminados;
    }

    /**
     * @param registrosEliminados
     *            the registrosEliminados to set
     */
    public void setRegistrosEliminados(Integer registrosEliminados) {
        this.registrosEliminados = registrosEliminados;
    }

    /**
     * @return the registrosInsertados
     */
    public Integer getRegistrosInsertados() {
        return registrosInsertados;
    }

    /**
     * @param registrosInsertados
     *            the registrosInsertados to set
     */
    public void setRegistrosInsertados(Integer registrosInsertados) {
        this.registrosInsertados = registrosInsertados;
    }

}
