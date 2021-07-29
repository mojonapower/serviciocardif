
package cl.cardif.schema.eso.dictionary.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Local identity profile regarding a particular execution. Used to profile a certain execution, used mainly for audit and trace operations.
 * 
 * <p>Clase Java para ExecutionProfile_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ExecutionProfile_Type">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="Type">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Inbound"/>
 *             &lt;enumeration value="Outbound"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Initiator">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Component"/>
 *             &lt;enumeration value="Service"/>
 *             &lt;enumeration value="ExtConsumer"/>
 *             &lt;enumeration value="IntConsumer"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="Controller">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Component"/>
 *             &lt;enumeration value="Service"/>
 *             &lt;enumeration value="ExtProvider"/>
 *             &lt;enumeration value="IntProvider"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExecutionProfile_Type")
public class ExecutionProfileType {

    @XmlAttribute(name = "Type")
    protected String type;
    @XmlAttribute(name = "Initiator")
    protected String initiator;
    @XmlAttribute(name = "Controller")
    protected String controller;

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad initiator.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiator() {
        return initiator;
    }

    /**
     * Define el valor de la propiedad initiator.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiator(String value) {
        this.initiator = value;
    }

    /**
     * Obtiene el valor de la propiedad controller.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getController() {
        return controller;
    }

    /**
     * Define el valor de la propiedad controller.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setController(String value) {
        this.controller = value;
    }

}
