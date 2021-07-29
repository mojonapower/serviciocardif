package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;

public class RutListaNegra extends Respuesta implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Rut.
	 */
	private Long rut;
	
	/**
	 * Valor factor.
	 */
	private Double valor;

	public Long getRut() {
		return rut;
	}

	public void setRut(Long rut) {
		this.rut = rut;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	

	
	
	
	

}
