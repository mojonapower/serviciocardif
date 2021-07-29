package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;
import java.util.Date;

public class Usuario implements Serializable {

    /**
     * Id Serializacion.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Id usuario.
     */
    private Long idUsuario;
    /**
     * id ldap usuario.
     */
    private String idUsuarioCardif;
    /**
     * nombre del usuario.
     */
    private String nombreUsuario;
    /**
     * apellido usuario.
     */
    private String apellidoUsuario;
    /**
     * estado usuario.
     */
    private Integer estadoUsuario;
    /**
     * bandera autentificacion SW.
     */
    private Boolean autenticado;
    /**
     * fecha de creacion del usuario.
     */
    private Date fechaCreacion;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public Integer getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Integer estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Date getFechaCreacion() {
        Date fecha = null;
        if(fechaCreacion!=null){
            fecha = (Date)fechaCreacion.clone();
        }
        return fecha;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Boolean getAutenticado() {
        return autenticado;
    }

    public void setAutenticado(Boolean autenticado) {
        this.autenticado = autenticado;
    }

    /**
     * @return the idUsuarioCardif
     */
    public String getIdUsuarioCardif() {
        return idUsuarioCardif;
    }

    /**
     * @param idUsuarioCardif
     *            the idUsuarioCardif to set
     */
    public void setIdUsuarioCardif(String idUsuarioCardif) {
        this.idUsuarioCardif = idUsuarioCardif;
    }

}
