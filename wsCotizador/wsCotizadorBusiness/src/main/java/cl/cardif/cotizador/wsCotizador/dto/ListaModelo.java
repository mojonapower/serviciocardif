package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Modelo;

public class ListaModelo implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de modeloa.
     */
    private List<Modelo> modelo;

    /**
     * @return the marca
     */
    public List<Modelo> getModelo() {
        return modelo;
    }

    /**
     * @param canal
     *            the marca to set
     */
    public void setModelo(List<Modelo> modelo) {
        this.modelo = modelo;
    }
}
