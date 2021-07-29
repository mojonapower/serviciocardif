package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Marca;

public class ListaMarca implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de marca.
     */
    private List<Marca> marca;

    /**
     * @return the marca
     */
    public List<Marca> getMarca() {
        return marca;
    }

    /**
     * @param canal
     *            the marca to set
     */
    public void setMarca(List<Marca> marca) {
        this.marca = marca;
    }
}
