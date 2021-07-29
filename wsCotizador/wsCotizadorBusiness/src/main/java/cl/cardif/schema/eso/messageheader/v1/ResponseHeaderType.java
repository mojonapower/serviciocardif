
package cl.cardif.schema.eso.messageheader.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import cl.cardif.schema.eso.result.v1.ResultType;


/**
 * 
 * 				It represents important metadata related to the
 * 				execution of a certain service operation, during its
 * 				response.
 * 			
 * 
 * <p>Clase Java para ResponseHeader_Type complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ResponseHeader_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://cardif.cl/Schema/ESO/MessageHeader/v1.0}MessageHeader_Type">
 *       &lt;sequence>
 *         &lt;element ref="{http://cardif.cl/Schema/ESO/Result/v1.0}Result"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseHeader_Type", propOrder = {
    "result"
})
public class ResponseHeaderType
    extends MessageHeaderType
{

    @XmlElement(name = "Result", namespace = "http://cardif.cl/Schema/ESO/Result/v1.0", required = true)
    protected ResultType result;

    /**
     * Result information related to this response.
     * 
     * @return
     *     possible object is
     *     {@link ResultType }
     *     
     */
    public ResultType getResult() {
        return result;
    }

    /**
     * Define el valor de la propiedad result.
     * 
     * @param value
     *     allowed object is
     *     {@link ResultType }
     *     
     */
    public void setResult(ResultType value) {
        this.result = value;
    }

}
