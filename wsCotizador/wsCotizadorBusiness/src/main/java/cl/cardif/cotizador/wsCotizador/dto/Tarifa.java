package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;

public class Tarifa implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Deducible.
     */
    private Long deducible;
    /**
     * Valor.
     */
    private Double precio;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Tarifa: deducible[").append(deducible);
        sb.append("], precio[").append(precio);
        sb.append("], hashCode[").append(this.hashCode());
        sb.append("]");
        return sb.toString();
    }

    public Long getDeducible() {
        return deducible;
    }

    public void setDeducible(Long deducible) {
        this.deducible = deducible;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

}
