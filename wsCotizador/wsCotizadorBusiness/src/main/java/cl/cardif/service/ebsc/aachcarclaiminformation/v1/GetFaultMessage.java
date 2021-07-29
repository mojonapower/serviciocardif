
package cl.cardif.service.ebsc.aachcarclaiminformation.v1;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.0.1
 * 2021-07-29T12:41:18.026-04:00
 * Generated source version: 3.0.1
 */

@WebFault(name = "get_AACHCarClaimInformation_FRSP", targetNamespace = "http://cardif.cl/Schema/EBM/AACHCarClaimInformation/get/v1.0")
public class GetFaultMessage extends Exception {
    
    private cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationFRSPType getAACHCarClaimInformationFRSP;

    public GetFaultMessage() {
        super();
    }
    
    public GetFaultMessage(String message) {
        super(message);
    }
    
    public GetFaultMessage(String message, Throwable cause) {
        super(message, cause);
    }

    public GetFaultMessage(String message, cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationFRSPType getAACHCarClaimInformationFRSP) {
        super(message);
        this.getAACHCarClaimInformationFRSP = getAACHCarClaimInformationFRSP;
    }

    public GetFaultMessage(String message, cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationFRSPType getAACHCarClaimInformationFRSP, Throwable cause) {
        super(message, cause);
        this.getAACHCarClaimInformationFRSP = getAACHCarClaimInformationFRSP;
    }

    public cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationFRSPType getFaultInfo() {
        return this.getAACHCarClaimInformationFRSP;
    }
}