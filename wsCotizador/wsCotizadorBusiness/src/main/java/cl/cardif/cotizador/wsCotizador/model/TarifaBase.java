package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class TarifaBase implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    private int idCanal;
    private String nombreCanal;
    private Long idSocio;
    private String nombreSocio;
    private Long idProducto;
    private String nombreProducto;
    private Long idMarca;
    private String nombreMarca;
    private Long idModelo;
    private String nombreModelo;
    private Long idVersion;
    private String nombreVersion;
    private Long idDeducible;
    private Long nombreDeducible;
    private Double valor;

    /**
     * @return the idCanal
     */
    public int getIdCanal() {
        return idCanal;
    }

    /**
     * @param idCanal the idCanal to set
     */
    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    /**
     * @return the nombreCanal
     */
    public String getNombreCanal() {
        return nombreCanal;
    }

    /**
     * @param nombreCanal the nombreCanal to set
     */
    public void setNombreCanal(String nombreCanal) {
        this.nombreCanal = nombreCanal;
    }

    /**
     * @return the idSocio
     */
    public Long getIdSocio() {
        return idSocio;
    }

    /**
     * @param idSocio the idSocio to set
     */
    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }

    /**
     * @return the nombreSocio
     */
    public String getNombreSocio() {
        return nombreSocio;
    }

    /**
     * @param nombreSocio the nombreSocio to set
     */
    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    /**
     * @return the idProducto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the idMarca
     */
    public Long getIdMarca() {
        return idMarca;
    }

    /**
     * @param idMarca the idMarca to set
     */
    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    /**
     * @return the nombreMarca
     */
    public String getNombreMarca() {
        return nombreMarca;
    }

    /**
     * @param nombreMarca the nombreMarca to set
     */
    public void setNombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    /**
     * @return the idModelo
     */
    public Long getIdModelo() {
        return idModelo;
    }

    /**
     * @param idModelo the idModelo to set
     */
    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * @return the nombreModelo
     */
    public String getNombreModelo() {
        return nombreModelo;
    }

    /**
     * @param nombreModelo the nombreModelo to set
     */
    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    /**
     * @return the idVersion
     */
    public Long getIdVersion() {
        return idVersion;
    }

    /**
     * @param idVersion the idVersion to set
     */
    public void setIdVersion(Long idVersion) {
        this.idVersion = idVersion;
    }

    /**
     * @return the nombreVersion
     */
    public String getNombreVersion() {
        return nombreVersion;
    }

    /**
     * @param nombreVersion the nombreVersion to set
     */
    public void setNombreVersion(String nombreVersion) {
        this.nombreVersion = nombreVersion;
    }

    /**
     * @return the idDeducible
     */
    public Long getIdDeducible() {
        return idDeducible;
    }

    /**
     * @param idDeducible the idDeducible to set
     */
    public void setIdDeducible(Long idDeducible) {
        this.idDeducible = idDeducible;
    }

    /**
     * @return the nombreDeducible
     */
    public Long getNombreDeducible() {
        return nombreDeducible;
    }

    /**
     * @param nombreDeducible the nombreDeducible to set
     */
    public void setNombreDeducible(Long nombreDeducible) {
        this.nombreDeducible = nombreDeducible;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

}
