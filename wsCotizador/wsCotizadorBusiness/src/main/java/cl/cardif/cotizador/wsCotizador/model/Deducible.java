package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Deducible implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    private Long idDeducible;
    private Long nombreDeducible;
    private String nombreProducto;
    private Double tarifaBase;

    public Deducible() {
        super();
    }

    public Deducible(Long idDeducible, Long nombreDeducible, String nombreProducto, Double tarifaBase) {
        super();
        this.idDeducible = idDeducible;
        this.nombreDeducible = nombreDeducible;
        this.nombreProducto = nombreProducto;
        this.tarifaBase = tarifaBase;
    }

    public Long getNombreDeducible() {
        return nombreDeducible;
    }

    public void setNombreDeducible(Long nombreDeducible) {
        this.nombreDeducible = nombreDeducible;
    }

    public Long getIdDeducible() {
        return idDeducible;
    }

    public void setIdDeducible(Long idDeducible) {
        this.idDeducible = idDeducible;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(Double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

}
