package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Equifax implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    private String rut;
    private String nombre;
    private String fechaNacimiento;
    private String sexo;
    private String estadoCivil;
    private String profecionOficio;
    private int cantiadHijos;
    private String banco;
    private String glosaGse;
    private String calleParticular;
    private String numeroParticular;
    private String tipoPropiedadParticular;
    private String numeroPropiedadParticular;
    private String restoDireccionParticular;
    private String comunaParticular;
    private String ciudadParticular;
    private String regionParticular;
    private int codProfesion;
    private int codGse;

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getProfecionOficio() {
        return profecionOficio;
    }

    public void setProfecionOficio(String profecionOficio) {
        this.profecionOficio = profecionOficio;
    }

    public int getCantiadHijos() {
        return cantiadHijos;
    }

    public void setCantiadHijos(int cantiadHijos) {
        this.cantiadHijos = cantiadHijos;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getGlosaGse() {
        return glosaGse;
    }

    public void setGlosaGse(String glosaGse) {
        this.glosaGse = glosaGse;
    }

    public String getCalleParticular() {
        return calleParticular;
    }

    public void setCalleParticular(String calleParticular) {
        this.calleParticular = calleParticular;
    }

    public String getNumeroParticular() {
        return numeroParticular;
    }

    public void setNumeroParticular(String numeroParticular) {
        this.numeroParticular = numeroParticular;
    }

    public String getTipoPropiedadParticular() {
        return tipoPropiedadParticular;
    }

    public void setTipoPropiedadParticular(String tipoPropiedadParticular) {
        this.tipoPropiedadParticular = tipoPropiedadParticular;
    }

    public String getNumeroPropiedadParticular() {
        return numeroPropiedadParticular;
    }

    public void setNumeroPropiedadParticular(String numeroPropiedadParticular) {
        this.numeroPropiedadParticular = numeroPropiedadParticular;
    }

    public String getRestoDireccionParticular() {
        return restoDireccionParticular;
    }

    public void setRestoDireccionParticular(String restoDireccionParticular) {
        this.restoDireccionParticular = restoDireccionParticular;
    }

    public String getComunaParticular() {
        return comunaParticular;
    }

    public void setComunaParticular(String comunaParticular) {
        this.comunaParticular = comunaParticular;
    }

    public String getCiudadParticular() {
        return ciudadParticular;
    }

    public void setCiudadParticular(String ciudadParticular) {
        this.ciudadParticular = ciudadParticular;
    }

    public String getRegionParticular() {
        return regionParticular;
    }

    public void setRegionParticular(String regionParticular) {
        this.regionParticular = regionParticular;
    }

    public int getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(int codProfesion) {
        this.codProfesion = codProfesion;
    }

    public int getCodGse() {
        return codGse;
    }

    public void setCodGse(int codGse) {
        this.codGse = codGse;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Equifax [rut=");
        builder.append(rut);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append(", fechaNacimiento=");
        builder.append(fechaNacimiento);
        builder.append(", sexo=");
        builder.append(sexo);
        builder.append(", estadoCivil=");
        builder.append(estadoCivil);
        builder.append(", profecionOficio=");
        builder.append(profecionOficio);
        builder.append(", cantiadHijos=");
        builder.append(cantiadHijos);
        builder.append(", banco=");
        builder.append(banco);
        builder.append(", glosaGse=");
        builder.append(glosaGse);
        builder.append(", calleParticular=");
        builder.append(calleParticular);
        builder.append(", numeroParticular=");
        builder.append(numeroParticular);
        builder.append(", tipoPropiedadParticular=");
        builder.append(tipoPropiedadParticular);
        builder.append(", numeroPropiedadParticular=");
        builder.append(numeroPropiedadParticular);
        builder.append(", restoDireccionParticular=");
        builder.append(restoDireccionParticular);
        builder.append(", comunaParticular=");
        builder.append(comunaParticular);
        builder.append(", ciudadParticular=");
        builder.append(ciudadParticular);
        builder.append(", regionParticular=");
        builder.append(regionParticular);
        builder.append(", codProfesion=");
        builder.append(codProfesion);
        builder.append(", codGse=");
        builder.append(codGse);
        builder.append("]");
        return builder.toString();
    }

}
