package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;
import java.util.Date;

public class ProcesoCarga implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id canal.
     */
    private Integer idCarga;

    private String nombreArchivo;

    private Date fechaOperacion;

    private Integer estado;

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

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ProcesoCarga [idCarga=" + idCarga + ", nombreArchivo=" + nombreArchivo + ", fechaOperacion="
                + fechaOperacion + ", estado=" + estado + "]";
    }

}
