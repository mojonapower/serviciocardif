package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Producto implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Id producto.
	 */
	private Integer id;

	/**
	 *  socio.
	 */
	private Socio socio;
	
	/**
	 * nombre producto.
	 */
	private String nombre;

	/**
	 * Estado. 1 Encendido - 0 apagado.
	 */
	private Integer estado;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the socio
	 */
	public Socio getSocio() {
		return socio;
	}

	/**
	 * @param socio the socio to set
	 */
	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the estado
	 */
	public Integer getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	

}
