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
import cl.cardif.cotizador.wsCotizador.mapper.EquifaxMapper;

public class ObtenerDatosEquifaxSP extends StoredProcedure {

    public ObtenerDatosEquifaxSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_DATOS_EQUIFAX);

        RowMapper rowMapper = new EquifaxMapper();

        declareParameter(new SqlParameter(ConstantesDAO.EQUIFAX_RUT, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.EQUIFAX_CURSOR_EQUIFAX, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerDatosEquifaxSP(String rut) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.EQUIFAX_RUT, rut);
        logger.info("obtenerDatosEquifaxSP-Parametros:" + ConstantesDAO.NOMBRE_SP_OBTENER_DATOS_EQUIFAX + parametros);
        return execute(parametros);

    }
}
