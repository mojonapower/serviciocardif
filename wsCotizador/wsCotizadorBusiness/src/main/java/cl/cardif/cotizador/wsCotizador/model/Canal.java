package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Canal implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id canal.
	 */
	private Integer id;

	/**
	 * Nombre socio.
	 */
	private String nombre;

	/**
	 * Estado. 1 Encendido - 0 apagado.
	 */
	private Integer estado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
