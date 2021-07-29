
package cl.cardif.schema.eso.messageheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				Information regarding the quality of service expected by
 * 				the Service Consumer, and that which is calculated
 * 				during the Service Operation Execution.
 * 			
 * 
 * <p>Clase Java para QoS_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="QoS_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ttl" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="priority" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="retryCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxRetryCount" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QoS_Type")
public class QoSType {

    @XmlAttribute(name = "ttl")
    protected Integer ttl;
    @XmlAttribute(name = "priority")
    protected Integer priority;
    @XmlAttribute(name = "retryCount")
    protected Integer retryCount;
    @XmlAttribute(name = "maxRetryCount")
    protected Integer maxRetryCount;

    /**
     * Obtiene el valor de la propiedad ttl.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTtl() {
        return ttl;
    }

    /**
     * Define el valor de la propiedad ttl.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTtl(Integer value) {
        this.ttl = value;
    }

    /**
     * Obtiene el valor de la propiedad priority.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     * Define el valor de la propiedad priority.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPriority(Integer value) {
        this.priority = value;
    }

    /**
     * Obtiene el valor de la propiedad retryCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * Define el valor de la propiedad retryCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRetryCount(Integer value) {
        this.retryCount = value;
    }

    /**
     * Obtiene el valor de la propiedad maxRetryCount.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRetryCount() {
        return maxRetryCount;
    }

    /**
     * Define el valor de la propiedad maxRetryCount.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRetryCount(Integer value) {
        this.maxRetryCount = value;
    }

}
