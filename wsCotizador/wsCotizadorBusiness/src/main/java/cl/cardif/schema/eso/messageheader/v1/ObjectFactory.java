
package cl.cardif.schema.eso.messageheader.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.cardif.schema.eso.messageheader.v1 package. 
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

    private final static QName _Service_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Service");
    private final static QName _ResponseHeader_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "ResponseHeader");
    private final static QName _Channel_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Channel");
    private final static QName _RequestHeader_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "RequestHeader");
    private final static QName _Country_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Country");
    private final static QName _Credentials_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Credentials");
    private final static QName _Trace_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Trace");
    private final static QName _Consumer_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "Consumer");
    private final static QName _QoS_QNAME = new QName("http://cardif.cl/Schema/ESO/MessageHeader/v1.0", "QoS");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.cardif.schema.eso.messageheader.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TraceType }
     * 
     */
    public TraceType createTraceType() {
        return new TraceType();
    }

    /**
     * Create an instance of {@link ResponseHeaderType }
     * 
     */
    public ResponseHeaderType createResponseHeaderType() {
        return new ResponseHeaderType();
    }

    /**
     * Create an instance of {@link ConsumerType }
     * 
     */
    public ConsumerType createConsumerType() {
        return new ConsumerType();
    }

    /**
     * Create an instance of {@link QoSType }
     * 
     */
    public QoSType createQoSType() {
        return new QoSType();
    }

    /**
     * Create an instance of {@link ChannelType }
     * 
     */
    public ChannelType createChannelType() {
        return new ChannelType();
    }

    /**
     * Create an instance of {@link RequestHeaderType }
     * 
     */
    public RequestHeaderType createRequestHeaderType() {
        return new RequestHeaderType();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link CountryType }
     * 
     */
    public CountryType createCountryType() {
        return new CountryType();
    }

    /**
     * Create an instance of {@link CredentialsType }
     * 
     */
    public CredentialsType createCredentialsType() {
        return new CredentialsType();
    }

    /**
     * Create an instance of {@link MessageHeaderType }
     * 
     */
    public MessageHeaderType createMessageHeaderType() {
        return new MessageHeaderType();
    }

    /**
     * Create an instance of {@link TraceType.Component }
     * 
     */
    public TraceType.Component createTraceTypeComponent() {
        return new TraceType.Component();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Service")
    public JAXBElement<ServiceType> createService(ServiceType value) {
        return new JAXBElement<ServiceType>(_Service_QNAME, ServiceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ResponseHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "ResponseHeader")
    public JAXBElement<ResponseHeaderType> createResponseHeader(ResponseHeaderType value) {
        return new JAXBElement<ResponseHeaderType>(_ResponseHeader_QNAME, ResponseHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ChannelType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Channel")
    public JAXBElement<ChannelType> createChannel(ChannelType value) {
        return new JAXBElement<ChannelType>(_Channel_QNAME, ChannelType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestHeaderType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "RequestHeader")
    public JAXBElement<RequestHeaderType> createRequestHeader(RequestHeaderType value) {
        return new JAXBElement<RequestHeaderType>(_RequestHeader_QNAME, RequestHeaderType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CountryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Country")
    public JAXBElement<CountryType> createCountry(CountryType value) {
        return new JAXBElement<CountryType>(_Country_QNAME, CountryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CredentialsType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Credentials")
    public JAXBElement<CredentialsType> createCredentials(CredentialsType value) {
        return new JAXBElement<CredentialsType>(_Credentials_QNAME, CredentialsType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TraceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Trace")
    public JAXBElement<TraceType> createTrace(TraceType value) {
        return new JAXBElement<TraceType>(_Trace_QNAME, TraceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsumerType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "Consumer")
    public JAXBElement<ConsumerType> createConsumer(ConsumerType value) {
        return new JAXBElement<ConsumerType>(_Consumer_QNAME, ConsumerType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QoSType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/ESO/MessageHeader/v1.0", name = "QoS")
    public JAXBElement<QoSType> createQoS(QoSType value) {
        return new JAXBElement<QoSType>(_QoS_QNAME, QoSType.class, null, value);
    }

}
