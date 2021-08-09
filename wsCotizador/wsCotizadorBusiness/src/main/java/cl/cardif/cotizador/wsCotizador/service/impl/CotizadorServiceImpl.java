package cl.cardif.cotizador.wsCotizador.service.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.cxf.binding.soap.SoapBindingFactory;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cl.cardif.cotizador.wsCotizador.dao.CotizadorDAO;
import cl.cardif.cotizador.wsCotizador.dto.EstadoOperacionCotizacion;
import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;
import cl.cardif.cotizador.wsCotizador.dto.ProductoTO;
import cl.cardif.cotizador.wsCotizador.dto.ResultadoCotizacion;
import cl.cardif.cotizador.wsCotizador.dto.SalidaCotizacion;
import cl.cardif.cotizador.wsCotizador.dto.Tarifa;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorException;
import cl.cardif.cotizador.wsCotizador.exception.GeneralException;
import cl.cardif.cotizador.wsCotizador.model.Deducible;
import cl.cardif.cotizador.wsCotizador.model.DetalleProducto;
import cl.cardif.cotizador.wsCotizador.model.Equifax;
import cl.cardif.cotizador.wsCotizador.model.Formula;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;
import cl.cardif.cotizador.wsCotizador.service.CotizadorService;
import cl.cardif.cotizador.wsCotizador.util.FechasUtil;
import cl.cardif.cotizador.wsCotizador.util.StringUtil;
import cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformation;
import cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationREQType;
import cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationREQType.Body;
import cl.cardif.schema.ebm.aachcarclaiminformation.get.v1.GetAACHCarClaimInformationRSPType;
import cl.cardif.schema.eso.messageheader.v1.ChannelType;
import cl.cardif.schema.eso.messageheader.v1.ConsumerType;
import cl.cardif.schema.eso.messageheader.v1.CountryType;
import cl.cardif.schema.eso.messageheader.v1.RequestHeaderType;
import cl.cardif.schema.eso.messageheader.v1.TraceType;
import cl.cardif.service.ebsc.aachcarclaiminformation.v1.AACHCarClaimInformationPortType;

/**
 * *
 * <p>
 * Registro de Versiones :
 * <ul>
 * <li>1.0 19-01-2016, Héctor Beas D. (Imagemaker IT): Versión inicial</li>
 * </ul>
 * </p>
 * <p>
 * <B>Todos los derechos reservados por BNP Paribas Cardif.</B>
 * </p>
 */
@Component
public final class CotizadorServiceImpl implements CotizadorService {

    /**
     * Largo de caracteres para completar rut.
     */
    private static final int LARGO_RUT_WS = 10;
    
    private static final Long VALOR_CERO = 0L;

    private static final String COMP = "java:comp/env";

    /**
     * Constante que describe el id de la suma.
     */
    private static final Long SUMA = Long.valueOf(1);
    /**
     * Constante que describe el id de la resta.
     */
    private static final Long RESTA = Long.valueOf(2);
    /**
     * Constante que describe el id de la multiplicación.
     */
    private static final Long MULTIPLICACION = Long.valueOf(3);

    private static final String ESTADO_EXITO_AACH = "OK";
    /**
     * Constante que describe la llave para obtener el factor de la promoción.
     */
    private static final String LLAVE_PROMOCION = "PROMO";
    /**
     * Atributo para loguear la clase.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static CotizadorServiceImpl instance = new CotizadorServiceImpl();

    @Autowired
    private CotizadorDAO cotizadorDAO;

    private CotizadorServiceImpl() {
    }

    /**
     * Singleton.
     * 
     * @return CotizadorServiceImpl.
     */
    public static CotizadorServiceImpl getInstance() {
        return instance;
    }

    /**
     * Método encargado de realizar la cotización.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param parametros
     *            parametros de entrada del servicio web.
     * @return SalidaCotizacion con datos de la cotizacion.
     * @throws Exception
     *             en caso de error.
     * @since 1.0
     */
    public SalidaCotizacion cotizar(ParametrosCotizador parametros) throws GeneralException {
    	logger.error("PRUEBA MACARENA");
    	logger.error("cotizar-Inicia parametros:" + parametros.toString());

        // To de salida de cotizacion.        
        EstadoOperacionCotizacion estadoOperacion = validaParametrosEntrada(parametros);
        if (estadoOperacion.getCodigoEstado() != 0) {
             logger.error("cotizar-validacion de parametros fallida");
            return new SalidaCotizacion(estadoOperacion);
        }

        SalidaCotizacion salidaCotizacion = new SalidaCotizacion();
        try {            
            if (parametros.getProductoCode() != null && parametros.getProductoCode().equals(VALOR_CERO)) {
                parametros.setProductoCode(null);
            }
            parametros.setInsuredRut(parametros.getInsuredRut().replace(".", "").replace("-", ""));

            String rutRelleno = StringUtil.rellenaPorLaIzquierda(parametros.getInsuredRut(), 10, '0').toUpperCase();
            logger.error("cotizar-obtenerInfoEquifax:" + rutRelleno);
            Equifax datosEquifax = cotizadorDAO.obtenerInfoEquifax(rutRelleno);
            if (datosEquifax != null) {
                logger.error("cotizar-obtenerInfoEquifax datosEquifax:" + datosEquifax.toString());
                if (parametros.getInsuredNames() == null || "".equals(parametros.getInsuredNames())) {
                    parametros.setInsuredNames(datosEquifax.getNombre());
                }
            }else{
                logger.error("cotizar-obtenerInfoEquifax datosEquifax: Asegurado no encontrado en equifax");
            }

            List<TarifaBase> tarifaBase = cotizadorDAO.obtenerTarifaBase(parametros.getChannel(),
                    parametros.getIntermediate(), parametros.getProductoCode(), parametros.getBrand(),
                    parametros.getModel(), parametros.getVersion());

            if (tarifaBase != null && tarifaBase.size() > 0) {
                logger.error("cotizar-tarifaBase.size():" + tarifaBase.size());

                // Crea cabecera de producto (ID) en hash hmProductoDeducible
                Map<Long, DetalleProducto> hmProductoDeducible = getHashDeducibles(tarifaBase);                

                // Obtiene listado de formulas por producto y los deja en hmProductoFormula.
                Map<Long, List<Formula>> hmProductoFormula = new HashMap<Long, List<Formula>>();
                for (Map.Entry<Long, DetalleProducto> entry : hmProductoDeducible.entrySet()) {
                    hmProductoFormula.put(entry.getKey(), this.obtenerFormula(entry.getKey()));
                }

                // Edad del asegurado
                int edadAsegurado = getEdadAsegurado(datosEquifax, parametros.getDateOfBirth());
                // Obtiene todos los factores de las formulas de los productos, calcula sus valores y los deja en hmFactorValor
                Map<Long, Double> hmFactorValor = getHashFactorValor(parametros, hmProductoFormula, edadAsegurado,
                        datosEquifax);
                //lista negra factor
                Double factorSisgen = obtenerSISGEN(parametros);
                
                if(factorSisgen<0)
                {
                	throw new CotizadorException("Tarifa base no encontrada");  
                }
                else
                {
                	logger.error("cotizar-factorSisgen:" + factorSisgen);
                    ResultadoCotizacion resultadoCotizacion = new ResultadoCotizacion(parametros);
                    resultadoCotizacion.setSisgen(redondearADosDecimales(factorSisgen));                
                    List<ProductoTO> listadoProductos = getListaProductos(hmProductoDeducible, hmProductoFormula, hmFactorValor, factorSisgen);
                    salidaCotizacion = new SalidaCotizacion(null, null, resultadoCotizacion, listadoProductos);                
                    logger.error("cotizar-salidaCotizacion:" + salidaCotizacion.toString());
                                  
                    Marshaller m = (JAXBContext.newInstance(SalidaCotizacion.class)).createMarshaller();
                    StringWriter sW = new StringWriter();
                    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                    m.marshal(salidaCotizacion, sW);
                    Double idCotizacion = cotizadorDAO.insertarLog(parametros, sW.toString());
                    salidaCotizacion.setIdCotizacion(Math.round(idCotizacion));
                }
                
                
            } else {
                throw new CotizadorException("Tarifa base no encontrada");                
            }
            salidaCotizacion.setEstadoOperacion(new EstadoOperacionCotizacion(Long.valueOf("0"), "Cotización correcta"));
            logger.error("cotizar-Fin Ok");
        } catch (CotizadorException e) {
            salidaCotizacion.setEstadoOperacion(new EstadoOperacionCotizacion(Long.valueOf("2"), "Error al cotizar:" + e.getMessage()));
            cotizadorDAO.insertarLog(parametros, e.getMessage());
            logger.error("cotizar-Fin Error CotizadorException:" + e.getMessage(), e);
        } catch (CotizadorDaoException e) {
            salidaCotizacion.setEstadoOperacion(new EstadoOperacionCotizacion(Long.valueOf("1"), "Error al cotizar:" + e.getMessage()));
            logger.error("cotizar-Fin Error CotizadorDaoException:" + e.getMessage(), e);
        } catch (Exception e) {
            salidaCotizacion.setEstadoOperacion(new EstadoOperacionCotizacion(Long.valueOf("1"), "Error al cotizar:" + e.getMessage()));
            logger.error("cotizar-Fin Error Exception:" + e.getMessage(), e);
        }

        return salidaCotizacion;
    }
    
    /**
     * Calcula edad del asegurado, en base a la fecha de nacimiento mas próxima en caso que sean distintas 
     * las fechas de naciento ingresada con la obtenida de equifax.
     * @param fechaNacimientoEquifax
     * @param fechaNacimientoEntrante
     * @return
     */
    private int getEdadAsegurado(Equifax datosEquifax, Date fechaNacimientoEntrante){
        Date fechaNacEq = null;
        int edadAsegurado = 0;
        logger.error("cotizar-Formateando fecha de equifax.");
        String fechaNacimientoEquifax = "";
        if (datosEquifax != null) {
            fechaNacimientoEquifax = datosEquifax.getFechaNacimiento();
        }
        if (!"".equals(fechaNacimientoEquifax)) {
            fechaNacEq = FechasUtil.convierteStringADate(fechaNacimientoEquifax, new SimpleDateFormat("yyyyMMdd"));
        }

        logger.error("cotizar-fechaNacEq:" + fechaNacEq);
        if (fechaNacEq == null || fechaNacimientoEntrante.after(fechaNacEq)) {
            logger.error("cotizar-Se utilizará fecha de nacimiento de parametros de entrada de ws."
                    + fechaNacimientoEntrante);
            edadAsegurado = FechasUtil.calculaEdad(fechaNacimientoEntrante);
            logger.error("cotizar-edadAsegurado ws:" + edadAsegurado);
        } else {
            logger.error("cotizar-Se utilizará fecha de nacimiento de equifax." + fechaNacEq);
            edadAsegurado = FechasUtil.calculaEdad(fechaNacEq);
            logger.error("cotizar-edadAsegurado equifax:" + edadAsegurado);
        }
        return edadAsegurado;
    }
    
    private Map<Long, DetalleProducto> getHashDeducibles(List<TarifaBase> tarifaBase){
        Map<Long, DetalleProducto> hmProductoDeducible = new HashMap<Long, DetalleProducto>();
        for (int i = 0; i < tarifaBase.size(); i++) {
            if (hmProductoDeducible.containsKey(tarifaBase.get(i).getIdProducto())) {
                hmProductoDeducible.put(tarifaBase.get(i).getIdProducto(), null);
            }
        }

        // Pobla detalle de deducibles del producto y lo deja en hash hmProductoDeducible.
        List<Deducible> listDeducible = new ArrayList<Deducible>();
        logger.error("cotizar-obteniendo deducibles de los productos");
        Long idProdTmp = null;
        for (int i = 0; i < tarifaBase.size(); i++) {
            if (i + 1 < tarifaBase.size()) {
                idProdTmp = tarifaBase.get(i + 1).getIdProducto();
            } else {
                idProdTmp = null;
            }

            listDeducible.add(new Deducible(tarifaBase.get(i).getIdDeducible(), tarifaBase.get(i)
                            .getNombreDeducible(), tarifaBase.get(i).getNombreProducto(), tarifaBase.get(i)
                            .getValor()));
            if (!tarifaBase.get(i).getIdProducto().equals(idProdTmp)) {
                hmProductoDeducible.put(tarifaBase.get(i).getIdProducto(), new DetalleProducto(tarifaBase
                        .get(i).getNombreProducto(), listDeducible));
                listDeducible = new ArrayList<Deducible>();
            }
        }
        return hmProductoDeducible;
    }
    
    /**
     * Obtiene todos los factores de las formulas de los productos, calcula sus valores y los deja en el hash
     * hmFactorValor
     * 
     * @return
     */
    private Map<Long, Double> getHashFactorValor(ParametrosCotizador parametros, Map<Long, List<Formula>> hmProductoFormula,
             int edadAsegurado, Equifax datosEquifax) throws CotizadorException, GeneralException {

        try {
            Map<Long, Double> hmFactorValor = new HashMap<Long, Double>();
            Context getPrincipal = (Context) new InitialContext().lookup(COMP);
            List<Formula> listFormula;
            Long identificadorFactor;
            Double valorFactor;
            for (Map.Entry<Long, List<Formula>> entry : hmProductoFormula.entrySet()) {
                listFormula = entry.getValue();                
                for (int i = 0; i < listFormula.size(); i++) {
                    identificadorFactor = listFormula.get(i).getIdFactor();       
                    valorFactor = null;
                    if (!hmFactorValor.containsKey(listFormula.get(i).getIdFactor())) {
                        if (identificadorFactor.equals((Long) getPrincipal.lookup("factorAntiguedad"))) {
                            logger.error("cotizar-obteniendo factor ANTIGUEDAD");
                            String aniosAntiguedad = String.valueOf(Long.valueOf(FechasUtil.anoActual())
                                    - parametros.getYear());
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    aniosAntiguedad);
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorEdad"))) {
                            logger.error("cotizar-obteniendo factor EDAD");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    String.valueOf(edadAsegurado));
                            if (valorFactor == null) {
                                logger.error("no se encuentra factor para edad: " + edadAsegurado);
                                throw new CotizadorException("Sin factor para la edad ingresada:" + edadAsegurado);
                            }
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorIva"))) {
                            logger.error("cotizar-obteniendo factor Iva");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor, "IVA");
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorSexo"))) {
                            logger.error("cotizar-obteniendo factor SEXO");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    parametros.getGender());
                            if (valorFactor == null && datosEquifax != null) {
                                valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                        datosEquifax.getSexo());
                            }
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorEstadoCivil"))) {
                            logger.error("cotizar-obteniendo factor ESTADO_CIVIL");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    parametros.getMaritalStatus());
                            if (valorFactor == null && datosEquifax != null) {
                                valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                        datosEquifax.getEstadoCivil());
                            }
                        } /*
                        else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorProfesion")) && datosEquifax != null) {
                            logger.error("cotizar-obteniendo factor PROFESION");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,String.valueOf(datosEquifax.getCodProfesion()));                                 
                        }
                        */ else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorHijos"))){                          
                        	logger.error("cotizar-obteniendo factor Hijos");
                        	valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,parametros.getInsuredRut());                        	
                        }	else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorSocioEconomico"))
                                && datosEquifax != null) {
                            logger.error("cotizar-obteniendo factor SOCIO_ECONOMICO");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    String.valueOf(datosEquifax.getCodGse()));
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorZona"))) {
                            logger.error("cotizar-obteniendo factor ZONA_GEOGRAFICA");
                            Double factorZona = null;
                            /* Orden de prioridad ciudad entrante (viene comuna), region entrante, comuna
                            equifax,region equifax.*/
                            factorZona = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    String.valueOf(parametros.getCity()));
                            if (factorZona == null || factorZona.equals(0D)) {
                                factorZona = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                        String.valueOf(parametros.getState()));
                            }
                            if ((factorZona == null || factorZona.equals(0D)) && datosEquifax != null) {
                                factorZona = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                        datosEquifax.getComunaParticular());
                            }
                            if ((factorZona == null || factorZona.equals(0D)) && datosEquifax != null) {
                                factorZona = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                        datosEquifax.getRegionParticular());
                            }
                            if (null != factorZona && factorZona < 1) {
                                valorFactor = factorZona;
                            } else {
                                valorFactor = Double.valueOf("1");
                            }

                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorPromocion"))) {
                            logger.error("cotizar-obteniendo factor PROMOCION");
                            valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,
                                    LLAVE_PROMOCION);
                            
                        } else if (identificadorFactor.equals((Long) getPrincipal.lookup("factorRut"))){                          
                        	logger.error("cotizar-obteniendo factor Hijos");
                        	valorFactor = obtenerValor(parametros.getIntermediate(), identificadorFactor,parametros.getInsuredRut());                        	
                        }
                        
                        else {
                            logger.error("cotizar-factor no configurado en la aplicacion, no registrado en FactoresEnum.");
                            // Asigna valor por defecto si no se encuentra el identificador del factor.
                            valorFactor = asignaValorDefecto(listFormula.get(i).getIdTipoFactor());
                        }
                        if (valorFactor == null) {
                            logger.error("cotizar-llave no registrada en detalle de factores.");
                            // Asigna valor por defecto si no encuentra la llave en el detalle de los factores.
                            valorFactor = asignaValorDefecto(listFormula.get(i).getIdTipoFactor());
                        }
                        logger.error("cotizar-obteniendo identificadorFactor: " + identificadorFactor + " valorFactor:"
                                + valorFactor);
                        hmFactorValor.put(identificadorFactor, valorFactor);
                    }
                }
            }
            return hmFactorValor;
        } catch (NamingException e) {
            logger.error("cotizar-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
    }

    private List<ProductoTO> getListaProductos(Map<Long, DetalleProducto> hmProductoDeducible,
            Map<Long, List<Formula>> hmProductoFormula, Map<Long, Double> hmFactorValor, Double factorSisgen) {
        List<ProductoTO> listProductos = new ArrayList<ProductoTO>();
        for (Map.Entry<Long, DetalleProducto> entry : hmProductoDeducible.entrySet()) {
            List<Formula> listFormula = hmProductoFormula.get(entry.getKey());

            Double factorSuma = Double.valueOf(0);
            Double factorMultiplica = Double.valueOf(1);
            Double factorResta = Double.valueOf(0);
            for (int i = 0; i < listFormula.size(); i++) {
                 if (SUMA.equals(listFormula.get(i).getIdTipoFactor())) {
                	
                    factorSuma = factorSuma + hmFactorValor.get(listFormula.get(i).getIdFactor());
                    
                } else if (RESTA.equals(listFormula.get(i).getIdTipoFactor())) {

                    factorResta = factorResta + hmFactorValor.get(listFormula.get(i).getIdFactor());
                    
                } else if (MULTIPLICACION.equals(listFormula.get(i).getIdTipoFactor())) {

                    factorMultiplica = factorMultiplica * hmFactorValor.get(listFormula.get(i).getIdFactor());
                }
            }

            DetalleProducto detalle = entry.getValue();
            List<Tarifa> listadoTarifas = new ArrayList<Tarifa>();
            Tarifa tarifa = null;
            String nombreProducto = "";
            // Recorre deducibles por producto.
            for (int i = 0; i < detalle.getListDeducible().size(); i++) {
                tarifa = new Tarifa();
                tarifa.setDeducible(detalle.getListDeducible().get(i).getNombreDeducible());
                // Aplica formula por deducible.
                Double total = detalle.getListDeducible().get(i).getTarifaBase() * factorSisgen * factorMultiplica
                        + factorSuma - factorResta;

                double totalRedondeado = redondearADosDecimales(total);

                tarifa.setPrecio(totalRedondeado);
                listadoTarifas.add(tarifa);
                nombreProducto = detalle.getListDeducible().get(i).getNombreProducto();
            }
            listProductos.add(new ProductoTO(nombreProducto, listadoTarifas));

        }
        return listProductos;
    }
    
    /**
     * Método encargado de obtener el factor SISGEN.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>1.0 versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param parametros
     *            objeto con listado de parametros.
     * @return Double valor del factor.
     * @throws Exception
     *             en caso de error.
     * @since 1.0
     */
    private Double obtenerSISGEN(ParametrosCotizador parametros) throws GeneralException {
        logger.error("obtenerSISGEN-Inicia parametros:" + parametros.toString());
        RutListaNegra rutListaNegra = null;
        Double factorSisgen = null;

        try {
            // Verifica si rut esta en lista negra.;
            String rutSinDv = parametros.getInsuredRut().substring(0, parametros.getInsuredRut().length() - 1);
            rutListaNegra = cotizadorDAO.consultarRutListaNegra(Long.valueOf(rutSinDv));
            //aqui hay algo raro
            factorSisgen = rutListaNegra.getValor();

            if (factorSisgen == null) {
                // Si rut no esta en lista negra va a obtener siniestros a WS de AACH o bd local.
                factorSisgen = this.obtenerInformacionAACH(parametros);
            }else{
            	//throw new CotizadorException("Tarifa base no encontrada");
            	//TODO WLADIMIR - 04/04/2017 - Modificacion para evitar cotizacion por lista negras
            	return Double.parseDouble("-1");
            }

            logger.error("obtenerSISGEN-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerSISGEN-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerSISGEN-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
        return factorSisgen;
    }

    /**
     * Método encargado de obtener informacion del WS de la AACH.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>1.0 versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param parametros
     *            Objeto con listado de parametros.
     * @return Double Factor sisgen.
     * @throws Exception
     *             en caso de error.
     * @since 1.0
     */
    private Double obtenerInformacionAACH(ParametrosCotizador parametros) throws GeneralException {
        logger.error("obtenerInformacionAACH-Inicia parametros:" + parametros.toString());
        Double factorSisgenTMP;
        Double montoSiniestros = null;
        Long cantidadSiniestros = null;
        String ramo1= null;
        String ramo2= null;
        String ramo3= null;
        try {
            Context getPrincipal = (Context) new InitialContext().lookup(COMP);
            
           if((Boolean) getPrincipal.lookup("aachConsultaServicio")){
            JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
            factory.setServiceClass(AACHCarClaimInformationPortType.class);
            factory.setAddress((String) getPrincipal.lookup("aachEndPoint"));
            factory.setBindingId(SoapBindingFactory.SOAP_12_BINDING);
            AACHCarClaimInformationPortType service = (AACHCarClaimInformationPortType) factory.create();
            
            //incluye ramo Wladimir Verdugo
            
            ramo1=(String) getPrincipal.lookup("ramo1");
            ramo2=(String) getPrincipal.lookup("ramo2");
            ramo3=(String) getPrincipal.lookup("ramo3");
    
            // Ejecuta servicio
            GetAACHCarClaimInformationRSPType infoSalida = service.getList(getAachRequest(parametros));

            // Nodo Padre "<SISGEN>" con los siniestros.
            logger.error("obtenerInformacionAACH-obteniendo Nodo Padre <SISGEN> con los siniestros.");            
            
            String estado = infoSalida.getResponseHeader().getResult().getStatus();            
            if(ESTADO_EXITO_AACH.equals(estado)){
                montoSiniestros = Double.valueOf(0);
                cantidadSiniestros = Long.valueOf(0);
                Node nodo = infoSalida.getBody().getGetListCarClaimResponse().getReturn().getAny().getFirstChild()
                        .getNextSibling().getFirstChild();
                if ("Error".equals(nodo.getFirstChild().getFirstChild().getNodeName())) {
                    logger.error(nodo.getFirstChild().getFirstChild().getFirstChild().getTextContent());
                }else{
                    // Listado de siniestros.
                    logger.error("obtenerInformacionAACH-Listado de siniestros.");
                    NodeList list = nodo.getChildNodes();
                    Node siniestro;
                    cantidadSiniestros = Long.valueOf(list.getLength());
        
                    logger.error("obtenerInformacionAACH-Recorro los siniestros encontrados.");
                    // Se recorre el siniestro patrfyra encontrar su costo
                    Map<String, String> map = new HashMap<String, String>();
                    for (int i = 0; i < list.getLength(); i++) {
                        siniestro = list.item(i);
                        NodeList listSiniestro = siniestro.getChildNodes();
                        // Por cada siniestro busco el tag Costo.
                        String ramo = null;
                        String nroSiniestro=null;
                        String valor="0";
                        for (int x = 0; x < listSiniestro.getLength(); x++) {
                        	
                        	
                         	//wladimir valida que solo ingresen siniestros de autos
							if (listSiniestro.item(x).getLocalName()
									.equalsIgnoreCase("Ramo")) {
								ramo = listSiniestro.item(x).getFirstChild()
										.getNodeValue();
								if (ramo.equals(ramo1) || ramo.equals(ramo2)
										|| ramo.equals(ramo3)) {
								} else {
									break;
								}

							}
							
							
							//obtengo numero de siniestro wladimir
							 if (listSiniestro.item(x).getLocalName().equalsIgnoreCase("NroSiniestro")) {
	                                nroSiniestro = listSiniestro.item(x).getFirstChild().getNodeValue();
	                                logger.error("Numero de Siniestro:" + nroSiniestro);
	                                map.put(nroSiniestro, valor);
                                
	                                
	                             }
                       		
							
							
                        	
                        	
                        	
                            if (listSiniestro.item(x).getLocalName().equalsIgnoreCase("CostoTotal")) {
                                String costoTotal = listSiniestro.item(x).getFirstChild().getNodeValue();
                                logger.error("obtenerInformacionAACH-Monto encontrado:" + costoTotal);
                                montoSiniestros += Double.valueOf(costoTotal);
                                break;
                            }
                            
                            
                        }
                    }
                    cantidadSiniestros=(long) map.size();
                }
            }            
            logger.error("obtenerInformacionAACH-Fin Ok");
           }else{
        	   logger.error("obtenerInformacionAACH-Fin False");        	  
           }
        
        } catch (Exception e) {
            logger.error("obtenerInformacionAACH-Fin Error Exception:" + e.getMessage(), e);
            montoSiniestros = null;
            cantidadSiniestros = null;
        } finally{
            logger.error("obtenerInformacionAACH-montoSiniestros:" + montoSiniestros);
            logger.error("obtenerInformacionAACH-cantidadSiniestros:" + cantidadSiniestros);
            String rutRelleno = StringUtil.rellenaPorLaIzquierda(parametros.getInsuredRut().toUpperCase(), 10, '0');
            logger.info("Se obtendra factor AACH contingencia para rut[" + rutRelleno + "]");
            factorSisgenTMP = cotizadorDAO.obtenerFactorAach(rutRelleno, cantidadSiniestros, montoSiniestros);
            logger.error("obtenerInformacionAACH-factorSisgenTMP:" + factorSisgenTMP);
            logger.error("obtenerInformacionAACH-Fin");
        }
        return factorSisgenTMP;
    }
    
    private GetAACHCarClaimInformationREQType getAachRequest(ParametrosCotizador parametros) throws Exception {
        GetAACHCarClaimInformationREQType parametrosEntrada = new GetAACHCarClaimInformationREQType();
        Context getPrincipal = (Context) new InitialContext().lookup(COMP);

        parametrosEntrada.setRequestHeader(new RequestHeaderType());
        parametrosEntrada.getRequestHeader().setConsumer(new ConsumerType());
        parametrosEntrada.getRequestHeader().getConsumer()
                .setCode((Integer) getPrincipal.lookup("aachConsumerCode"));
        parametrosEntrada.getRequestHeader().getConsumer()
                .setName((String) getPrincipal.lookup("aachConsumerName"));
        parametrosEntrada.getRequestHeader().setTrace(new TraceType());
        parametrosEntrada.getRequestHeader().setCountry(new CountryType());
        parametrosEntrada.getRequestHeader().getCountry().setCode((Integer) getPrincipal.lookup("aachCountryCode"));
        parametrosEntrada.getRequestHeader().getCountry().setName((String) getPrincipal.lookup("aachCountryName"));
        parametrosEntrada.getRequestHeader().setChannel(new ChannelType());
        parametrosEntrada.getRequestHeader().getChannel().setCode((String) getPrincipal.lookup("aachChannelCode"));
        parametrosEntrada.getRequestHeader().getChannel().setMode((String) getPrincipal.lookup("aachChannelMode"));
        
        parametrosEntrada.setBody(new Body());
        parametrosEntrada.getBody().setGetAACHCarClaimInformation(new GetAACHCarClaimInformation());
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setRut(StringUtil.rellenaPorLaIzquierda(parametros.getInsuredRut(), LARGO_RUT_WS, '0'));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setQueryType((String) getPrincipal.lookup("aachQueryType"));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation().setPlate(parametros.getPlate());
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setUser((String) getPrincipal.lookup("aachUserWS"));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setPass((String) getPrincipal.lookup("aachPassWS"));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation().setCompanyRut(
                StringUtil.rellenaPorLaIzquierda((String) getPrincipal.lookup("aachCompanyRut"),LARGO_RUT_WS, '0'));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setUserName((String) getPrincipal.lookup("aachUserName"));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation()
                .setUserObs((String) getPrincipal.lookup("aachUserObs"));
        //Se calcula fecha de antiguedad de siniestros
        Calendar fecha = Calendar.getInstance();
        fecha.add(Calendar.YEAR, -(Integer)getPrincipal.lookup("aachAniosAntiguedadSiniestros"));
        parametrosEntrada.getBody().getGetAACHCarClaimInformation().setDateFrom(new SimpleDateFormat("yyyyMMdd").format(fecha.getTime()));
        
        return parametrosEntrada;
    }

    /**
     * Método encargado de obtener listado de formula asociado al producto.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>1.0 versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param idProducto
     *            identificador del producto.
     * @return List<Formula> listado con formulas.
     * @throws CotizadorDaoException
     *             en caso de error.
     * @since 1.0
     */
    private List<Formula> obtenerFormula(Long idProducto) throws GeneralException {
        logger.error("obtenerFormula-Inicia idProducto:" + idProducto);
        List<Formula> formula = null;
        try {
            formula = cotizadorDAO.obtenerFormula(idProducto);
            if (formula != null) {
                logger.error("obtenerFormula-formula:" + formula.size());
            }
            logger.error("obtenerFormula-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerFormula-Fin Error CotizadorDaoException:" + e.getMessage(), e);
            throw e;
        }
        return formula;
    }

    /**
     * Método encargado de obtener el valor de un factor determindado.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>1.0 versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param idSocio
     *            identificador del socio.
     * @param idFactor
     *            identificador del factor.
     * @param llave
     *            llave del factor.
     * @return valor del factor.
     * @throws CotizadorDaoException
     *             en caso de error.
     * @since 1.0
     */
    private Double obtenerValor(Long idSocio, Long idFactor, String llaveEntrante) throws GeneralException {
        logger.error("obtenerValor-Inicia idSocio:" + idSocio + " idFactor:" + idFactor + " llave:" + llaveEntrante);
        Double valor = null;
        String llave = null;
        try {
            if (llaveEntrante != null) {
                llave = llaveEntrante.toUpperCase();
            }
            valor = cotizadorDAO.obtenerValorFactor(idSocio, idFactor, llave);
            logger.error("obtenerValor-valor:" + valor);
            logger.error("obtenerValor-Fin Ok");
        } catch (CotizadorDaoException e) {
            logger.error("obtenerValorFactor idSocio:" + idSocio + ", idFactor:" + idFactor + ", llave:" + llave + ". "
                    + e.getMessage(), e);
        }
        return valor;
    }

    /**
     * Método encargado de redondear un double a dos decimales.
     * <p>
     * <b>Registro de versiones:</b>
     * <ul>
     * <li>1.0 (Imagemaker IT): versión inicial</li>
     * </ul>
     * </p>
     * 
     * @param redondeame
     *            numero a redondear.
     * @return numero redondeado a 2 decimales.
     * @since 1.0
     */
    private double redondearADosDecimales(double redondeame) {
        return Math.round(redondeame * 100.0) / 100.0;
    }

    private Double asignaValorDefecto(Long factor) {
        logger.error("se asigna valor por defecto.");
        Double valor = null;
        if (SUMA.equals(factor) || RESTA.equals(factor)) {
            valor = Double.valueOf(0);
        }
        if (MULTIPLICACION.equals(factor)) {
            valor = Double.valueOf(1);
        }
        return valor;
    }

    private EstadoOperacionCotizacion validaParametrosEntrada(ParametrosCotizador parametros) throws GeneralException {
        logger.error("validaParametrosEntrada-Inicia");
        try {
            EstadoOperacionCotizacion estadoOperacion = new EstadoOperacionCotizacion();
            estadoOperacion.setCodigoEstado(Long.valueOf("0"));
            StringUtil stringUtil = new StringUtil();
            Long codigoError = Long.valueOf("1");
            
            if (parametros.getChannel() == 0) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'channel' es obligatorio");
            } else if (parametros.getIntermediate() == null || parametros.getIntermediate().equals(VALOR_CERO)) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'intermediate' es obligatorio");
            } else if (parametros.getInsuredRut() == null || "".equals(parametros.getInsuredRut())) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'insuredRut' es obligatorio");
            } else if (!stringUtil.validaRut(parametros.getInsuredRut())) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"El rut de asegurado es invalido");
            } else if (parametros.getBrand() == null || parametros.getBrand().equals(VALOR_CERO)) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'brand' es obligatorio");
            } else if (parametros.getModel() == null || parametros.getModel().equals(VALOR_CERO)) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'model' es obligatorio");
            } else if (parametros.getVersion() == null || parametros.getVersion().equals(VALOR_CERO)) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'version' es obligatorio");
            } else if (parametros.getYear() == null || parametros.getYear() < 1000) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'year' es obligatorio");
            } else if (parametros.getDateOfBirth() == null) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"Campo 'dateOfBirth' es obligatorio");
            } else if (FechasUtil.calculaEdad(parametros.getDateOfBirth()) < 18) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"El asegurado es menor de edad");
            } else if (FechasUtil.calculaEdad(parametros.getDateOfBirth()) > 90) {
                estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"El asegurado se encuentra fuera del rango de edad maximo");
            } else {
                // Se calculan años de inicio y fin de la antiguedad del vehiculo permitida
                Integer antiguedadMaxima = (Integer) ((Context) new InitialContext().lookup(COMP))
                        .lookup("parametrosCotizadorAntiguedadVehiculoMaximo");
                Calendar fechaInicio = Calendar.getInstance();
                fechaInicio.add(Calendar.YEAR, -antiguedadMaxima);
                Integer anioInicio = fechaInicio.get(Calendar.YEAR);
                Calendar fechaFin = Calendar.getInstance();
                Integer anioFin = fechaFin.get(Calendar.YEAR);

                // A partir de septiembre de cada año se suma un año al año de inicio.
                if (fechaFin.get(Calendar.MONTH) > Calendar.AUGUST) {
                    anioFin += 1;
                }
                if (parametros.getYear() < anioInicio || parametros.getYear() > anioFin) {
                    estadoOperacion =  new EstadoOperacionCotizacion(codigoError,"La antiguedad del vehiculo no es permitida.");
                }
            }
            logger.error(estadoOperacion.getDescripcionEstado());
            logger.error("validaParametrosEntrada-Fin Ok");
            return estadoOperacion;
        } catch (NamingException e) {
            logger.error("validaParametrosEntrada-Fin Error Exception:" + e.getMessage(), e);
            throw new GeneralException(e);
        }
    }

}
