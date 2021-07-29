package cl.cardif.cotizador.wsCotizador.storeprocedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import oracle.jdbc.driver.OracleTypes;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;

import cl.cardif.cotizador.wsCotizador.constant.ConstantesDAO;
import cl.cardif.cotizador.wsCotizador.mapper.CanalMapper;

public class ObtenerCanalesSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerCanalesSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_CANALES);

        RowMapper rowMapper = new CanalMapper();

        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.CURSOR_CANAL, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerCanales() {
        Map<String, Object> parametros = new HashMap<String, Object>();
        return execute(parametros);

    }

}
