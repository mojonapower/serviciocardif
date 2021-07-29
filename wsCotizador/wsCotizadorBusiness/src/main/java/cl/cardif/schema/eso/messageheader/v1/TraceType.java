
package cl.cardif.schema.eso.messageheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 
 * 				Meta-Information related to traceability, which uniquely
 * 				identifies this particular execution.
 * 			
 * 
 * <p>Clase Java para Trace_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Trace_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}Service" minOccurs="0"/>
 *         &lt;element name="Component" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="reqTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="rspTimestamp" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="messageID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="correlationID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="conversationID" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Trace_Type", propOrder = {
    "service",
    "component"
})
public class TraceType {

    @XmlElement(name = "Service")
    protected ServiceType service;
    @XmlElement(name = "Component")
    protected TraceType.Component component;
    @XmlAttribute(name = "reqTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar reqTimestamp;
    @XmlAttribute(name = "rspTimestamp")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar rspTimestamp;
    @XmlAttribute(name = "messageID")
    protected Integer messageID;
    @XmlAttribute(name = "correlationID")
    protected Integer correlationID;
    @XmlAttribute(name = "conversationID")
    protected Integer conversationID;

    /**
     * 
     * 						Service that holds the control of the
     * 						execution. This is expected to change each time
     * 						a Service becomes statefull.
     * 					
     * 
     * @return
     *     possible object is
     *     {@link ServiceType }
     *     
     */
    public ServiceType getService() {
        return service;
    }

    /**
     * Define el valor de la propiedad service.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceType }
     *     
     */
    public void setService(ServiceType value) {
        this.service = value;
    }

    /**
     * Obtiene el valor de la propiedad component.
     * 
     * @return
     *     possible object is
     *     {@link TraceType.Component }
     *     
     */
    public TraceType.Component getComponent() {
        return component;
    }

    /**
     * Define el valor de la propiedad component.
     * 
     * @param value
     *     allowed object is
     *     {@link TraceType.Component }
     *     
     */
    public void setComponent(TraceType.Component value) {
        this.component = value;
    }

    /**
     * Obtiene el valor de la propiedad reqTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getReqTimestamp() {
        return reqTimestamp;
    }

    /**
     * Define el valor de la propiedad reqTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setReqTimestamp(XMLGregorianCalendar value) {
        this.reqTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad rspTimestamp.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRspTimestamp() {
        return rspTimestamp;
    }

    /**
     * Define el valor de la propiedad rspTimestamp.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRspTimestamp(XMLGregorianCalendar value) {
        this.rspTimestamp = value;
    }

    /**
     * Obtiene el valor de la propiedad messageID.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMessageID() {
        return messageID;
    }

    /**
     * Define el valor de la propiedad messageID.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMessageID(Integer value) {
        this.messageID = value;
    }

    /**
     * Obtiene el valor de la propiedad correlationID.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCorrelationID() {
        return correlationID;
    }

    /**
     * Define el valor de la propiedad correlationID.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCorrelationID(Integer value) {
        this.correlationID = value;
    }

    /**
     * Obtiene el valor de la propiedad conversationID.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getConversationID() {
        return conversationID;
    }

    /**
     * Define el valor de la propiedad conversationID.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setConversationID(Integer value) {
        this.conversationID = value;
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
     *       &lt;attribute name="code" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Component {

        @XmlAttribute(name = "code")
        protected String code;
        @XmlAttribute(name = "name")
        protected String name;

        /**
         * Obtiene el valor de la propiedad code.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCode() {
            return code;
        }

        /**
         * Define el valor de la propiedad code.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCode(String value) {
            this.code = value;
        }

        /**
         * Obtiene el valor de la propiedad name.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getName() {
            return name;
        }

        /**
         * Define el valor de la propiedad name.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setName(String value) {
            this.name = value;
        }

    }

}
