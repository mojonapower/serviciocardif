
package cl.cardif.schema.ebm.usuario.autenticar.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cl.cardif.schema.eso.messageheader.v1.RequestHeaderType;


/**
 * <p>Clase Java para autenticar_Usuario_REQ_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="autenticar_Usuario_REQ_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}RequestHeader"/>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}autenticar"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "autenticar_Usuario_REQ_Type", propOrder = {
    "requestHeader",
    "body"
})
public class AutenticarUsuarioREQType {

    @XmlElement(name = "RequestHeader", namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", required = true)
    protected RequestHeaderType requestHeader;
    @XmlElement(name = "Body", required = true)
    protected AutenticarUsuarioREQType.Body body;

    /**
     * Obtiene el valor de la propiedad requestHeader.
     * 
     * @return
     *     possible object is
     *     {@link RequestHeaderType }
     *     
     */
    public RequestHeaderType getRequestHeader() {
        return requestHeader;
    }

    /**
     * Define el valor de la propiedad requestHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link RequestHeaderType }
     *     
     */
    public void setRequestHeader(RequestHeaderType value) {
        this.requestHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad body.
     * 
     * @return
     *     possible object is
     *     {@link AutenticarUsuarioREQType.Body }
     *     
     */
    public AutenticarUsuarioREQType.Body getBody() {
        return body;
    }

    /**
     * Define el valor de la propiedad body.
     * 
     * @param value
     *     allowed object is
     *     {@link AutenticarUsuarioREQType.Body }
     *     
     */
    public void setBody(AutenticarUsuarioREQType.Body value) {
        this.body = value;
    }


    /**
     * <p>Clase Java para anonymous complex type.
     * 
     * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}autenticar"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "autenticar"
    })
    public static class Body {

        @XmlElement(required = true)
        protected Autenticar autenticar;

        /**
         * Obtiene el valor de la propiedad autenticar.
         * 
         * @return
         *     possible object is
         *     {@link Autenticar }
         *     
         */
        public Autenticar getAutenticar() {
            return autenticar;
        }

        /**
         * Define el valor de la propiedad autenticar.
         * 
         * @param value
         *     allowed object is
         *     {@link Autenticar }
         *     
         */
        public void setAutenticar(Autenticar value) {
            this.autenticar = value;
        }

    }

}
