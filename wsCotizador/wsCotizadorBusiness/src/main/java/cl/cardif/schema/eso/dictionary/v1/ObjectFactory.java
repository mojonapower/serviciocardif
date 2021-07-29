
package cl.cardif.schema.eso.dictionary.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.cardif.schema.eso.dictionary.v1 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _JMSHeader_QNAME = new QName("http://cardif.cl/Schema/ESO/Dictionary/v1.0", "JMSHeader");
    private final static QName _HTTPHeader_QNAME = new QName("http://cardif.cl/Schema/ESO/Dictionary/v1.0", "HTTPHeader");
    private final static QName _SOAPHeader_QNAME = new QName("http://cardif.cl/Schema/ESO/Dictionary/v1.0", "SOAPHeader");
    private final static QName _ExecutionProfile_QNAME = new QName("http://cardif.cl/Schema/ESO/Dictionary/v1.0", "ExecutionProfile");
    private final static QName _TransportHeaders_QNAME = new QName("http://cardif.cl/Schema/ESO/Dictionary/v1.0", "TransportHeaders");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.cardif.schema.eso.dictionary.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TransportHeadersType }
     * 
     */
    public TransportHeadersType createTransportHeadersType() {
        return new TransportHeadersType();
    }

    /**
     * Create an instance of {@link JMSHeaderType }
     * 
     */
    public JMSHeaderType createJMSHeaderType() {
        return new JMSHeaderType();
    }

    /**
     * Create an instance of {@link ExecutionProfileType }
     * 
     */
    public ExecutionProfileType createExecutionProfileType() {
        return new ExecutionProfileType();
    }

    /**
     * Create an instance of {@link HTTPHeaderType }
     * 
     */
    public HTTPHeaderType createHTTPHeaderType() {
        return new HTTPHeaderType();
    }

    /**
     * Create an instance of {@link SOAPHeaderType }
     * 
     */
    public SOAPHeaderType createSOAPHeaderType() {
        return new SOAPHeaderType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JMSHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/Dictionary/v1.0", name = "JMSHeader")
    public JAXBElement<JMSHeaderType> createJMSHeader(JMSHeaderType value) {
        return new JAXBElement<JMSHeaderType>(_JMSHeader_QNAME, JMSHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link HTTPHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/Dictionary/v1.0", name = "HTTPHeader")
    public JAXBElement<HTTPHeaderType> createHTTPHeader(HTTPHeaderType value) {
        return new JAXBElement<HTTPHeaderType>(_HTTPHeader_QNAME, HTTPHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SOAPHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/Dictionary/v1.0", name = "SOAPHeader")
    public JAXBElement<SOAPHeaderType> createSOAPHeader(SOAPHeaderType value) {
        return new JAXBElement<SOAPHeaderType>(_SOAPHeader_QNAME, SOAPHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutionProfileType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/Dictionary/v1.0", name = "ExecutionProfile")
    public JAXBElement<ExecutionProfileType> createExecutionProfile(ExecutionProfileType value) {
        return new JAXBElement<ExecutionProfileType>(_ExecutionProfile_QNAME, ExecutionProfileType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TransportHeadersType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/Dictionary/v1.0", name = "TransportHeaders")
    public JAXBElement<TransportHeadersType> createTransportHeaders(TransportHeadersType value) {
        return new JAXBElement<TransportHeadersType>(_TransportHeaders_QNAME, TransportHeadersType.class, null, value);
    }

}
