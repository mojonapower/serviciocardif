package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;
import java.util.List;

public class DetalleProducto implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    private String nombreProducto;
    private List<Deducible> listDeducible;

    public DetalleProducto() {
        super();
    }

    public DetalleProducto(String nombreProducto, List<Deducible> listDeducible) {
        super();
        this.nombreProducto = nombreProducto;
        this.listDeducible = listDeducible;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<Deducible> getListDeducible() {
        return listDeducible;
    }

    public void setListDeducible(List<Deducible> listDeducible) {
        this.listDeducible = listDeducible;
    }

}
