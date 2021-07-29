package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "nombreProducto", "listadoTarifas" })
public class ProductoTO implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    private String nombreProducto;

    private List<Tarifa> listadoTarifas;

    public ProductoTO() {
        super();
    }

    public ProductoTO(String nombreProducto, List<Tarifa> listadoTarifas) {
        super();
        this.nombreProducto = nombreProducto;
        this.listadoTarifas = listadoTarifas;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Serializable: nombreProducto[").append(nombreProducto);
        sb.append("], listadoTarifas[").append(listadoTarifas);
        sb.append("], hashCode[").append(this.hashCode());
        sb.append("]");
        return sb.toString();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public List<Tarifa> getListadoTarifas() {
        return listadoTarifas;
    }

    public void setListadoTarifas(List<Tarifa> listadoTarifas) {
        this.listadoTarifas = listadoTarifas;
    }

}
