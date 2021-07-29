package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ObtenerFactorAachSP extends StoredProcedure {

    public ObtenerFactorAachSP(JdbcTemplate jdbcTemplate) {

        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_FACTOR_AACH);

        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_AACH_RUT_CLIENTE, Types.VARCHAR));
        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_AACH_CANT_SINIESTRO, Types.INTEGER));
        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_AACH_MONTO_SINIESTRO, Types.DOUBLE));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.FACTOR_AACH_FACTOR, Types.DOUBLE));
        compile();
    }

    public Map<String, Object> obtenerFactorAach(String rut, Long cantSiniestro, Double montoSiniestro) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.FACTOR_AACH_RUT_CLIENTE, rut);
        parametros.put(ConstantesDAO.FACTOR_AACH_CANT_SINIESTRO, cantSiniestro);
        parametros.put(ConstantesDAO.FACTOR_AACH_MONTO_SINIESTRO, montoSiniestro);
        logger.info("obtenerFactorAach-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_FACTOR_AACH + parametros);
        return execute(parametros);

    }
}
