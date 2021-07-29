package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class Respuesta implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Codigo de respuesta.
	 */
	private int codigo;
	
	/**
	 * Descripcion.
	 */
	private String descripcion;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
