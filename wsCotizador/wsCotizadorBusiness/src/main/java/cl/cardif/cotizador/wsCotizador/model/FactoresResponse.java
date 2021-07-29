package cl.cardif.cotizador.wsCotizador.model;

import java.io.Serializable;
import java.util.List;

public class FactoresResponse implements Serializable {

	/**
	 * Id Serializacion.
	 */
	private static final long serialVersionUID = 1L;
    /**
     * Codigo.
     */
    private int codigo;
    
    /**
     * Descripcion.
     */
    private String descripcion;
    
    /**
     * Listado de factores.
     */
    private List<Factores> listadoFactores;
    

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

    public List<Factores> getListadoFactores() {
        return listadoFactores;
    }

    public void setListadoFactores(List<Factores> listadoFactores) {
        this.listadoFactores = listadoFactores;
    }


	
}
