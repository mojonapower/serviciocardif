
package cl.cardif.schema.ebm.usuario.autenticar.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cl.cardif.schema.eso.messageheader.v1.ResponseHeaderType;


/**
 * <p>Clase Java para autenticar_Usuario_RSP_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="autenticar_Usuario_RSP_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}ResponseHeader"/>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}autenticarResponse"/>
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
@XmlType(name = "autenticar_Usuario_RSP_Type", propOrder = {
    "responseHeader",
    "body"
})
public class AutenticarUsuarioRSPType {

    @XmlElement(name = "ResponseHeader", namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", required = true)
    protected ResponseHeaderType responseHeader;
    @XmlElement(name = "Body", required = true)
    protected AutenticarUsuarioRSPType.Body body;

    /**
     * Obtiene el valor de la propiedad responseHeader.
     * 
     * @return
     *     possible object is
     *     {@link ResponseHeaderType }
     *     
     */
    public ResponseHeaderType getResponseHeader() {
        return responseHeader;
    }

    /**
     * Define el valor de la propiedad responseHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseHeaderType }
     *     
     */
    public void setResponseHeader(ResponseHeaderType value) {
        this.responseHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad body.
     * 
     * @return
     *     possible object is
     *     {@link AutenticarUsuarioRSPType.Body }
     *     
     */
    public AutenticarUsuarioRSPType.Body getBody() {
        return body;
    }

    /**
     * Define el valor de la propiedad body.
     * 
     * @param value
     *     allowed object is
     *     {@link AutenticarUsuarioRSPType.Body }
     *     
     */
    public void setBody(AutenticarUsuarioRSPType.Body value) {
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
     *         &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}autenticarResponse"/>
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
        "autenticarResponse"
    })
    public static class Body {

        @XmlElement(required = true)
        protected AutenticarResponse autenticarResponse;

        /**
         * Obtiene el valor de la propiedad autenticarResponse.
         * 
         * @return
         *     possible object is
         *     {@link AutenticarResponse }
         *     
         */
        public AutenticarResponse getAutenticarResponse() {
            return autenticarResponse;
        }

        /**
         * Define el valor de la propiedad autenticarResponse.
         * 
         * @param value
         *     allowed object is
         *     {@link AutenticarResponse }
         *     
         */
        public void setAutenticarResponse(AutenticarResponse value) {
            this.autenticarResponse = value;
        }

    }

}
