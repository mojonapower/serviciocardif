package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Producto;

public class ListaProducto implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de productos.
     */
    private List<Producto> producto;

    /**
     * @return the canal
     */
    public List<Producto> getProducto() {
        return producto;
    }

    /**
     * @param canal
     *            the canal to set
     */
    public void setProducto(List<Producto> producto) {
        this.producto = producto;
    }
}
