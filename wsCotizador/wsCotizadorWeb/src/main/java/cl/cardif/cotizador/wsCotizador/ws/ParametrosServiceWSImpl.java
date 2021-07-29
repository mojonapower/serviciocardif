package cl.cardif.cotizador.wsCotizador.ws;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacion;
import cl.cardif.cotizador.wsCotizador.dto.GlosaVehiculoModelo;
import cl.cardif.cotizador.wsCotizador.dto.ListaFactoresDetalle;
import cl.cardif.cotizador.wsCotizador.model.Canal;
import cl.cardif.cotizador.wsCotizador.model.FactoresResponse;
import cl.cardif.cotizador.wsCotizador.model.Marca;
import cl.cardif.cotizador.wsCotizador.model.Modelo;
import cl.cardif.cotizador.wsCotizador.model.Producto;
import cl.cardif.cotizador.wsCotizador.model.Socio;
import cl.cardif.cotizador.wsCotizador.model.Usuario;
import cl.cardif.cotizador.wsCotizador.model.Version;
import cl.cardif.cotizador.wsCotizador.service.AdministradorParametrosService;
import cl.cardif.cotizador.wsCotizador.service.CotizadorService;

@WebService(serviceName = "WsParametrosCotizador")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class ParametrosServiceWSImpl {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AdministradorParametrosService administracionParametrosService;

    @Autowired
    private CotizadorService cotizadorService;

    /**
     * PostConstruct.
     */
    @PostConstruct
    @WebMethod(exclude = true)
    public void init() {
        logger.info("PostConstruct ParametrosServiceWsImpl");
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    /**
     * Retorna estados proceso y detalle.
     * 
     * @param ambito
     *            Ambito.
     * @param idEstado
     *            Estado a consultar.
     * @return EstadoProcesoResponse
     */
    @WebMethod
    @WebResult(name = "ResultadoObtenerCanales")
    public List<Canal> consultaObtenerCanales() {
        logger.debug("consultaObtenerCanales-Inicia");
        List<Canal> canales = new ArrayList<Canal>();
        try {
            canales = administracionParametrosService.obtenerCanales();
        } catch (Exception e1) {
            logger.error("consultaObtenerCanales-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return canales;
    }

    /**
     * 
     * @param canal
     * @return
     */
    @WebMethod
    @WebResult(name = "ResultadoObtenerIntermediarios")
    public List<Socio> consultaObtenerIntermediarios(
            @WebParam(name = "idCanal") Long idCanal) {
        logger.debug("consultaObtenerIntermediarios-Inicia idCanal:" + idCanal);
        List<Socio> socios = new ArrayList<Socio>();
        try {
            socios = administracionParametrosService
                    .obtenerIntermediarios(idCanal);
        } catch (Exception e1) {
            logger.error("consultaObtenerIntermediarios-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return socios;
    }

    /**
     * Retorna estados proceso y detalle.
     * 
     * @param ambito
     *            Ambito.
     * @param idEstado
     *            Estado a consultar.
     * @return EstadoProcesoResponse
     */
    @WebMethod
    @WebResult(name = "ResultadoObtenerProductos")
    public List<Producto> consultaObtenerProductos(
            @WebParam(name = "idIntermediario") Long idIntermediario) {
        logger.debug("consultaObtenerProductos-Inicia idIntermediario:" + idIntermediario);

        List<Producto> productos = new ArrayList<Producto>();
        try {
            productos = administracionParametrosService
                    .obtenerProductos(idIntermediario);
        } catch (Exception e1) {
            logger.error("consultaObtenerProductos-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return productos;
    }
    
    /**
     * Retorna estados proceso y detalle.
     * 
     * @param ambito
     *            Ambito.
     * @param idEstado
     *            Estado a consultar.
     * @return EstadoProcesoResponse
     */
    @WebMethod
    @WebResult(name = "ResultadoObtenerMarcas")
    public List<Marca> consultaObtenerMarcas() {
        logger.debug("consultaObtenerMarcas-Inicia");

        List<Marca> marcas = new ArrayList<Marca>();
        try {
            marcas = administracionParametrosService.obtenerMarcas();
        } catch (Exception e1) {
            logger.error("obtenerFormula-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return marcas;
    }
    
    
    @WebMethod
    @WebResult(name = "ResultadoObtenerModelos")
    public List<Modelo> consultaObtenerModelos(
            @WebParam(name = "idMarca") Long idMarca) {
        logger.debug("consultaObtenerModelos-Inicia idMarca:" + idMarca);

        List<Modelo> modelos = new ArrayList<Modelo>();
        try {
            modelos = administracionParametrosService.obtenerModelos(idMarca);
        } catch (Exception e1) {
            logger.error("consultaObtenerModelos-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return modelos;
    }
    
    @WebMethod
    @WebResult(name = "ResultadoObtenerVersiones")
    public List<Version> consultaObtenerVersiones(
            @WebParam(name = "idMarca") Long idMarca,
            @WebParam(name = "idModelo") Long idModelo) {
        logger.debug("consultaObtenerVersiones-Inicia idMarca:" + idMarca
                + " idModelo:" + idModelo);

        List<Version> versiones = new ArrayList<Version>();
        try {
            versiones = administracionParametrosService.obtenerVersiones(idMarca, idModelo);
        } catch (Exception e1) {
            logger.error("consultaObtenerVersiones-Fin Error Exception:" + e1.getMessage(), e1);
           
        }
        return versiones;
    }

    
    @WebMethod
    @WebResult(name = "FactoresResponse")
    public FactoresResponse obtenerFactores(
            @WebParam(name = "idProducto") Long idProducto){
        logger.debug("obtenerFactores-Inicia idProducto:" + idProducto);
        
       FactoresResponse response = null;
        try {
            response = administracionParametrosService.obtenerFactores(idProducto);
        } catch (Exception e) {
            logger.error("obtenerFactores-Fin Error Exception:" + e.getMessage(), e);
        }
        
        return response;
    }


    @WebMethod
    @WebResult(name = "codResultado")
    public Integer editarFormula(
            @WebParam(name = "idProducto") Long idProducto,
            @WebParam(name = "idFactor") Long idFactor){
        logger.debug("editarFormula-Inicia idProducto:" + idProducto
                                            + " idFactor:" + idFactor);
        
       Integer codResultado = null;
        try {
            codResultado = administracionParametrosService.editarFormula(idProducto,idFactor);
        } catch (Exception e) {
            logger.error("editarFormula-Fin Error Exception:" + e.getMessage(), e);
        }
        
        return codResultado;
    }
    

    @WebMethod
    @WebResult(name = "codResultado")
    public Integer actualizarValorFactor(
            @WebParam(name = "idSocio") Long idSocio,
            @WebParam(name = "idFactorDetalle") Long idFactorDetalle,
            @WebParam(name = "idFactor") Long idFactor,
            @WebParam(name = "llaveFactor") String llaveFactor,
            @WebParam(name = "valorFactor") Double valorFactor){
        logger.debug("actualizarValorFactor-Inicia idSocio:" + idSocio 
                                                + " idFactorDetalle:" + idFactorDetalle
                                                + " idFactor:" + idFactor
                                                + " llaveFactor:" + llaveFactor
                                                + " valorFactor:" + valorFactor);
        
       Integer codResultado = null;
        try {
            codResultado = administracionParametrosService.actualizarValorFactor(idSocio, idFactorDetalle, idFactor, llaveFactor, valorFactor);
        } catch (Exception e) {
            logger.error("actualizarValorFactor-Fin Error Exception:" + e.getMessage(), e); 
        }
        
        return codResultado;
    }
    
    @WebMethod
    @WebResult(name = "ListaFactoresDetalle")
    public ListaFactoresDetalle listarValorFactor(
            @WebParam(name = "idSocio") Long idSocio,
            @WebParam(name = "idFactor") Long idFactor){
        logger.debug("listarValorFactor-Inicia idSocio:" + idSocio + " idFactor:" + idFactor);
        
        ListaFactoresDetalle response = null;
        try {
            response = administracionParametrosService.listarValorFactor(idSocio, idFactor);
        } catch (Exception e) {
            logger.error("listarValorFactor-Fin Error Exception:" + e.getMessage(), e);
        }
        
        return response;
    }
    
    @WebMethod
    @WebResult(name = "ObtenerUsuario")
    public Usuario obtenerUsuario(
            @WebParam(name = "nombreUsuario") String idUsuarioCardif,
            @WebParam(name = "pass") String pass){
        logger.debug("obtenerUsuario-Inicia nombreUsuario:" + idUsuarioCardif);
        
        Usuario response = null;
        try {
            response = administracionParametrosService.obtenerUsuario(idUsuarioCardif,pass);
        } catch (Exception e) {
            logger.error("obtenerUsuario-Fin Error Exception:" + e.getMessage(), e);
        }
        
        return response;
    }
    
     /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "ProcesoCargaTarifaBase")
    public Integer procesoCargaTarifaBase(@WebParam(name = "nombre") String nombre) {

        Integer codigoProceso = null;
        try {
            codigoProceso = administracionParametrosService.procesoCargaTarifaBase(nombre);
        }
        catch (Exception e) {
        	logger.error("procesoCargaTarifaBase Error Exception:" + e.getMessage(), e);
        }

        return codigoProceso;
    }

    /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "CargaArchivoTarifas")
    public Integer cargaArchivoTablaTemporal(@WebParam(name = "cargaTarifas") CargaTarifa cargaTarifas) {
        Integer registrosIngresados = null;
        try {
            registrosIngresados = administracionParametrosService.cargaArchivoTablaTemporal(cargaTarifas);
        }
        catch (Exception e) {
            logger.error("excepcion CargaArchivoTarifas " + e.getMessage());
        }
        return registrosIngresados;

    }

    /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "ProcesoTraspasoTarifaBase")
    public EstadoOperacion procesoTraspasoTarifaBase(@WebParam(name = "cargaTarifas") CargaTarifa cargaTarifas) {
        logger.debug("entra a ProcesoTraspasoTarifaBase");
        EstadoOperacion response = new EstadoOperacion();
        try {
            response = administracionParametrosService.procesoTraspasoTarifaBase(cargaTarifas);
        }
        catch (Exception e) {
        	logger.error("procesoTraspasoTarifaBase Error Exception:" + e.getMessage(), e);
        }

        return response;
    }

    /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "CambioEstadoProceso")
    public void cambioEstadoProceso(@WebParam(name = "cargaTarifas") CargaTarifa cargaTarifas,
            @WebParam(name = "estado") Long estado) {
        logger.debug("entra a cambioEstadoProceso");

        try {
            administracionParametrosService.cambioEstadoProceso(cargaTarifas, estado);
        }
        catch (Exception e) {
            logger.error("excepcion cambioEstadoProceso " + e.getMessage());
        }

    }

    /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "ObtenerCargasTarifa")
    public List<CargaTarifa> obtenerCargasTarifa() {
        logger.debug("entra a obtenerCargasTarifa");
        List<CargaTarifa> cargas = null;
        try {
            cargas = administracionParametrosService.obtenerCargasTarifa();
        }
        catch (Exception e) {
            logger.error("excepcion obtenerCargasTarifa " + e.getMessage());
        }
        return cargas;

    }
    
    
    /**
     * @param tarifas
     * @return
     */
    @WebMethod
    @WebResult(name = "ObtenerGlosaVehiculo")
    public GlosaVehiculoModelo obtenerGlosaVehiculo(@WebParam(name = "idMarca") Long idMarca, @WebParam(name = "idModelo") Long idModelo) {
        logger.debug("entra a obtenerGlosaVehiculo");
        GlosaVehiculoModelo glosaVehiculoModelo = null;
        try {
        	glosaVehiculoModelo = administracionParametrosService.obtenerGlosaVehiculo(idMarca, idModelo);
        }
        catch (Exception e) {
        	glosaVehiculoModelo = new GlosaVehiculoModelo();
        	glosaVehiculoModelo.setCodigo(-1);
        	glosaVehiculoModelo.setDescripcion("Error al obtener glosas");
            logger.error("excepcion obtenerGlosaVehiculo " + e.getMessage());
        }
        return glosaVehiculoModelo;

    }
    
}
