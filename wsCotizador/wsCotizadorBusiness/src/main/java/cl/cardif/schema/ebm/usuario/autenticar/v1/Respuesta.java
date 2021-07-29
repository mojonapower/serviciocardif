
package cl.cardif.schema.ebm.usuario.autenticar.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para respuesta complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="respuesta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuario_autenticado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "respuesta", propOrder = {
    "usuarioAutenticado"
})
public class Respuesta {

    @XmlElement(name = "usuario_autenticado")
    protected boolean usuarioAutenticado;

    /**
     * Obtiene el valor de la propiedad usuarioAutenticado.
     * 
     */
    public boolean isUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * Define el valor de la propiedad usuarioAutenticado.
     * 
     */
    public void setUsuarioAutenticado(boolean value) {
        this.usuarioAutenticado = value;
    }

}
