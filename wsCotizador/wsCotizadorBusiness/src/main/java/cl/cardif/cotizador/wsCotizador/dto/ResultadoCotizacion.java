package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.Date;

public class ResultadoCotizacion implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Identificador de intermediario.
     */
    private Long intermediate;
    /**
     * Identificador del canal.
     */
    private int channel;
    /**
     * Rut del asegurado.
     */
    private String insuredRut;
    /**
     * Identificador de la marca.
     */
    private Long brand;
    /**
     * Identificador del modelo.
     */
    private Long model;
    /**
     * Identificador de la version.
     */
    private Long version;
    /**
     * Año del auto.
     */
    private Long year;
    /**
     * Fecha de nacimiento.
     */
    private Date dateOfBirth;
    /**
     * Factor sisgen.
     */
    private Double sisgen;

    public ResultadoCotizacion() {
        super();
    }

    public ResultadoCotizacion(ParametrosCotizador parametros) {
        super();        
        this.intermediate = parametros.getIntermediate();
        this.channel = parametros.getChannel();
        this.insuredRut = parametros.getInsuredRut();
        this.brand = parametros.getBrand();
        this.model = parametros.getModel();
        this.version = parametros.getVersion();
        this.year = parametros.getYear();
        this.dateOfBirth = parametros.getDateOfBirth();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ResultadoCotizacion: intermediate[").append(intermediate);
        sb.append("], channel[").append(channel);
        sb.append("], insuredRut[").append(insuredRut);
        sb.append("], brand[").append(brand);
        sb.append("], model[").append(model);
        sb.append("], year[").append(year);
        sb.append("], dateOfBirth[").append(dateOfBirth);
        sb.append("], sisgen[").append(sisgen);
        sb.append("], hashCode[").append(this.hashCode());
        sb.append("]");
        return sb.toString();
    }

    public Long getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(Long intermediate) {
        this.intermediate = intermediate;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getInsuredRut() {
        return insuredRut;
    }

    public void setInsuredRut(String insuredRut) {
        this.insuredRut = insuredRut;
    }

    public Long getBrand() {
        return brand;
    }

    public void setBrand(Long brand) {
        this.brand = brand;
    }

    public Long getModel() {
        return model;
    }

    public void setModel(Long model) {
        this.model = model;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Date getDateOfBirth() {
        Date fecha = null;
        if(dateOfBirth!=null){
            fecha = (Date)dateOfBirth.clone();
        }
        return fecha;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getSisgen() {
        return sisgen;
    }

    public void setSisgen(Double sisgen) {
        this.sisgen = sisgen;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

}
