package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import cl.cardif.cotizador.wsCotizador.model.Version;

public class ListaVersion implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * lista de versiones.
     */
    private List<Version> version;

    /**
     * @return the version
     */
    public List<Version> getVersion() {
        return version;
    }

    /**
     * @param version
     *            the version to set
     */
    public void setVersion(List<Version> version) {
        this.version = version;
    }
}
