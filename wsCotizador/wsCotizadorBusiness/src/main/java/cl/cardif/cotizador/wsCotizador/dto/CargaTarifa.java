package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.TarifaBase;

public class CargaTarifa implements Serializable {

    private static final long serialVersionUID = 3508750427373491657L;

    private Integer idCarga;

    private Long idProducto;

    private String nombreArchivo;

    private Date fechaOperacion;

    private Integer estado;

    private List<TarifaBase> tarifas;

    /**
     * @return the idCarga
     */
    public Integer getIdCarga() {
        return idCarga;
    }

    /**
     * @param idCarga
     *            the idCarga to set
     */
    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo
     *            the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the fechaOperacion
     */
    public Date getFechaOperacion() {
        Date fecha = null;
        if(fechaOperacion!=null){
            fecha = (Date)fechaOperacion.clone();
        }
        return fecha;
    }

    /**
     * @param fechaOperacion
     *            the fechaOperacion to set
     */
    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    /**
     * @return the estado
     */
    public Integer getEstado() {
        return estado;
    }

    /**
     * @param estado
     *            the estado to set
     */
    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    /**
     * @return the tarifas
     */
    public List<TarifaBase> getTarifas() {
        return tarifas;
    }

    /**
     * @param tarifas
     *            the tarifas to set
     */
    public void setTarifas(List<TarifaBase> tarifas) {
        this.tarifas = tarifas;
    }

    /**
     * @return the idProducto
     */
    public Long getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto
     *            the idProducto to set
     */
    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "CargaTarifa [idCarga=" + idCarga + ", idProducto=" + idProducto + ", nombreArchivo=" + nombreArchivo
                + ", fechaOperacion=" + fechaOperacion + ", estado=" + estado + ", tarifas=" + tarifas + "]";
    }

}
