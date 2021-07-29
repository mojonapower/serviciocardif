package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = { "idCotizacion", "estadoOperacion", "resultadoCotizacion", "listadoProductos" })
public class SalidaCotizacion implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador de cotizacion generada.
     */
    private Long idCotizacion;
    /**
     * To que contiene estado de la operacion.
     */
    private EstadoOperacionCotizacion estadoOperacion;
    /**
     * To que contiene el resultado de la cotizacion.
     */
    private ResultadoCotizacion resultadoCotizacion;
    /**
     * Listado de productos cotizados.
     */
    private List<ProductoTO> listadoProductos;
    

    public SalidaCotizacion() {
        super();
    }

    public SalidaCotizacion(EstadoOperacionCotizacion estadoOperacion) {
        super();
        this.estadoOperacion = estadoOperacion;
    }

    public SalidaCotizacion(Long idCotizacion, EstadoOperacionCotizacion estadoOperacion,
            ResultadoCotizacion resultadoCotizacion, List<ProductoTO> listadoProductos) {
        super();
        this.idCotizacion = idCotizacion;
        this.estadoOperacion = estadoOperacion;
        this.resultadoCotizacion = resultadoCotizacion;
        this.listadoProductos = listadoProductos;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("SalidaCotizacion: estadoOperacion[").append(estadoOperacion);
        sb.append("], resultadoCotizacion[").append(resultadoCotizacion);
        sb.append("], listadoProductos[").append(listadoProductos);
        sb.append("], hashCode[").append(this.hashCode());
        sb.append("]");
        return sb.toString();
    }

    public EstadoOperacionCotizacion getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(EstadoOperacionCotizacion estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public ResultadoCotizacion getResultadoCotizacion() {
        return resultadoCotizacion;
    }

    public void setResultadoCotizacion(ResultadoCotizacion resultadoCotizacion) {
        this.resultadoCotizacion = resultadoCotizacion;
    }

    public List<ProductoTO> getListadoProductos() {
        return listadoProductos;
    }

    public void setListadoProductos(List<ProductoTO> listadoProductos) {
        this.listadoProductos = listadoProductos;
    }

    public Long getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(Long idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

}
