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
import cl.cardif.cotizador.wsCotizador.mapper.VersionMapper;

public class ObtenerModelosSP extends StoredProcedure {

    @SuppressWarnings("rawtypes")
    public ObtenerModelosSP(JdbcTemplate jdbcTemplate) {
        super(jdbcTemplate, ConstantesDAO.NOMBRE_SP_OBTENER_MODELOS);

        RowMapper rowMapper = new VersionMapper();

        declareParameter(new SqlParameter(ConstantesDAO.MODELOS_ID_MARCA, Types.NUMERIC));
        declareParameter(new SqlOutParameter(ConstantesDAO.COD_RESPUESTA, Types.INTEGER));
        declareParameter(new SqlOutParameter(ConstantesDAO.DESC_RESPUESTA, Types.VARCHAR));
        declareParameter(new SqlOutParameter(ConstantesDAO.MODELOS_CURSOR_MODELO, OracleTypes.CURSOR, rowMapper));

        compile();
    }

    public Map<String, Object> obtenerModelos(Long idMarca) {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put(ConstantesDAO.MODELOS_ID_MARCA, idMarca);
        return execute(parametros);

    }
}
