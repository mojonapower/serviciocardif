package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;

public class GlosaVehiculoModelo implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 4636221713839746600L;

    private Integer codigo;

    private String descripcion;

    private String glosaMarca;

    private String glosaModelo;

    public String getGlosaMarca() {
        return glosaMarca;
    }

    public void setGlosaMarca(String glosaMarca) {
        this.glosaMarca = glosaMarca;
    }

    public String getGlosaModelo() {
        return glosaModelo;
    }

    public void setGlosaModelo(String glosaModelo) {
        this.glosaModelo = glosaModelo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("GlosaVehiculoModelo [codigo=");
        builder.append(codigo);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append(", glosaMarca=");
        builder.append(glosaMarca);
        builder.append(", glosaModelo=");
        builder.append(glosaModelo);
        builder.append("]");
        return builder.toString();
    }

}
