
package cl.cardif.schema.eso.dictionary.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Different structures related to transport
 * 				meta-information of several handled transports and
 * 				messaging protocols.
 * 			
 * 
 * <p>Clase Java para TransportHeaders_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="TransportHeaders_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/Dictionary/v1.0}HTTPHeader" minOccurs="0"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/Dictionary/v1.0}SOAPHeader" minOccurs="0"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/Dictionary/v1.0}JMSHeader" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransportHeaders_Type", propOrder = {
    "httpHeader",
    "soapHeader",
    "jmsHeader"
})
public class TransportHeadersType {

    @XmlElement(name = "HTTPHeader")
    protected HTTPHeaderType httpHeader;
    @XmlElement(name = "SOAPHeader")
    protected SOAPHeaderType soapHeader;
    @XmlElement(name = "JMSHeader")
    protected JMSHeaderType jmsHeader;

    /**
     * Obtiene el valor de la propiedad httpHeader.
     * 
     * @return
     *     possible object is
     *     {@link HTTPHeaderType }
     *     
     */
    public HTTPHeaderType getHTTPHeader() {
        return httpHeader;
    }

    /**
     * Define el valor de la propiedad httpHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link HTTPHeaderType }
     *     
     */
    public void setHTTPHeader(HTTPHeaderType value) {
        this.httpHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad soapHeader.
     * 
     * @return
     *     possible object is
     *     {@link SOAPHeaderType }
     *     
     */
    public SOAPHeaderType getSOAPHeader() {
        return soapHeader;
    }

    /**
     * Define el valor de la propiedad soapHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link SOAPHeaderType }
     *     
     */
    public void setSOAPHeader(SOAPHeaderType value) {
        this.soapHeader = value;
    }

    /**
     * Obtiene el valor de la propiedad jmsHeader.
     * 
     * @return
     *     possible object is
     *     {@link JMSHeaderType }
     *     
     */
    public JMSHeaderType getJMSHeader() {
        return jmsHeader;
    }

    /**
     * Define el valor de la propiedad jmsHeader.
     * 
     * @param value
     *     allowed object is
     *     {@link JMSHeaderType }
     *     
     */
    public void setJMSHeader(JMSHeaderType value) {
        this.jmsHeader = value;
    }

}
