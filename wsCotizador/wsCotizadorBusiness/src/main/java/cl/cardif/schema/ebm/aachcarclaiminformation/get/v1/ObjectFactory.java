
package cl.cardif.schema.ebm.aachcarclaiminformation.get.v1;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cl.cardif.schema.ebm.aachcarclaiminformation.get.v1 package. 
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

    private final static QName _GetAACHCarClaimInformationFRSP_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "get_AACHCarClaimInformation_FRSP");
    private final static QName _GetListCarClaimResponse_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "getListCarClaimResponse");
    private final static QName _GetAACHCarClaimInformation_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "getAACHCarClaimInformation");
    private final static QName _GetAACHCarClaimInformationRSP_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "get_AACHCarClaimInformation_RSP");
    private final static QName _ErrorResponse_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "errorResponse");
    private final static QName _GetAACHCarClaimInformationREQ_QNAME = new QName("http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", "get_AACHCarClaimInformation_REQ");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cl.cardif.schema.ebm.aachcarclaiminformation.get.v1
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationFRSPType }
     * 
     */
    public GetAACHCarClaimInformationFRSPType createGetAACHCarClaimInformationFRSPType() {
        return new GetAACHCarClaimInformationFRSPType();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationREQType }
     * 
     */
    public GetAACHCarClaimInformationREQType createGetAACHCarClaimInformationREQType() {
        return new GetAACHCarClaimInformationREQType();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationRSPType }
     * 
     */
    public GetAACHCarClaimInformationRSPType createGetAACHCarClaimInformationRSPType() {
        return new GetAACHCarClaimInformationRSPType();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformation }
     * 
     */
    public GetAACHCarClaimInformation createGetAACHCarClaimInformation() {
        return new GetAACHCarClaimInformation();
    }

    /**
     * Create an instance of {@link GetListCarClaimResponse }
     * 
     */
    public GetListCarClaimResponse createGetListCarClaimResponse() {
        return new GetListCarClaimResponse();
    }

    /**
     * Create an instance of {@link ErrorResponse }
     * 
     */
    public ErrorResponse createErrorResponse() {
        return new ErrorResponse();
    }

    /**
     * Create an instance of {@link ResponseType }
     * 
     */
    public ResponseType createResponseType() {
        return new ResponseType();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationFRSPType.Body }
     * 
     */
    public GetAACHCarClaimInformationFRSPType.Body createGetAACHCarClaimInformationFRSPTypeBody() {
        return new GetAACHCarClaimInformationFRSPType.Body();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationREQType.Body }
     * 
     */
    public GetAACHCarClaimInformationREQType.Body createGetAACHCarClaimInformationREQTypeBody() {
        return new GetAACHCarClaimInformationREQType.Body();
    }

    /**
     * Create an instance of {@link GetAACHCarClaimInformationRSPType.Body }
     * 
     */
    public GetAACHCarClaimInformationRSPType.Body createGetAACHCarClaimInformationRSPTypeBody() {
        return new GetAACHCarClaimInformationRSPType.Body();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAACHCarClaimInformationFRSPType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "get_AACHCarClaimInformation_FRSP")
    public JAXBElement<GetAACHCarClaimInformationFRSPType> createGetAACHCarClaimInformationFRSP(GetAACHCarClaimInformationFRSPType value) {
        return new JAXBElement<GetAACHCarClaimInformationFRSPType>(_GetAACHCarClaimInformationFRSP_QNAME, GetAACHCarClaimInformationFRSPType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetListCarClaimResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "getListCarClaimResponse")
    public JAXBElement<GetListCarClaimResponse> createGetListCarClaimResponse(GetListCarClaimResponse value) {
        return new JAXBElement<GetListCarClaimResponse>(_GetListCarClaimResponse_QNAME, GetListCarClaimResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAACHCarClaimInformation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "getAACHCarClaimInformation")
    public JAXBElement<GetAACHCarClaimInformation> createGetAACHCarClaimInformation(GetAACHCarClaimInformation value) {
        return new JAXBElement<GetAACHCarClaimInformation>(_GetAACHCarClaimInformation_QNAME, GetAACHCarClaimInformation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAACHCarClaimInformationRSPType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "get_AACHCarClaimInformation_RSP")
    public JAXBElement<GetAACHCarClaimInformationRSPType> createGetAACHCarClaimInformationRSP(GetAACHCarClaimInformationRSPType value) {
        return new JAXBElement<GetAACHCarClaimInformationRSPType>(_GetAACHCarClaimInformationRSP_QNAME, GetAACHCarClaimInformationRSPType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ErrorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "errorResponse")
    public JAXBElement<ErrorResponse> createErrorResponse(ErrorResponse value) {
        return new JAXBElement<ErrorResponse>(_ErrorResponse_QNAME, ErrorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAACHCarClaimInformationREQType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0", name = "get_AACHCarClaimInformation_REQ")
    public JAXBElement<GetAACHCarClaimInformationREQType> createGetAACHCarClaimInformationREQ(GetAACHCarClaimInformationREQType value) {
        return new JAXBElement<GetAACHCarClaimInformationREQType>(_GetAACHCarClaimInformationREQ_QNAME, GetAACHCarClaimInformationREQType.class, null, value);
    }

}
