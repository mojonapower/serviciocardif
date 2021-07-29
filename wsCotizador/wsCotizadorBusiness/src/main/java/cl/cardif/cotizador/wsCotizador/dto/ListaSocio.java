package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Socio;

public class ListaSocio implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de socios.
     */
    private List<Socio> socio;

    /**
     * @return the socio
     */
    public List<Socio> getSocio() {
        return socio;
    }

    /**
     * @param socio
     *            the socio to set
     */
    public void setSocio(List<Socio> socio) {
        this.socio = socio;
    }
}
