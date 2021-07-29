package cl.cardif.cotizador.wsCotizador.ws;


import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;
import cl.cardif.cotizador.wsCotizador.dto.SalidaCotizacion;
import cl.cardif.cotizador.wsCotizador.service.CotizadorService;
/**
 * 
 * Clase que permite exponer el servicio web del cotizador.
 * <p>
 * Registro de Versiones : <ul>
 * <li> 1.0 09-02-2016, (Imagemaker IT): Versión inicial</li>
 * </ul>
 * </p>
 * <p> 
 * <B>Todos los derechos reservados por BNP Paribas Cardif.</B>
 * </p>
 */
@WebService (serviceName ="WsCotizadorServiceWS")
@SOAPBinding(
                style=SOAPBinding.Style.DOCUMENT, 
                use=SOAPBinding.Use.LITERAL, 
                parameterStyle=SOAPBinding.ParameterStyle.WRAPPED)
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING) 
public class CotizadorServiceWSImpl {
    private final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private CotizadorService cotizadorService;
	
	 /**
     * PostConstruct.
     */
    @PostConstruct
	@WebMethod(exclude = true)
    public void init() {
    	logger.info("PostConstruct CotizadorServiceWSImpl");
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }
    
    /**
     * WebMetod que permite realizar una cotizacion.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li> 1.0 09-02-2016, (Imagemaker IT): versión inicial</li>
     * </ul>
     * </p> 
     * 
     * @param parametros listado de parametros de entrada.
     * @return SalidaCotizacion con las cotizaciones.
     * @since 1.0
     */
    @WebMethod
    @WebResult(name = "ResultadoCotizacion")
    public SalidaCotizacion cotizar(@WebParam(name = "parametrosCotizador") ParametrosCotizador parametros){    	
    	SalidaCotizacion datosSalida= null;
		try {
			datosSalida = cotizadorService.cotizar(parametros);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	
    	return datosSalida;
    }
}
