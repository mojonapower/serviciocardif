package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.mapper.SocioMapper;

public class ObtenerSocioSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerSocioSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_SOCIO);

        RowMapper rowMapper = new SocioMapper();

        declareParameter(new SqlParameter(ConstantesDAO.CANAL_SOCIO, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.CURSOR_SOCIO, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerIntermediarios(Long idCanal) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.CANAL_SOCIO, idCanal);
        logger.info("obtenerIntermediarios-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_SOCIO + parametros);
        return execute(parametros);

    }
}
