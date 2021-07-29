package cl.cardif.cotizador.wsCotizador.dto;

import java.io.Serializable;
import java.util.Date;

public class ParametrosCotizador implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id socio.
     */
    private int channel;
    /**
     * id Intermediario
     */
    private Long intermediate;
    /**
     * Codigo de producto
     */
    private Long productCode;
    /**
     * Rut asegurado.
     */
    private String insuredRut;
    /**
     * Marca.
     */
    private Long brand;
    /**
     * Modelo
     */
    private Long model;
    /**
     * Version
     */
    private Long version;
    /**
     * A;
     */
    private Long year;
    /**
     * Fecha de nacimiento.
     */
    private Date dateOfBirth;
    /**
     * Sexo
     */
    private String gender;
    /**
     * Region.
     */
    private Long state;
    /**
     * Comuna.
     */
    private Long city;
    /**
     * Patente.
     */
    private String plate;
    /**
     * Estado civil.
     */
    private String maritalStatus;
    /**
     * identificador de cotizacion del intermediario
     */
    private String idQuoteIntermediate;
    /**
     * Nombres del asegurado.
     */
    private String insuredNames;

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("ParametrosCotizador: channel[").append(channel);
        sb.append("], intermediate[").append(intermediate);
        sb.append("], productoCode[").append(productCode);
        sb.append("], insuredRut[").append(insuredRut);
        sb.append("], brand[").append(brand);
        sb.append("], model[").append(model);
        sb.append("], version[").append(version);
        sb.append("], year[").append(year);
        sb.append("], dateOfBirth[").append(dateOfBirth);
        sb.append("], gender[").append(gender);
        sb.append("], state[").append(state);
        sb.append("], city[").append(city);
        sb.append("], plate[").append(plate);
        sb.append("], maritalStatus[").append(maritalStatus);
        sb.append("], idQuoteIntermediate[").append(idQuoteIntermediate);
        sb.append("], insuredNames[").append(insuredNames);
        sb.append("], hashCode[").append(this.hashCode());
        sb.append("]");
        return sb.toString();
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public Long getIntermediate() {
        return intermediate;
    }

    public void setIntermediate(Long intermediate) {
        this.intermediate = intermediate;
    }

    public Long getProductoCode() {
        return productCode;
    }

    public void setProductoCode(Long productCode) {
        this.productCode = productCode;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getInsuredNames() {
        return insuredNames;
    }

    public void setInsuredNames(String insuredNames) {
        this.insuredNames = insuredNames;
    }

    public String getIdQuoteIntermediate() {
        return idQuoteIntermediate;
    }

    public void setIdQuoteIntermediate(String idQuoteIntermediate) {
        this.idQuoteIntermediate = idQuoteIntermediate;
    }

}
