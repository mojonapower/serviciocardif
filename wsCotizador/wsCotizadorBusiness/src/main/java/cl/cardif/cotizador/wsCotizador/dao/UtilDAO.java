package cl.cardif.cotizador.wsCotizador.dao;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.exception.CotizadorDaoException;
import cl.cardif.cotizador.wsCotizador.model.RutListaNegra;
import cl.cardif.cotizador.wsCotizador.storeprocedure.ListaNegraSP;

public class UtilDAO {
	
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    protected JdbcTemplate jdbcTemplate;

    @Autowired
    protected JdbcTemplate jdbcTemplateExterno;

    
    /**
     * Genera una excepción en caso que el codigo de respuesta sera diferente a 0.
     * 
     * @param codigoError
     * @param descError
     * @throws DAOException
     */
    protected void procesaExcepcion(Integer codigoError, String descError) throws CotizadorDaoException {
        logger.debug("codigoError: "+codigoError+" - "+"descError: "+descError);
        if (codigoError != null && codigoError != 0) {
            throw new CotizadorDaoException(codigoError, descError, (Throwable) null);
        }
    }
    
    /**
     * Genera una excepcion en caso que el código respuesta sea diferente a 1. Este código de exito es para los SP propios de cardif.
     * @param codigoError
     * @param descError
     * @throws CotizadorDaoException
     */
    protected void procesaExcepcionCardif(Integer codigoError, String descError) throws CotizadorDaoException {
        logger.debug("codigoError: "+codigoError+" - "+"descError: "+descError);
        if (codigoError != null && codigoError != 1) {
            throw new CotizadorDaoException(codigoError, descError, (Throwable) null);
        }
    }
    
    public RutListaNegra consultarRutListaNegra(Long rut) throws CotizadorDaoException {
        logger.info("consultarRutListaNegra-Inicia");
        RutListaNegra rutListaNegra = new RutListaNegra();
        try {
            ListaNegraSP listaNegraSP = new ListaNegraSP(jdbcTemplate);
            Map<String, Object> resultado = listaNegraSP.consultarRutListaNegra(rut);
            Integer codigo = (Integer) resultado.get(ConstantesDAO.COD_RESPUESTA);
            String desc = (String) resultado.get(ConstantesDAO.DESC_RESPUESTA);
            Double factor = (Double) resultado.get(ConstantesDAO.LISTA_NEGRA_FACTOR);

            rutListaNegra.setCodigo(codigo);
            rutListaNegra.setDescripcion(desc);
            rutListaNegra.setValor(factor);
            logger.info("consultarRutListaNegra-codigo:" + codigo);
            logger.info("consultarRutListaNegra-desc:" + desc);
            logger.info("consultarRutListaNegra-factor:" + factor);
            logger.info("consultarRutListaNegra-Fin Ok");
        } catch (Exception e) {
            logger.error("consultarRutListaNegra-Fin Error Exception:" + e.getMessage(), e);
            throw new CotizadorDaoException("Error al consultar lista negra", e);
        }

        return rutListaNegra;
    }
   
}
