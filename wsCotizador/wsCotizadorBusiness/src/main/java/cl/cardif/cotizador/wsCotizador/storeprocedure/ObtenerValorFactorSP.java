package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;

public class ObtenerValorFactorSP extends StoredProcedure {

    public ObtenerValorFactorSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_VALOR_FACTOR);

        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_ID_SOCIO, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_ID_FACTOR, Types.NUMERIC));
        declareParameter(new SqlParameter(ConstantesDAO.FACTOR_LLAVE_FACTOR, Types.VARCHAR));

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.FACTOR_VALOR_FACTOR, Types.DOUBLE));

        compile();
    }

    public Map<String, Object> obtenerValorFactor(Long idSocio, Long idFactor, String llave) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.FACTOR_ID_SOCIO, idSocio);
        parametros.put(ConstantesDAO.FACTOR_ID_FACTOR, idFactor);
        parametros.put(ConstantesDAO.FACTOR_LLAVE_FACTOR, llave);
        logger.info("obtenerValorFactor-Parametros:" + ConstantesDAO.NOMBRE_SP_VALOR_FACTOR + parametros);
        return execute(parametros);
    }
}
