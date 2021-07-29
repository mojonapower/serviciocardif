
package cl.cardif.schema.ebm.usuario.autenticar.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.cardif.schema.ebm.usuario.autenticar.v1 package. 
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

    private final static QName _Autenticar_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "autenticar");
    private final static QName _AutenticarUsuarioRSP_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "autenticar_Usuario_RSP");
    private final static QName _AutenticarResponse_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "autenticarResponse");
    private final static QName _AutenticarUsuarioREQ_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "autenticar_Usuario_REQ");
    private final static QName _AutenticarUsuarioFRSP_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "autenticar_Usuario_FRSP");
    private final static QName _ErrorResponse_QNAME = new QName("http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", "errorResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.cardif.schema.ebm.usuario.autenticar.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AutenticarUsuarioFRSPType }
     * 
     */
    public AutenticarUsuarioFRSPType createAutenticarUsuarioFRSPType() {
        return new AutenticarUsuarioFRSPType();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioREQType }
     * 
     */
    public AutenticarUsuarioREQType createAutenticarUsuarioREQType() {
        return new AutenticarUsuarioREQType();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioRSPType }
     * 
     */
    public AutenticarUsuarioRSPType createAutenticarUsuarioRSPType() {
        return new AutenticarUsuarioRSPType();
    }

    /**
     * Create an instance of {@link Autenticar }
     * 
     */
    public Autenticar createAutenticar() {
        return new Autenticar();
    }

    /**
     * Create an instance of {@link AutenticarResponse }
     * 
     */
    public AutenticarResponse createAutenticarResponse() {
        return new AutenticarResponse();
    }

    /**
     * Create an instance of {@link ErrorResponse }
     * 
     */
    public ErrorResponse createErrorResponse() {
        return new ErrorResponse();
    }

    /**
     * Create an instance of {@link Respuesta }
     * 
     */
    public Respuesta createRespuesta() {
        return new Respuesta();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioFRSPType.Body }
     * 
     */
    public AutenticarUsuarioFRSPType.Body createAutenticarUsuarioFRSPTypeBody() {
        return new AutenticarUsuarioFRSPType.Body();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioREQType.Body }
     * 
     */
    public AutenticarUsuarioREQType.Body createAutenticarUsuarioREQTypeBody() {
        return new AutenticarUsuarioREQType.Body();
    }

    /**
     * Create an instance of {@link AutenticarUsuarioRSPType.Body }
     * 
     */
    public AutenticarUsuarioRSPType.Body createAutenticarUsuarioRSPTypeBody() {
        return new AutenticarUsuarioRSPType.Body();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autenticar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "autenticar")
    public JAXBElement<Autenticar> createAutenticar(Autenticar value) {
        return new JAXBElement<Autenticar>(_Autenticar_QNAME, Autenticar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUsuarioRSPType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "autenticar_Usuario_RSP")
    public JAXBElement<AutenticarUsuarioRSPType> createAutenticarUsuarioRSP(AutenticarUsuarioRSPType value) {
        return new JAXBElement<AutenticarUsuarioRSPType>(_AutenticarUsuarioRSP_QNAME, AutenticarUsuarioRSPType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "autenticarResponse")
    public JAXBElement<AutenticarResponse> createAutenticarResponse(AutenticarResponse value) {
        return new JAXBElement<AutenticarResponse>(_AutenticarResponse_QNAME, AutenticarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUsuarioREQType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "autenticar_Usuario_REQ")
    public JAXBElement<AutenticarUsuarioREQType> createAutenticarUsuarioREQ(AutenticarUsuarioREQType value) {
        return new JAXBElement<AutenticarUsuarioREQType>(_AutenticarUsuarioREQ_QNAME, AutenticarUsuarioREQType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticarUsuarioFRSPType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "autenticar_Usuario_FRSP")
    public JAXBElement<AutenticarUsuarioFRSPType> createAutenticarUsuarioFRSP(AutenticarUsuarioFRSPType value) {
        return new JAXBElement<AutenticarUsuarioFRSPType>(_AutenticarUsuarioFRSP_QNAME, AutenticarUsuarioFRSPType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/Usuario/autenticar/v1.0", name = "errorResponse")
    public JAXBElement<ErrorResponse> createErrorResponse(ErrorResponse value) {
        return new JAXBElement<ErrorResponse>(_ErrorResponse_QNAME, ErrorResponse.class, null, value);
    }

}
