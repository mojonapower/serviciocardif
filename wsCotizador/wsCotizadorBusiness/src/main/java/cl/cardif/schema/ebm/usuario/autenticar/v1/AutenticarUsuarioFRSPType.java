
package cl.cardif.schema.ebm.usuario.autenticar.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cl.cardif.schema.eso.messageheader.v1.ResponseHeaderType;


/**
 * <p>Clase Java para autenticar_Usuario_FRSP_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="autenticar_Usuario_FRSP_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}ResponseHeader"/>
 *         &lt;element name="Body">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}errorResponse"/>
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
@XmlType(name = "autenticar_Usuario_FRSP_Type", propOrder = {
    "responseHeader",
    "body"
})
public class AutenticarUsuarioFRSPType {

    @XmlElement(name = "ResponseHeader", namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", required = true)
    protected ResponseHeaderType responseHeader;
    @XmlElement(name = "Body", required = true)
    protected AutenticarUsuarioFRSPType.Body body;

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
     *     {@link AutenticarUsuarioFRSPType.Body }
     *     
     */
    public AutenticarUsuarioFRSPType.Body getBody() {
        return body;
    }

    /**
     * Define el valor de la propiedad body.
     * 
     * @param value
     *     allowed object is
     *     {@link AutenticarUsuarioFRSPType.Body }
     *     
     */
    public void setBody(AutenticarUsuarioFRSPType.Body value) {
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
     *         &lt;element ref="{http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0}errorResponse"/>
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
        "errorResponse"
    })
    public static class Body {

        @XmlElement(required = true)
        protected ErrorResponse errorResponse;

        /**
         * Obtiene el valor de la propiedad errorResponse.
         * 
         * @return
         *     possible object is
         *     {@link ErrorResponse }
         *     
         */
        public ErrorResponse getErrorResponse() {
            return errorResponse;
        }

        /**
         * Define el valor de la propiedad errorResponse.
         * 
         * @param value
         *     allowed object is
         *     {@link ErrorResponse }
         *     
         */
        public void setErrorResponse(ErrorResponse value) {
            this.errorResponse = value;
        }

    }

}
