package cl.cardif.cotizador.wsCotizador.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.dao.CotizadorDAO;
import cl.cardif.cotizador.wsCotizador.dao.UtilDAO;
import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.model.Equifax;
import cl.cardif.cotizador.wsCotizador.model.Formula;
import cl.cardif.cotizador.wsCotizador.model.TarifaBase;
import cl.cardif.cotizador.wsCotizador.storeprocedure.InsertarLogSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerDatosEquifaxSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerFactorAachSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerFormulaSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerTarifaBaseSP;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ObtenerValorFactorSP;

@Component
public class CotizadorDAOImpl extends UtilDAO implements CotizadorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * Atributo para loguear la clase.
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public Double obtenerFactorAach(String rut, Long cantSiniestro, Double montoSiniestro) throws CotizadorDaoException {
        logger.info("obtenerFactorAach-Inicia");

        try {
            ObtenerFactorAachSP obtenerFactorAachSP = new ObtenerFactorAachSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerFactorAachSP.obtenerFactorAach(rut, cantSiniestro, montoSiniestro);
            Integer codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
            String desc = (String) resultado.get(ConstantesDAO.DESC_RESPUESTA);
            Double factor = (Double) resultado.get(ConstantesDAO.FACTOR_AACH_FACTOR);
            logger.info("obtenerFactorAach-codigo:" + codigo);
            logger.info("obtenerFactorAach-desc:" + desc);
            logger.info("obtenerFactorAach-factor:" + factor);
            logger.info("obtenerFactorAach-Fin Ok");

            return factor;
        } catch (Exception e) {
            logger.error("obtenerFactorAach-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al obtener factor AACH", e);

        }

    }

    @Override
    public Equifax obtenerInfoEquifax(String rut) throws CotizadorDaoException {
        logger.info("obtenerInfoEquifax-Inicia");
        List<Equifax> datosEquifax = null;
        Equifax equifax = null;
        try {
            ObtenerDatosEquifaxSP obtenerDatosEquifaxSP = new ObtenerDatosEquifaxSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerDatosEquifaxSP.obtenerDatosEquifaxSP(rut);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            datosEquifax = (List<Equifax>) resultado.get(ConstantesDAO.EQUIFAX_CURSOR_EQUIFAX);
            logger.info("obtenerInfoEquifax-datosEquifax:" + datosEquifax);
            logger.info("obtenerInfoEquifax-Fin Ok");
            if (datosEquifax.size() > 0) {
                equifax = datosEquifax.get(0);
            }
        } catch (CotizadorDaoException e) {
            logger.error("obtenerInfoEquifax:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerInfoEquifax:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerInfoEquifax", e);
        }
        return equifax;
    }

    @Override
    public List<TarifaBase> obtenerTarifaBase(int canal, Long idSocio, Long idProducto, Long idMarca, Long idModelo,
            Long idVersion) throws CotizadorDaoException {
        logger.info("obtenerTarifaBase-Inicia");
        try {
            ObtenerTarifaBaseSP obtenerTarifaBaseSP = new ObtenerTarifaBaseSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerTarifaBaseSP.obtenerTarifaBaseSP(canal, idSocio, idProducto,
                    idMarca, idModelo, idVersion);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<TarifaBase>) resultado.get(ConstantesDAO.TBASE_CURSOR_TARIFA_BASE);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerTarifaBase:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerTarifaBase:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerTarifaBase", e);
        }
    }

    @Override
    public List<Formula> obtenerFormula(Long idProducto) throws CotizadorDaoException {
        logger.info("obtenerFormula-Inicia");
        try {
            ObtenerFormulaSP obtenerFormulaSP = new ObtenerFormulaSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerFormulaSP.obtenerFormula(idProducto);
            logger.info("obtenerValorFactor-codigo:" + resultado);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            return (List<Formula>) resultado.get(ConstantesDAO.FORMULA_CURSOR_FORMULA);
        } catch (CotizadorDaoException e) {
            logger.error("obtenerFormula:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerFormula:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerFormula", e);
        }
    }

    @Override
    public Double obtenerValorFactor(Long idSocio, Long idFactor, String llave) throws CotizadorDaoException {
        logger.info("obtenerValorFactor-Inicia");
        try {
            ObtenerValorFactorSP obtenerValorFactorSP = new ObtenerValorFactorSP(jdbcTemplate);
            Map<String, Object> resultado = obtenerValorFactorSP.obtenerValorFactor(idSocio, idFactor, llave);
            logger.info("obtenerValorFactor-resultado:" + resultado);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            Double valorFactor = (Double) resultado.get(ConstantesDAO.FACTOR_VALOR_FACTOR);
            logger.info("obtenerValorFactor-valorFactor:" + valorFactor);
            logger.info("obtenerValorFactor-Fin Ok");
            return valorFactor;
        } catch (CotizadorDaoException e) {
            logger.error("obtenerValorFactor:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("obtenerValorFactor:" + e.getMessage(), e);
            throw new CotizadorDaoException("obtenerValorFactor", e);
        }
    }

    @Override
    public Double insertarLog(ParametrosCotizador parametros, String xmlCotizacion) throws CotizadorDaoException {
        logger.info("insertarLog-Inicia");
        try {
            InsertarLogSP insertarLogSP = new InsertarLogSP(jdbcTemplate);
            Map<String, Object> resultado = insertarLogSP.insertarLogSP(parametros, xmlCotizacion);
            logger.info("insertarLog-resultado:" + resultado);
            this.procesaExcepcion((Integer) resultado.get(ConstantesDAO.COD_RESPUESTA),
                    (String) resultado.get(ConstantesDAO.DESC_RESPUESTA));
            Double idCotizacion = (Double) resultado.get(ConstantesDAO.LOG_ID_COTIZACION_SOCIO);
            logger.info("insertarLog-idCotizacion:" + idCotizacion);
            logger.info("insertarLog-Fin Ok");
            return idCotizacion;
        } catch (CotizadorDaoException e) {
            logger.error("insertarLog:" + e.getDescripcionError(), e);
            throw e;
        } catch (Exception e) {
            logger.error("insertarLog:" + e.getMessage(), e);
            throw new CotizadorDaoException("insertarLog", e);
        }

    }

}
