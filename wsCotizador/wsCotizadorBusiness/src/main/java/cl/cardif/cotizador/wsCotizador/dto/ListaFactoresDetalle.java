package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.FactoresDetalle;

public class ListaFactoresDetalle implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Codigo.
     */
    private int codigo;

    /**
     * Descripcion.
     */
    private String descripcion;

    /**
     * Listado de detalles de factores.
     */
    private List<FactoresDetalle> listadoFactoresDetalle;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<FactoresDetalle> getListadoFactoresDetalle() {
        return listadoFactoresDetalle;
    }

    public void setListadoFactoresDetalle(List<FactoresDetalle> listadoFactoresDetalle) {
        this.listadoFactoresDetalle = listadoFactoresDetalle;
    }

}
