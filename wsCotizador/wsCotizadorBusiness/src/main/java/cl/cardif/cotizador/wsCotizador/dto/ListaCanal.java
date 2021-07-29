package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Canal;

public class ListaCanal implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de canales.
     */
    private List<Canal> canal;

    /**
     * @return the canal
     */
    public List<Canal> getCanal() {
        return canal;
    }

    /**
     * @param canal
     *            the canal to set
     */
    public void setCanal(List<Canal> canal) {
        this.canal = canal;
    }
}
