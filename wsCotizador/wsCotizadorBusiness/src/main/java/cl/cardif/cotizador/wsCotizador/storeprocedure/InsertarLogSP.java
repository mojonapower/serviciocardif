package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.dto.ParametrosCotizador;

public class InsertarLogSP extends StoredProcedure {

    public InsertarLogSP(JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_INSERT_LOG);

        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_CANAL, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_SOCIO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_PRODUCTO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_MARCA, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_MODELO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ID_VERSION, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_PATENTE, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ANIO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_RUT, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_NOMBRES, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_FECHA_NACIMIENTO, Types.DATE));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_SEXO, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_ESTADO_CIVIL, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_REGION, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_COMUNA, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.LOG_COTIZACION_EXTERNO, Types.VARCHAR));

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.LOG_ID_COTIZACION_SOCIO, Types.DOUBLE));
        compile();
    }

    public Map<String, Object> insertarLogSP(ParametrosCotizador parametrosCotizador, String xmlCotizacion) {
        Long productCode = parametrosCotizador.getProductoCode();
        if(parametrosCotizador.getProductoCode()==null){
            productCode = 0L;
        }
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.LOG_ID_CANAL, parametrosCotizador.getChannel());
        parametros.put(ConstantesDAO.LOG_ID_SOCIO, parametrosCotizador.getIntermediate());        
        parametros.put(ConstantesDAO.LOG_ID_PRODUCTO, productCode);
        parametros.put(ConstantesDAO.LOG_ID_MARCA, parametrosCotizador.getBrand());
        parametros.put(ConstantesDAO.LOG_ID_MODELO, parametrosCotizador.getModel());
        parametros.put(ConstantesDAO.LOG_ID_VERSION, parametrosCotizador.getVersion());
        parametros.put(ConstantesDAO.LOG_PATENTE, parametrosCotizador.getPlate());
        parametros.put(ConstantesDAO.LOG_ANIO, parametrosCotizador.getYear());
        parametros.put(ConstantesDAO.LOG_RUT, parametrosCotizador.getInsuredRut());
        parametros.put(ConstantesDAO.LOG_NOMBRES, parametrosCotizador.getInsuredNames());
        parametros.put(ConstantesDAO.LOG_FECHA_NACIMIENTO, parametrosCotizador.getDateOfBirth());
        parametros.put(ConstantesDAO.LOG_SEXO, parametrosCotizador.getGender());
        parametros.put(ConstantesDAO.LOG_ESTADO_CIVIL, parametrosCotizador.getMaritalStatus());
        parametros.put(ConstantesDAO.LOG_REGION, parametrosCotizador.getState());
        parametros.put(ConstantesDAO.LOG_COMUNA, parametrosCotizador.getCity());
        parametros.put(ConstantesDAO.LOG_RESPUESTA, xmlCotizacion);
        parametros.put(ConstantesDAO.LOG_COTIZACION_EXTERNO, parametrosCotizador.getIdQuoteIntermediate());

        logger.info("insertarLogSP-Parametros:" + ConstantesDAO.NOMBRE_SP_INSERT_LOG + parametros);
        return execute(parametros);

    }
}
