
package cl.cardif.schema.eso.messageheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				It represents important metadata related to the
 * 				execution of a certain service operation, during its
 * 				original request, propagation and final response.
 * 			
 * 
 * <p>Clase Java para MessageHeader_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="MessageHeader_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}Consumer"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}Trace"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}Country"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}Channel"/>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}QoS" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MessageHeader_Type", propOrder = {
    "consumer",
    "trace",
    "country",
    "channel",
    "qoS"
})
@XmlSeeAlso({
    ResponseHeaderType.class,
    RequestHeaderType.class
})
public class MessageHeaderType {

    @XmlElement(name = "Consumer", required = true)
    protected ConsumerType consumer;
    @XmlElement(name = "Trace", required = true)
    protected TraceType trace;
    @XmlElement(name = "Country", required = true)
    protected CountryType country;
    @XmlElement(name = "Channel", required = true)
    protected ChannelType channel;
    @XmlElement(name = "QoS")
    protected QoSType qoS;

    /**
     * Obtiene el valor de la propiedad consumer.
     * 
     * @return
     *     possible object is
     *     {@link ConsumerType }
     *     
     */
    public ConsumerType getConsumer() {
        return consumer;
    }

    /**
     * Define el valor de la propiedad consumer.
     * 
     * @param value
     *     allowed object is
     *     {@link ConsumerType }
     *     
     */
    public void setConsumer(ConsumerType value) {
        this.consumer = value;
    }

    /**
     * Obtiene el valor de la propiedad trace.
     * 
     * @return
     *     possible object is
     *     {@link TraceType }
     *     
     */
    public TraceType getTrace() {
        return trace;
    }

    /**
     * Define el valor de la propiedad trace.
     * 
     * @param value
     *     allowed object is
     *     {@link TraceType }
     *     
     */
    public void setTrace(TraceType value) {
        this.trace = value;
    }

    /**
     * Obtiene el valor de la propiedad country.
     * 
     * @return
     *     possible object is
     *     {@link CountryType }
     *     
     */
    public CountryType getCountry() {
        return country;
    }

    /**
     * Define el valor de la propiedad country.
     * 
     * @param value
     *     allowed object is
     *     {@link CountryType }
     *     
     */
    public void setCountry(CountryType value) {
        this.country = value;
    }

    /**
     * Obtiene el valor de la propiedad channel.
     * 
     * @return
     *     possible object is
     *     {@link ChannelType }
     *     
     */
    public ChannelType getChannel() {
        return channel;
    }

    /**
     * Define el valor de la propiedad channel.
     * 
     * @param value
     *     allowed object is
     *     {@link ChannelType }
     *     
     */
    public void setChannel(ChannelType value) {
        this.channel = value;
    }

    /**
     * Obtiene el valor de la propiedad qoS.
     * 
     * @return
     *     possible object is
     *     {@link QoSType }
     *     
     */
    public QoSType getQoS() {
        return qoS;
    }

    /**
     * Define el valor de la propiedad qoS.
     * 
     * @param value
     *     allowed object is
     *     {@link QoSType }
     *     
     */
    public void setQoS(QoSType value) {
        this.qoS = value;
    }

}
