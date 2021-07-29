package cl.cardif.cotizador.wsCotizador.service.impl;

import java.net.URL;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.cardif.cotizador.wsCotizador.dao.AdministrarParametroDAO;
import cl.cardif.cotizador.wsCotizador.dto.CargaTarifa;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacion;
import cl.cardif.cotizador.wsCotizador.dto.GlosaVehiculoModelo;
import cl.cardif.cotizador.wsCotizador.dto.ListaFactoresDetalle;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.exception.GeneralException;
import cl.cardif.cotizador.wsCotizador.model.Canal;
import cl.cardif.cotizador.wsCotizador.model.Marca;
import cl.cardif.cotizador.wsCotizador.model.Modelo;
import cl.cardif.cotizador.wsCotizador.model.Producto;
import cl.cardif.cotizador.wsCotizador.model.FactoresResponse;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.model.Socio;
import cl.cardif.cotizador.wsCotizador.model.Usuario;
import cl.cardif.cotizador.wsCotizador.model.Version;
import cl.cardif.cotizador.wsCotizador.service.AdministradorParametrosService;
import cl.cardif.schema.ebm.usuario.autenticar.v1.Autenticar;
import cl.cardif.schema.ebm.usuario.autenticar.v1.AutenticarUsuarioREQType;
import cl.cardif.schema.ebm.usuario.autenticar.v1.AutenticarUsuarioREQType.Body;
import cl.cardif.schema.ebm.usuario.autenticar.v1.AutenticarUsuarioRSPType;
import cl.cardif.schema.eso.messageheader.v1.ConsumerType;
import cl.cardif.schema.eso.messageheader.v1.CountryType;
import cl.cardif.schema.eso.messageheader.v1.RequestHeaderType;
import cl.cardif.schema.eso.messageheader.v1.TraceType;
import cl.cardif.service.ebsc.usuario.v1.UsuarioService;

@Component
public final class AdministracionParametrosServiceImpl implements AdministradorParametrosService {

    private static AdministracionParametrosServiceImpl instance = new AdministracionParametrosServiceImpl();

    @Autowired
    private AdministrarParametroDAO administrarParametroDAO;
    private static final String COMP = "java:comp/env";

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private AdministracionParametrosServiceImpl() {

    }

    /**
     * Singleton.
     * 
     * @return
     */
    public static AdministracionParametrosServiceImpl getInstance() {
        return instance;
    }

    /**
     * 
     * @param rut
     * @return
     * @throws Exception
     */
    public RutListaNegra consultarRutListaNegra(Long rut) throws GeneralException {
        logger.debug("consultarRutListaNegra-Inicia rut:" + rut);
        RutListaNegra rutListaNegra = null;
        try {
            rutListaNegra = administrarParametroDAO.consultarRutListaNegra(rut);
            logger.debug("consultarRutListaNegra-rutListaNegra:" + rutListaNegra);
            logger.debug("consultarRutListaNegra-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("consultarRutListaNegra-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("consultarRutListaNegra-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return rutListaNegra;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cl.cardif.cotizador.wsCotizador.service.AdministradorParametrosService#obtenerIntermediarios(java.lang.Long)
     */
    @Override
    public List<Canal> obtenerCanales() throws GeneralException {
        logger.debug("obtenerCanales-Inicia");
        List<Canal> canales = null;
        try {
            canales = administrarParametroDAO.obtenerCanales();
            logger.debug("obtenerCanales-canales:" + canales);
            logger.debug("obtenerCanales-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerCanales-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerCanales-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return canales;
    }

    /*
     * (non-Javadoc)
     * 
     * @see cl.cardif.cotizador.wsCotizador.service.AdministradorParametrosService#obtenerIntermediarios(java.lang.Long)
     */
    @Override
    public List<Socio> obtenerIntermediarios(Long idCanal) throws GeneralException {
        logger.debug("obtenerIntermediarios-Inicia idCanal:" + idCanal);
        List<Socio> socios = null;
        try {
            socios = administrarParametroDAO.obtenerIntermediarios(idCanal);
            logger.debug("obtenerIntermediarios-socios:" + socios);
            logger.debug("obtenerIntermediarios-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerIntermediarios-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerIntermediarios-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return socios;

    }

    @Override
    public List<Producto> obtenerProductos(Long idIntermediario) throws GeneralException {
        logger.debug("obtenerProductos-Inicia idIntermediario:" + idIntermediario);
        List<Producto> productos = null;
        try {
            productos = administrarParametroDAO.obtenerProductos(idIntermediario);
            logger.debug("obtenerProductos-productos:" + productos);
            logger.debug("obtenerProductos-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerProductos-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerProductos-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return productos;

    }

    @Override
    public FactoresResponse obtenerFactores(Long idProducto) throws GeneralException {
        logger.debug("obtenerFactores-Inicia idProducto:" + idProducto);
        FactoresResponse response = null;
        try {
            response = administrarParametroDAO.obtenerFactores(idProducto);

            logger.debug("obtenerFactores-response:" + response);
            logger.debug("obtenerFactores-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerFactores-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw new GeneralException(e);
        } catch (Exception e) {
            logger.error("obtenerIntermediarios-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return response;

    }

    @Override
    public Integer editarFormula(Long idProducto, Long idFactor) throws GeneralException {
        logger.debug("editarFormula-Inicia idProducto:" + idProducto + " idFactor:" + idFactor);
        Integer response = null;
        try {
            response = administrarParametroDAO.editarFormula(idProducto, idFactor);
            logger.debug("editarFormula-response:" + response);
            logger.debug("editarFormula-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("editarFormula-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return response;

    }

    @Override
    public List<Marca> obtenerMarcas() throws GeneralException {
        logger.debug("obtenerMarcas-Inicia");
        List<Marca> marcas = null;
        try {
            marcas = administrarParametroDAO.obtenerMarcas();
            logger.debug("obtenerMarcas-marcas:" + marcas);
            logger.debug("obtenerMarcas-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerMarcas-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerMarcas-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return marcas;
    }

    @Override
    public List<Modelo> obtenerModelos(Long idMarca) throws GeneralException {
        logger.debug("obtenerModelos-Inicia idMarca:" + idMarca);
        List<Modelo> modelos = null;
        try {
            modelos = administrarParametroDAO.obtenerModelos(idMarca);
            logger.debug("obtenerModelos-modelos:" + modelos);
            logger.debug("obtenerModelos-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerModelos-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerModelos-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return modelos;
    }

    @Override
    public List<Version> obtenerVersiones(Long idMarca, Long idModelo) throws GeneralException {
        logger.debug("obtenerVersiones-Inicia idMarca:" + idMarca + " idModelo:" + idModelo);
        List<Version> versiones = null;
        try {
            versiones = administrarParametroDAO.obtenerVersiones(idMarca, idModelo);
            logger.debug("obtenerVersiones-versiones:" + versiones);
            logger.debug("obtenerVersiones-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerVersiones-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerVersiones-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return versiones;
    }

    @Override
    public ListaFactoresDetalle listarValorFactor(Long idSocio, Long idFactor) throws GeneralException {

        logger.debug("listarValorFactor-Inicia idSocio:" + idSocio);
        logger.debug("listarValorFactor-Inicia idFactor:" + idFactor);
        ListaFactoresDetalle response = null;
        try {
            response = administrarParametroDAO.listarValorFactor(idSocio, idFactor);

            logger.debug("listarValorFactor-response:" + response);
            logger.debug("listarValorFactor-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("listarValorFactor-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("listarValorFactor-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return response;
    }

    @Override
    public Integer actualizarValorFactor(Long idSocio, Long idFactorDetalle, Long idFactor, String llaveFactor,
            Double valorFactor) throws GeneralException {

        logger.debug("actualizarValorFactor-Inicia idSocio:" + idSocio + " idFactorDetalle:" + idFactorDetalle
                + " idFactor:" + idFactor + " llaveFactor:" + llaveFactor + " valorFactor:" + valorFactor);
        Integer response = null;
        try {
            response = administrarParametroDAO.actualizarValorFactor(idSocio, idFactorDetalle, idFactor, llaveFactor,
                    valorFactor);

            logger.debug("actualizarValorFactor-response:" + response);
            logger.debug("actualizarValorFactor-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("actualizarValorFactor-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("actualizarValorFactor-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return response;
    }

    @Override
    public Usuario obtenerUsuario(String idUsuarioCardif, String pass) throws GeneralException {

        boolean autenticado = false;
        logger.debug("obtenerUsuario-Inicia idUsuarioCardif:" + idUsuarioCardif);
        try {
            Usuario response = administrarParametroDAO.obtenerUsuario(idUsuarioCardif);
            if (response != null) {
                try {
                    autenticado = usuarioWS(idUsuarioCardif, pass);
                } catch (Exception e) {
                    logger.error("obtenerUsuario-Fin Error en usuarioWS:" + e.getMessage(), e);
                }
                response.setAutenticado(autenticado);
            }
            logger.debug("obtenerUsuario-response:" + response);
            logger.debug("obtenerUsuario-Fin Ok");
            return response;
        } catch (CotizadorDaoException e) {
            logger.error("obtenerUsuario-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerUsuario-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
        
    }

    @Override
    public Integer cargaArchivoTablaTemporal(CargaTarifa tarifas) throws GeneralException {
        logger.debug("cargaArchivoTablaTemporal - inicio");
        Integer registrosIngresados = null;
        try {
            registrosIngresados = administrarParametroDAO.cargaArchivoTablaTemporal(tarifas);
            logger.debug("cargaArchivoTablaTemporal-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("cargaArchivoTablaTemporal-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("cargaArchivoTablaTemporal-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
        return registrosIngresados;

    }

    @Override
    public Integer procesoCargaTarifaBase(String nombre) throws GeneralException {
        Integer codigoProceso;
        logger.debug("procesoCargaTarifaBase - inicio");
        try {
            codigoProceso = administrarParametroDAO.procesoCargaTarifaBase(nombre);
            logger.debug("procesoCargaTarifaBase-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("procesoCargaTarifaBase-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("procesoCargaTarifaBase-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return codigoProceso;
    }

    @Override
    public EstadoOperacion procesoTraspasoTarifaBase(CargaTarifa tarifas) throws GeneralException {
        logger.debug("entra a procesoTraspasoTarifaBase");
        try {
            EstadoOperacion response = administrarParametroDAO.procesoTraspasoTarifaBase(tarifas);
            logger.debug("procesoTraspasoTarifaBase-Fin Ok");
            return response;
        } catch (CotizadorDaoException e) {
            logger.error("procesoTraspasoTarifaBase-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("procesoTraspasoTarifaBase-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        
    }

    @Override
    public void cambioEstadoProceso(CargaTarifa cargaTarifas, Long estado) throws GeneralException {
        logger.debug("entra a cambioEstadoProceso");
        try {
            administrarParametroDAO.cambioEstadoProceso(cargaTarifas, estado);
            logger.debug("cambioEstadoProceso-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("cambioEstadoProceso-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("cambioEstadoProceso-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
    }

    @Override
    public List<CargaTarifa> obtenerCargasTarifa() throws GeneralException {
        logger.debug("entra a obtenerCargasTarifa");
        List<CargaTarifa> response = null;
        logger.debug("obtenerCargasTarifa - inicio");
        try {
            response = administrarParametroDAO.obtenerCargasTarifa();
            logger.debug("obtenerCargasTarifa-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerCargasTarifa-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerCargasTarifa-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        return response;
    }

    private boolean usuarioWS(String idUsuarioCardif, String pass) throws GeneralException {
        logger.debug("usuarioWS - inicio nombreUsuario:" + idUsuarioCardif);
        boolean autenticado = false;
        try {
            Context getPrincipal = (Context) new InitialContext().lookup(COMP);
            UsuarioService usuarioService = new UsuarioService(new URL(
                    (String) getPrincipal.lookup("validaUsuarioEndpoint")));
            AutenticarUsuarioREQType autenticarUsuarioREQType = new AutenticarUsuarioREQType();
            Body bodyIn = new Body();
            Autenticar autenticar = new Autenticar();
            RequestHeaderType requestHeaderType = new RequestHeaderType();
            ConsumerType consumerType = new ConsumerType();
            TraceType traceType = new TraceType();
            CountryType countryType = new CountryType();

            countryType.setCode((Integer) getPrincipal.lookup("countryCode"));
            countryType.setName((String) getPrincipal.lookup("countryName"));
            traceType.setReqTimestamp(null);
            traceType.setRspTimestamp(null);
            traceType.setMessageID((Integer) getPrincipal.lookup("traceTypeMessageID"));
            consumerType.setCode((Integer) getPrincipal.lookup("consumerCode"));
            consumerType.setName((String) getPrincipal.lookup("consumerName"));

            autenticar.setClave(pass);
            autenticar.setNombreUsuario(idUsuarioCardif);
            autenticar.setDominio((String) getPrincipal.lookup("autenticarDominio"));
            bodyIn.setAutenticar(autenticar);

            requestHeaderType.setTrace(traceType);
            requestHeaderType.setCountry(countryType);
            requestHeaderType.setConsumer(consumerType);
            autenticarUsuarioREQType.setRequestHeader(requestHeaderType);
            autenticarUsuarioREQType.setBody(bodyIn);

            logger.debug("usuarioWS-autenticarUsuarioREQType: " + autenticarUsuarioREQType);
            AutenticarUsuarioRSPType autenticarUsuarioRSPType = usuarioService.getUsuarioPort().autenticar(
                    autenticarUsuarioREQType);
            autenticado = autenticarUsuarioRSPType.getBody().getAutenticarResponse().getRespuesta()
                    .isUsuarioAutenticado();

            logger.debug("usuarioWS-autenticado: " + autenticado);
            logger.debug("usuarioWS-Fin Ok");

        
        } catch (Exception e) {
            logger.error("usuarioWS-Fin Error AutenticarFaultMessage:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
        return autenticado;
    }

    @Override
    public GlosaVehiculoModelo obtenerGlosaVehiculo(Long idMarca, Long idModelo) throws GeneralException {
        logger.debug("obtenerGlosaVehiculo-Inicia");
        try {
            GlosaVehiculoModelo glosa = administrarParametroDAO.obtenerGlosaVehiculo(idMarca, idModelo);
            logger.debug("obtenerGlosaVehiculo-glosa:" + glosa);
            logger.debug("obtenerGlosaVehiculo-Fin Ok");
            return glosa;
        } catch (CotizadorDaoException e) {
            logger.error("obtenerGlosaVehiculo-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerGlosaVehiculo-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }

        
    }
}
